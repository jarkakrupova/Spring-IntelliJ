package cz.vsb.austra.service;

import cz.vsb.austra.connector.tomorrowio.ExtendedWeatherConnector;
import cz.vsb.austra.connector.OpenWeatherMapConnector;
import cz.vsb.austra.connector.weatherapicom.WeatherApiConnector;
import cz.vsb.austra.dto.ExtendedWeatherDto;
import cz.vsb.austra.dto.openweathermap.OpenWeatherMapApiCurrentDto;
import cz.vsb.austra.dto.weatherapi.WeatherApiDto;
import cz.vsb.austra.dto.tomorrowio.current.TomorrowCurrentWeatherApiDto;
import cz.vsb.austra.dto.tomorrowio.enums.WeatherCode;
import cz.vsb.austra.dto.tomorrowio.enums.WindDirection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
@Service
public class ExtendedWeatherService {
    ExtendedWeatherConnector connector;
    WeatherApiConnector weatherApiConnector;
    OpenWeatherMapConnector owmConnector;

    @Autowired
    public ExtendedWeatherService(ExtendedWeatherConnector connector, WeatherApiConnector weatherApiConnector, OpenWeatherMapConnector owmConnector) {
        this.connector = connector;
        this.weatherApiConnector = weatherApiConnector;
        this.owmConnector = owmConnector;
    }

    public ExtendedWeatherDto getWeatherForCity(String cityEnum) {
        TomorrowCurrentWeatherApiDto tomorrowCurrentWeatherApiDto = connector.getWeatherForCity(cityEnum);
        WeatherApiDto weatherApiDto = weatherApiConnector.getWeatherForCity(cityEnum);
        OpenWeatherMapApiCurrentDto openWeatherMapApiCurrentDto = owmConnector.getWeatherForCity(cityEnum);
        return transformDto(tomorrowCurrentWeatherApiDto, weatherApiDto, openWeatherMapApiCurrentDto);
    }

