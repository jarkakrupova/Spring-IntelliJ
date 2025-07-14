package cz.vsb.austra.service;

import cz.vsb.austra.connector.ForecastConnector;
import cz.vsb.austra.connector.LocationConnector;
import cz.vsb.austra.connector.OpenMeteoHourlyForecastConnector;
import cz.vsb.austra.connector.SunriseSunsetConnector;
import cz.vsb.austra.dto.*;
import cz.vsb.austra.dto.openmeteo.ForecastDto;
import cz.vsb.austra.dto.openmeteo.HourlyForecastDto;
import cz.vsb.austra.dto.weatherapi.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ForecastService {
    OpenMeteoHourlyForecastConnector openMeteoHourlyForecastConnector;

    @Autowired
    public ForecastService(ForecastConnector connector, SunriseSunsetConnector sunriseSunsetConnector, OpenMeteoHourlyForecastConnector openMeteoHourlyForecastConnector) {
        this.connector = connector;
        this.sunriseSunsetConnector = sunriseSunsetConnector;
        this.openMeteoHourlyForecastConnector = openMeteoHourlyForecastConnector;
    }

    ForecastConnector connector;
    SunriseSunsetConnector sunriseSunsetConnector;

    public ForecastDto getWeatherForCity(String cityEnum) {
        ForecastApiDto forecastApiDto = connector.getForecastForCity(cityEnum);
        SearchLocation loc = new LocationConnector().getLocationForCity(cityEnum)[0];
        SunriseSunsetApiDto sunriseSunsetApiDto = sunriseSunsetConnector.getForecastForCity(loc.getLat(), loc.getLon());
        HourlyForecastDto openMeteoHourlyForecastDto = openMeteoHourlyForecastConnector.getExtendedHourlyWeatherForCity(loc.getLat(), loc.getLon());
        return transformDto(forecastApiDto, sunriseSunsetApiDto, openMeteoHourlyForecastDto);
    }

    private ForecastDto transformDto(ForecastApiDto forecastApiDto, SunriseSunsetApiDto sunriseSunsetApiDto, HourlyForecastDto openMeteoHourlyForecastDto) {
        ForecastDto forecastDto = new ForecastDto();
        for (int i = 0; i < forecastApiDto.getForecast().getForecastday().size(); i++) {
            Forecastday fday = forecastApiDto.getForecast().getForecastday().get(i);
            Astro astro = fday.getAstro();
            SunMoonAstroDto smdto = new SunMoonAstroDto();
            smdto.setMoonrise(astro.getMoonrise());
            smdto.setMoonset(astro.getMoonset());
            smdto.setMoon_phase(astro.getMoon_phase());
            smdto.setSunset(astro.getSunset());
            smdto.setSunrise(astro.getSunrise());
            smdto.setDawn(sunriseSunsetApiDto.getResults().getDawn());
            smdto.setDusk(sunriseSunsetApiDto.getResults().getDusk());
            smdto.setFirst_light(sunriseSunsetApiDto.getResults().getFirst_light());
            smdto.setLast_light(sunriseSunsetApiDto.getResults().getLast_light());
            smdto.setGoldenHour(sunriseSunsetApiDto.getResults().getGolden_hour());
            smdto.setDayLength(sunriseSunsetApiDto.getResults().getDay_length());
            smdto.setTimezone(sunriseSunsetApiDto.getResults().getTimezone());
            forecastDto.getDailyData().add(new DailyDto());
            forecastDto.getDailyData().get(i).setSunMoonData(smdto);

            Day day = fday.getDay();
            MinMaxPrecipSnowDto minMaxPrecipSnowDto = new MinMaxPrecipSnowDto();
            minMaxPrecipSnowDto.setChance_of_snow(day.getDaily_chance_of_snow());
            minMaxPrecipSnowDto.setMax_temperature(day.getMaxtemp_c());
            minMaxPrecipSnowDto.setMin_temperature(day.getMintemp_c());
            minMaxPrecipSnowDto.setTotal_precip_mm(day.getTotalprecip_mm());
            minMaxPrecipSnowDto.setTotal_snow_cm(day.getTotalsnow_cm());
            minMaxPrecipSnowDto.setAvg_temperature(day.getAvgtemp_c());
            minMaxPrecipSnowDto.setChance_of_rain(day.getDaily_chance_of_rain());
            forecastDto.getDailyData().get(i).setMinMaxPrecipSnowData(minMaxPrecipSnowDto);
            ArrayList<Hour> hours = fday.getHour();
            for (int j = 0; j < hours.size(); j++) {
                HourlyDto wDto = new HourlyDto();
                wDto.setLocation(forecastApiDto.getLocation().getName());
                wDto.setRel_humidity(hours.get(j).getHumidity());
                wDto.setTemp_celsius(hours.get(j).getTemp_c());
                wDto.setTimestamp(hours.get(j).getTime());
                wDto.setWeatherDescription(hours.get(j).getCondition().getText());
                wDto.setWindDirection(hours.get(j).getWind_dir());
                wDto.setWindSpeed_mps(Math.round(hours.get(j).getWind_kph() / 3.6));
                wDto.setCloud(hours.get(j).getCloud());
                wDto.setFeelslike_c(hours.get(j).getFeelslike_c());
                wDto.setPressure_mb(hours.get(j).getPressure_mb());
                wDto.setSnow_cm(hours.get(j).getSnow_cm());
                wDto.setIcon(hours.get(j).getCondition().getIcon());
                wDto.setPrecip_mm(hours.get(i).getPrecip_mm());
                forecastDto.getDailyData().get(i).getHourlyData().add(wDto);

                OpenMeteoHourlyDto omhdto = new OpenMeteoHourlyDto();
                omhdto.setCloud_cover(openMeteoHourlyForecastDto.getHourly().getCloud_cover().get((i * 24) + j));
                omhdto.setPrecipitation(openMeteoHourlyForecastDto.getHourly().getPrecipitation().get((i * 24) + j));
                omhdto.setApparent_temperature(openMeteoHourlyForecastDto.getHourly().getApparent_temperature().get((i * 24) + j));
                omhdto.setRain(openMeteoHourlyForecastDto.getHourly().getRain().get((i * 24) + j));
                omhdto.setCloud_cover_high(openMeteoHourlyForecastDto.getHourly().getCloud_cover_high().get((i * 24) + j));
                omhdto.setCloud_cover_low(openMeteoHourlyForecastDto.getHourly().getCloud_cover_low().get((i * 24) + j));
                omhdto.setCloud_cover_mid(openMeteoHourlyForecastDto.getHourly().getCloud_cover_mid().get((i * 24) + j));
                omhdto.setShowers(openMeteoHourlyForecastDto.getHourly().getShowers().get((i * 24) + j));
                omhdto.setPressure_msl(openMeteoHourlyForecastDto.getHourly().getPressure_msl().get((i * 24) + j));
                omhdto.setPrecipitation_probability(openMeteoHourlyForecastDto.getHourly().getPrecipitation_probability().get((i * 24) + j));
                omhdto.setPrecipitation(openMeteoHourlyForecastDto.getHourly().getPrecipitation().get((i * 24) + j));
                omhdto.setSnow_depth(openMeteoHourlyForecastDto.getHourly().getSnow_depth().get((i * 24) + j));
                omhdto.setTime(openMeteoHourlyForecastDto.getHourly().getTime().get((i * 24) + j));
                omhdto.setSnowfall(openMeteoHourlyForecastDto.getHourly().getSnowfall().get((i * 24) + j));
                omhdto.setCloud_cover(openMeteoHourlyForecastDto.getHourly().getCloud_cover().get((i * 24) + j));
                omhdto.setVisibility(openMeteoHourlyForecastDto.getHourly().getVisibility().get((i * 24) + j));
                omhdto.setUv_index(openMeteoHourlyForecastDto.getHourly().getUv_index().get((i * 24) + j));
                omhdto.setSunshine_duration(openMeteoHourlyForecastDto.getHourly().getSunshine_duration().get((i * 24) + j));
                omhdto.setSurface_pressure(openMeteoHourlyForecastDto.getHourly().getSurface_pressure().get((i * 24) + j));
                omhdto.setTemperature_2m(openMeteoHourlyForecastDto.getHourly().getTemperature_2m().get((i * 24) + j));
                omhdto.setRelative_humidity_2m(openMeteoHourlyForecastDto.getHourly().getRelative_humidity_2m().get((i * 24) + j));
                omhdto.setDew_point_2m(openMeteoHourlyForecastDto.getHourly().getDew_point_2m().get((i * 24) + j));
                omhdto.setWind_direction_10m(openMeteoHourlyForecastDto.getHourly().getWind_direction_10m().get((i * 24) + j));
                omhdto.setWind_gusts_10m(openMeteoHourlyForecastDto.getHourly().getWind_gusts_10m().get((i * 24) + j));
                omhdto.setWind_speed_10m(openMeteoHourlyForecastDto.getHourly().getWind_speed_10m().get((i * 24) + j));
                omhdto.setWeather_code(openMeteoHourlyForecastDto.getHourly().getWeather_code().get((i * 24) + j));

                forecastDto.getDailyData().get(i).getOpenMeteoHourlyData().add(omhdto);
            }

        }
        return forecastDto;
    }

    public ForecastDto getWeatherForCity(double lat, double lon) {
        ForecastApiDto forecastApiDto = connector.getForecastForCity(lat, lon);
        SunriseSunsetApiDto sunriseSunsetApiDto = sunriseSunsetConnector.getForecastForCity(lat, lon);
        HourlyForecastDto openMeteoHourlyForecastDto = openMeteoHourlyForecastConnector.getExtendedHourlyWeatherForCity(lat, lon);
        return transformDto(forecastApiDto, sunriseSunsetApiDto, openMeteoHourlyForecastDto);
    }


}
