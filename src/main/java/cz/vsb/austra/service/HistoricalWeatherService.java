package cz.vsb.austra.service;

import cz.vsb.austra.City;
import cz.vsb.austra.connector.HistoricalWeatherConnector;
import cz.vsb.austra.connector.LocationConnector;
import cz.vsb.austra.dto.SearchLocation;
import cz.vsb.austra.dto.SunMoonAstroDto;
import cz.vsb.austra.dto.openmeteo.Daily;
import cz.vsb.austra.dto.openmeteo.HistoricalDailyWeatherDto;
import cz.vsb.austra.dto.openmeteo.HistoricalWeatherApiDto;
import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HistoricalWeatherService {
    public List<HistoricalDailyWeatherDto> getSunMoonAstroDataForTheCity(City city) {
        LocationConnector locationConnector = new LocationConnector();
        SearchLocation cityLocation = locationConnector.getLocationForCity(city)[0];
        double lat = cityLocation.getLat();
        double lon = cityLocation.getLon();
        HistoricalWeatherConnector connector = new HistoricalWeatherConnector();
        HistoricalWeatherApiDto historicalApiDto = connector.getHistoricalWeatherForCity(lat, lon);
        return transformDto(historicalApiDto.getDaily());
    }

    private List<HistoricalDailyWeatherDto> transformDto(Daily dailyHistoricalApiDto) {
        List<HistoricalDailyWeatherDto> historyWeather = new ArrayList<>();
        for (int i = 0; i < dailyHistoricalApiDto.getTime().size(); i++) {
        HistoricalDailyWeatherDto historicalDailyDto = new HistoricalDailyWeatherDto();
            historicalDailyDto.setApparent_temperature_max(dailyHistoricalApiDto.getApparent_temperature_max().get(i));
            historicalDailyDto.setApparent_temperature_mean(dailyHistoricalApiDto.getApparent_temperature_mean().get(i));
            historicalDailyDto.setApparent_temperature_min(dailyHistoricalApiDto.getApparent_temperature_min().get(i));
            historicalDailyDto.setSunrise(dailyHistoricalApiDto.getSunrise().get(i));
            historicalDailyDto.setSunset(dailyHistoricalApiDto.getSunset().get(i));
            historicalDailyDto.setDaylight_duration(dailyHistoricalApiDto.getDaylight_duration().get(i));
            historicalDailyDto.setPrecipitation_hours(dailyHistoricalApiDto.getPrecipitation_hours().get(i));
            historicalDailyDto.setPrecipitation_sum(dailyHistoricalApiDto.getPrecipitation_sum().get(i));
            historicalDailyDto.setRain_sum(dailyHistoricalApiDto.getRain_sum().get(i));
            historicalDailyDto.setSnowfall_sum(dailyHistoricalApiDto.getSnowfall_sum().get(i));
            historicalDailyDto.setRain_sum(dailyHistoricalApiDto.getRain_sum().get(i));
            historicalDailyDto.setTime(dailyHistoricalApiDto.getTime().get(i));
            historicalDailyDto.setWeather_code(dailyHistoricalApiDto.getWeather_code().get(i));
            historicalDailyDto.setSunshine_duration(dailyHistoricalApiDto.getSunshine_duration().get(i));
            historicalDailyDto.setTemperature_2m_max(dailyHistoricalApiDto.getTemperature_2m_max().get(i));
            historicalDailyDto.setTemperature_2m_mean(dailyHistoricalApiDto.getTemperature_2m_mean().get(i));
            historicalDailyDto.setTemperature_2m_min(dailyHistoricalApiDto.getTemperature_2m_min().get(i));
            historicalDailyDto.setWind_gusts_10m_max(dailyHistoricalApiDto.getWind_gusts_10m_max().get(i));
            historicalDailyDto.setWind_direction_10m_dominant(dailyHistoricalApiDto.getWind_direction_10m_dominant().get(i));
            historicalDailyDto.setWind_speed_10m_max(dailyHistoricalApiDto.getWind_speed_10m_max().get(i));
            historyWeather.add(historicalDailyDto);
        }
        return historyWeather;
    }
}
