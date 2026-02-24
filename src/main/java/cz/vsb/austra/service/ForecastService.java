package cz.vsb.austra.service;

import cz.vsb.austra.connector.*;
import cz.vsb.austra.connector.openmeteo.OpenMeteoHourlyForecastConnector;
import cz.vsb.austra.connector.tomorrowio.TomorrowioForecastConnector;
import cz.vsb.austra.connector.weatherapicom.ForecastConnector;
import cz.vsb.austra.connector.weatherapicom.LocationConnector;
import cz.vsb.austra.dto.*;
import cz.vsb.austra.dto.ForecastDto;
import cz.vsb.austra.dto.openmeteo.HourlyForecastDto;
import cz.vsb.austra.dto.openmeteo.OpenMeteoHourly;
import cz.vsb.austra.dto.tomorrowio.TomorrowioHourlyDto;
import cz.vsb.austra.dto.tomorrowio.forecast.TomorrowForecastApiDto;
import cz.vsb.austra.dto.weatherapi.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ForecastService {
    OpenMeteoHourlyForecastConnector openMeteoHourlyForecastConnector;
    WmoWeatherConditionsConnector wmoWeatherConditionsConnector;
    ForecastConnector connector;
    SunriseSunsetConnector sunriseSunsetConnector;
    TomorrowioForecastConnector tomorrowioForecastConnector;

    @Autowired
    public ForecastService(ForecastConnector connector, SunriseSunsetConnector sunriseSunsetConnector, OpenMeteoHourlyForecastConnector openMeteoHourlyForecastConnector, WmoWeatherConditionsConnector weatherConditionsConnector, TomorrowioForecastConnector tomorrowioForecastConnector) {
        this.connector = connector;
        this.sunriseSunsetConnector = sunriseSunsetConnector;
        this.openMeteoHourlyForecastConnector = openMeteoHourlyForecastConnector;
        this.wmoWeatherConditionsConnector = weatherConditionsConnector;
        this.tomorrowioForecastConnector = tomorrowioForecastConnector;
    }

    public ForecastDto getWeatherForCity(String cityEnum) {
        ForecastApiDto forecastApiDto = connector.getForecastForCity(cityEnum);
        SearchLocation loc = new LocationConnector().getLocationForCity(cityEnum)[0];
        SunriseSunsetApiDto sunriseSunsetApiDto = sunriseSunsetConnector.getForecastForCity(loc.getLat(), loc.getLon());
        HourlyForecastDto openMeteoHourlyForecastDto = openMeteoHourlyForecastConnector.getExtendedHourlyWeatherForCity(loc.getLat(), loc.getLon());
        TomorrowForecastApiDto tomorrowForecastApiDto = tomorrowioForecastConnector.getTomorrowioForecastForCity(cityEnum);
        return transformDto(forecastApiDto, sunriseSunsetApiDto, openMeteoHourlyForecastDto, tomorrowForecastApiDto);
    }

    private ForecastDto transformDto(ForecastApiDto forecastApiDto, SunriseSunsetApiDto sunriseSunsetApiDto,
                                     HourlyForecastDto openMeteoHourlyForecastDto, TomorrowForecastApiDto tomorrowForecastApiDto) {

        ForecastDto forecastDto = new ForecastDto();

        mapWeatherApi(forecastApiDto, sunriseSunsetApiDto, openMeteoHourlyForecastDto, forecastDto);
        mapTomorrowIo(tomorrowForecastApiDto, forecastDto);

        return forecastDto;
    }

    /* ================= WEATHER API ================= */

    private void mapWeatherApi(
            ForecastApiDto forecastApiDto,
            SunriseSunsetApiDto sunriseDto,
            HourlyForecastDto openMeteoDto,
            ForecastDto forecastDto
    ) {

        List<Forecastday> forecastDays = forecastApiDto.getForecast().getForecastday();
        String location = forecastApiDto.getLocation().getName();
        var openMeteoHourly = openMeteoDto.getHourly();
        var sunriseResults = sunriseDto.getResults();

        for (int dayIndex = 0; dayIndex < forecastDays.size(); dayIndex++) {

            Forecastday fday = forecastDays.get(dayIndex);

            WeatherApiForecastDailyDto dailyDto = new WeatherApiForecastDailyDto();
            dailyDto.setSunMoonData(mapSunMoon(fday.getAstro(), sunriseResults));
            dailyDto.setMinMaxPrecipSnowData(mapDay(fday.getDay()));

            mapWeatherApiHours(
                    fday.getHour(),
                    openMeteoHourly,
                    dayIndex,
                    location,
                    dailyDto
            );

            forecastDto.getDailyData().add(dailyDto);
        }
    }

    private SunMoonAstroDto mapSunMoon(Astro astro, SunriseSunsetResults results) {
        SunMoonAstroDto dto = new SunMoonAstroDto();

        dto.setMoonrise(astro.getMoonrise());
        dto.setMoonset(astro.getMoonset());
        dto.setMoon_phase(astro.getMoon_phase());
        dto.setSunrise(astro.getSunrise());
        dto.setSunset(astro.getSunset());

        dto.setDawn(results.getDawn());
        dto.setDusk(results.getDusk());
        dto.setFirst_light(results.getFirst_light());
        dto.setLast_light(results.getLast_light());
        dto.setGoldenHour(results.getGolden_hour());
        dto.setDayLength(results.getDay_length());
        dto.setTimezone(results.getTimezone());

        return dto;
    }

    private MinMaxPrecipSnowDto mapDay(Day day) {
        MinMaxPrecipSnowDto dto = new MinMaxPrecipSnowDto();

        dto.setChance_of_snow(day.getDaily_chance_of_snow());
        dto.setChance_of_rain(day.getDaily_chance_of_rain());
        dto.setMax_temperature(day.getMaxtemp_c());
        dto.setMin_temperature(day.getMintemp_c());
        dto.setAvg_temperature(day.getAvgtemp_c());
        dto.setTotal_precip_mm(day.getTotalprecip_mm());
        dto.setTotal_snow_cm(day.getTotalsnow_cm());

        return dto;
    }

    private void mapWeatherApiHours(
            List<Hour> hours,
            OpenMeteoHourly openMeteoHourly,
            int dayIndex,
            String location,
            WeatherApiForecastDailyDto dailyDto
    ) {

        int start = dayIndex * 24;

        for (int j = 0; j < hours.size(); j++) {

            Hour hour = hours.get(j);

            dailyDto.getHourlyData().add(mapWeatherHour(hour, location));

            dailyDto.getOpenMeteoHourlyData().add(
                    mapOpenMeteoHour(openMeteoHourly, start + j)
            );
        }
    }

    private WeatherApiForecastHourlyDto mapWeatherHour(Hour hour, String location) {

        WeatherApiForecastHourlyDto dto = new WeatherApiForecastHourlyDto();

        dto.setLocation(location);
        dto.setRel_humidity(hour.getHumidity());
        dto.setTemp_celsius(hour.getTemp_c());
        dto.setTimestamp(hour.getTime());
        dto.setWeatherDescription(hour.getCondition().getText());
        dto.setWindDirection(hour.getWind_dir());
        dto.setWindSpeed_mps(Math.round(hour.getWind_kph() / 3.6));
        dto.setCloud(hour.getCloud());
        dto.setFeelslike_c(hour.getFeelslike_c());
        dto.setPressure_mb(hour.getPressure_mb());
        dto.setSnow_cm(hour.getSnow_cm());
        dto.setIcon(hour.getCondition().getIcon());
        dto.setPrecip_mm(hour.getPrecip_mm()); // fixed bug

        return dto;
    }

    private OpenMeteoHourlyDto mapOpenMeteoHour(OpenMeteoHourly hourly, int index) {

        OpenMeteoHourlyDto dto = new OpenMeteoHourlyDto();

        dto.setTime(hourly.getTime().get(index));
        dto.setCloud_cover(hourly.getCloud_cover().get(index));
        dto.setCloud_cover_high(hourly.getCloud_cover_high().get(index));
        dto.setCloud_cover_mid(hourly.getCloud_cover_mid().get(index));
        dto.setCloud_cover_low(hourly.getCloud_cover_low().get(index));
        dto.setPrecipitation(hourly.getPrecipitation().get(index));
        dto.setPrecipitation_probability(hourly.getPrecipitation_probability().get(index));
        dto.setRain(hourly.getRain().get(index));
        dto.setShowers(hourly.getShowers().get(index));
        dto.setSnow_depth(hourly.getSnow_depth().get(index));
        dto.setSnowfall(hourly.getSnowfall().get(index));
        dto.setTemperature_2m(hourly.getTemperature_2m().get(index));
        dto.setApparent_temperature(hourly.getApparent_temperature().get(index));
        dto.setRelative_humidity_2m(hourly.getRelative_humidity_2m().get(index));
        dto.setDew_point_2m(hourly.getDew_point_2m().get(index));
        dto.setPressure_msl(hourly.getPressure_msl().get(index));
        dto.setSurface_pressure(hourly.getSurface_pressure().get(index));
        dto.setVisibility(hourly.getVisibility().get(index));
        dto.setUv_index(hourly.getUv_index().get(index));
        dto.setSunshine_duration(hourly.getSunshine_duration().get(index));
        dto.setWind_speed_10m(hourly.getWind_speed_10m().get(index));
        dto.setWind_direction_10m(hourly.getWind_direction_10m().get(index));
        dto.setWind_gusts_10m(hourly.getWind_gusts_10m().get(index));
        dto.setWeather_code(hourly.getWeather_code().get(index));
        dto.setWeather_description(
                WeatherCondition.descriptionFromCode(hourly.getWeather_code().get(index))
        );

        return dto;
    }

    /* ================= TOMORROW IO ================= */

    private void mapTomorrowIo(
            TomorrowForecastApiDto tomorrowDto,
            ForecastDto forecastDto
    ) {

        var timelines = tomorrowDto.getTimelines();
        var dailyList = timelines.getDaily();
        var hourlyList = timelines.getHourly();

        for (int dayIndex = 0; dayIndex < dailyList.size(); dayIndex++) {

            int start = dayIndex * 24;
            int end = Math.min(start + 24, hourlyList.size());

            List<TomorrowioForecastHourDto> hours = new ArrayList<>(24);

            for (int i = start; i < end; i++) {
                hours.add(mapTomorrowHour(hourlyList.get(i)));
            }

            TomorrowioForecastDayDto dayDto = new TomorrowioForecastDayDto();
            dayDto.setTomorrowioForecastHourlyData(hours);

            forecastDto.getTomorrowioForecastDays().add(dayDto);
        }
    }

    private TomorrowioForecastHourDto mapTomorrowHour(TomorrowioHourlyDto hourly) {

        var values = hourly.getValues();

        TomorrowioForecastHourDto dto = new TomorrowioForecastHourDto();

        dto.setTime(hourly.getTime());
        dto.setHumidity(values.getHumidity());
        dto.setCloudCover(values.getCloudCover());
        dto.setDewPoint(values.getDewPoint());
        dto.setTemperature(values.getTemperature());
        dto.setPrecipitationProbability(values.getPrecipitationProbability());
        dto.setRainIntensity(values.getRainIntensity());
        dto.setSnowIntensity(values.getSnowIntensity());
        dto.setPressureSurfaceLevel(values.getPressureSurfaceLevel());
        dto.setTemperatureApparent(values.getTemperatureApparent());
        dto.setWeatherCode(values.getWeatherCode());
        dto.setVisibility(values.getVisibility());
        dto.setWindDirection(values.getWindDirection());
        dto.setWindGust(values.getWindGust());
        dto.setWindSpeed(values.getWindSpeed());

        return dto;
    }

    public ForecastDto getWeatherForCity(double lat, double lon) {
        ForecastApiDto forecastApiDto = connector.getForecastForCity(lat, lon);
        SunriseSunsetApiDto sunriseSunsetApiDto = sunriseSunsetConnector.getForecastForCity(lat, lon);
        HourlyForecastDto openMeteoHourlyForecastDto = openMeteoHourlyForecastConnector.getExtendedHourlyWeatherForCity(lat, lon);
        TomorrowForecastApiDto tomorrowForecastApiDto = tomorrowioForecastConnector.getTomorrowioForecastForCity(lat, lon);
        return transformDto(forecastApiDto, sunriseSunsetApiDto, openMeteoHourlyForecastDto, tomorrowForecastApiDto);
    }


}