    private ExtendedWeatherDto transformDto(TomorrowCurrentWeatherApiDto tomorrowCurrentWeatherApiDto, WeatherApiDto weatherApiDto, OpenWeatherMapApiCurrentDto owmCurrentApiDto) {
        ExtendedWeatherDto wDto = new ExtendedWeatherDto();
        wDto.setLocation(weatherApiDto.getLocation().getName());
        wDto.setRel_humidity_T(tomorrowCurrentWeatherApiDto.getData().getValues().getHumidity());
        wDto.setTemp_celsius_T(tomorrowCurrentWeatherApiDto.getData().getValues().getTemperature());
        wDto.setTimestamp(tomorrowCurrentWeatherApiDto.getData().getTime().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
        wDto.setWeatherDescription_T(WeatherCode.valueOfLabel(tomorrowCurrentWeatherApiDto.getData().getValues().getWeatherCode()).toString());
        wDto.setWindDirection_T(tomorrowCurrentWeatherApiDto.getData().getValues().getWindDirection());
        wDto.setWindSpeed_mps_T(tomorrowCurrentWeatherApiDto.getData().getValues().getWindSpeed());
        wDto.setCloudBase_T(tomorrowCurrentWeatherApiDto.getData().getValues().getCloudBase());
        wDto.setCloudCeiling_T(tomorrowCurrentWeatherApiDto.getData().getValues().getCloudCeiling());
        wDto.setCloudCover_T(tomorrowCurrentWeatherApiDto.getData().getValues().getCloudCover());
        wDto.setDewPoint_T(tomorrowCurrentWeatherApiDto.getData().getValues().getDewPoint());
        wDto.setPressure_T(tomorrowCurrentWeatherApiDto.getData().getValues().getPressureSurfaceLevel());
        wDto.setPrecipitationProbability_T(tomorrowCurrentWeatherApiDto.getData().getValues().getPrecipitationProbability());
        wDto.setRainIntensity_T(tomorrowCurrentWeatherApiDto.getData().getValues().getRainIntensity());
        wDto.setSnowIntensity_T(tomorrowCurrentWeatherApiDto.getData().getValues().getSnowIntensity());
        wDto.setTemp_apparent_T(tomorrowCurrentWeatherApiDto.getData().getValues().getTemperatureApparent());
        wDto.setVisibility_T(tomorrowCurrentWeatherApiDto.getData().getValues().getVisibility());
        wDto.setWindGust_T(tomorrowCurrentWeatherApiDto.getData().getValues().getWindGust());
        wDto.setUvIndex_T(tomorrowCurrentWeatherApiDto.getData().getValues().getUvIndex());
        wDto.setWindDirString_T(WindDirection.valueOfCode(Integer.valueOf((int) Math.round(tomorrowCurrentWeatherApiDto.getData().getValues().getWindDirection()/22.5))).toString());
        wDto.setCloud_WA(weatherApiDto.getCurrent().getCloud());
        wDto.setHumidity_WA(weatherApiDto.getCurrent().getHumidity());
        wDto.setFeelslike_c_WA(weatherApiDto.getCurrent().getFeelslike_c());
        wDto.setGust_kph_WA(weatherApiDto.getCurrent().getGust_kph());
        wDto.setLast_updated_WA(weatherApiDto.getCurrent().getLast_updated());
        wDto.setPrecip_mm_WA(weatherApiDto.getCurrent().getPrecip_mm());
        wDto.setPressure_mb_WA(weatherApiDto.getCurrent().getPressure_mb());
        wDto.setTemp_c_WA(weatherApiDto.getCurrent().getTemp_c());
        wDto.setUv_WA(weatherApiDto.getCurrent().getUv());
        wDto.setVis_km_WA(weatherApiDto.getCurrent().getVis_km());
        wDto.setWeather_description_WA(weatherApiDto.getCurrent().getCondition().getText());
        wDto.setWind_degree_WA(weatherApiDto.getCurrent().getWind_degree());
        wDto.setWind_dir_WA(weatherApiDto.getCurrent().getWind_dir());
        wDto.setWind_kph_WA(weatherApiDto.getCurrent().getWind_kph());
        wDto.setCloudCover_OWM(owmCurrentApiDto.getClouds().getAll());
        wDto.setHumidity_OWM(owmCurrentApiDto.getMain().getHumidity());
        wDto.setFeels_like_c_OWM(UnitConverterService.convertKelvinToCelsius(owmCurrentApiDto.getMain().getFeels_like()));
//        wDto.setRain_OWM(owmCurrentApiDto.getRain().get_1h());
        wDto.setWind_gust_OWM(owmCurrentApiDto.getWind().getGust());
        wDto.setWind_degree_OWM(owmCurrentApiDto.getWind().getDeg());
        wDto.setWind_speed_OWM(owmCurrentApiDto.getWind().getSpeed());
        wDto.setTemp_c_OWM(UnitConverterService.convertKelvinToCelsius(owmCurrentApiDto.getMain().getTemp()));
        wDto.setWeather_description_OWM(owmCurrentApiDto.getWeather().get(0).getMain() + " - "+ owmCurrentApiDto.getWeather().get(0).getDescription());
        wDto.setVisibility_OWM(owmCurrentApiDto.getVisibility()/1000);
        wDto.setPressure_sea_OWM(owmCurrentApiDto.getMain().getSea_level());
        wDto.setPressure_surface_OWM(owmCurrentApiDto.getMain().getGrnd_level());
        wDto.setTimestamp_OWM(UnitConverterService.convertTimestampToDate(owmCurrentApiDto.getDt()));
        return wDto;
    }

    public ExtendedWeatherDto getWeatherForCity(double lat, double lon) {
        TomorrowCurrentWeatherApiDto tomorrowCurrentWeatherApiDto = connector.getWeatherForLatLon(lat, lon);
        WeatherApiDto weatherApiDto = weatherApiConnector.getWeatherForLatLon(lat, lon);
        OpenWeatherMapApiCurrentDto openWeatherMapApiCurrentDto = owmConnector.getWeatherForLatLon(lat, lon);
        return transformDto(tomorrowCurrentWeatherApiDto, weatherApiDto, openWeatherMapApiCurrentDto);
    }
}
