package cz.vsb.austra.service;


import cz.vsb.austra.connector.openmeteo.HistoricalWeatherConnector;
import cz.vsb.austra.connector.weatherapicom.LocationConnector;
import cz.vsb.austra.dto.HistoricalTimeSeriesDto;
import cz.vsb.austra.dto.SearchLocation;
import cz.vsb.austra.dto.WeatherCondition;
import cz.vsb.austra.dto.openmeteo.Daily;
import cz.vsb.austra.dto.openmeteo.DailyHistoryDto;
import cz.vsb.austra.dto.openmeteo.HistoricalDailyWeatherDto;
import cz.vsb.austra.dto.openmeteo.HistoricalWeatherApiDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class HistoricalWeatherService {
    LocationConnector locationConnector;
    HistoricalWeatherConnector connector;

    @Autowired
    public HistoricalWeatherService(LocationConnector locationConnector, HistoricalWeatherConnector connector) {
        this.locationConnector = locationConnector;
        this.connector = connector;
    }

    public List<HistoricalDailyWeatherDto> getHistoricalWeatherData(String city) {
        //locationConnector locationConnector = new LocationConnector();
        SearchLocation cityLocation = locationConnector.getLocationForCity(city)[0];
        double lat = cityLocation.getLat();
        double lon = cityLocation.getLon();
        String yesterday = DateTimeFormatter.ISO_LOCAL_DATE.format(LocalDate.now().minusDays(1));
        String startDate = DateTimeFormatter.ISO_LOCAL_DATE.format(LocalDate.now().minusDays(7));
        //HistoricalWeatherConnector connector = new HistoricalWeatherConnector();
        HistoricalWeatherApiDto historicalApiDto = connector.getHistoricalWeatherForCity(lat, lon, startDate, yesterday);
        return transformDto(historicalApiDto.getDaily());
    }

    private List<HistoricalDailyWeatherDto> transformDto(Daily dailyHistoricalApiDto) {
        List<HistoricalDailyWeatherDto> historyWeather = new ArrayList<>();
        for (int i = 0; i < dailyHistoricalApiDto.getTime().size(); i++) {
            HistoricalDailyWeatherDto historicalDailyDto = new HistoricalDailyWeatherDto();
            historicalDailyDto.setApparent_temperature_max(dailyHistoricalApiDto.getApparent_temperature_max().get(i));
            historicalDailyDto.setApparent_temperature_mean(dailyHistoricalApiDto.getApparent_temperature_mean().get(i));
            historicalDailyDto.setApparent_temperature_min(dailyHistoricalApiDto.getApparent_temperature_min().get(i));
            historicalDailyDto.setSunrise(UnitConverterService.convertIsoToCustomFormat(dailyHistoricalApiDto.getSunrise().get(i)));
            historicalDailyDto.setSunset(UnitConverterService.convertIsoToCustomFormat(dailyHistoricalApiDto.getSunset().get(i)));
            historicalDailyDto.setDaylight_duration(dailyHistoricalApiDto.getDaylight_duration().get(i));
            historicalDailyDto.setDaylight_time(UnitConverterService.convertSecondsToTime(dailyHistoricalApiDto.getDaylight_duration().get(i)));
            historicalDailyDto.setPrecipitation_hours(dailyHistoricalApiDto.getPrecipitation_hours().get(i));
            historicalDailyDto.setPrecipitation_sum(dailyHistoricalApiDto.getPrecipitation_sum().get(i));
            historicalDailyDto.setRain_sum(dailyHistoricalApiDto.getRain_sum().get(i));
            historicalDailyDto.setSnowfall_sum(dailyHistoricalApiDto.getSnowfall_sum().get(i));
            historicalDailyDto.setRain_sum(dailyHistoricalApiDto.getRain_sum().get(i));
            historicalDailyDto.setTime(dailyHistoricalApiDto.getTime().get(i));
            historicalDailyDto.setWeather_code(dailyHistoricalApiDto.getWeather_code().get(i));
            historicalDailyDto.setSunshine_duration(dailyHistoricalApiDto.getSunshine_duration().get(i));
            historicalDailyDto.setSunshine_time((dailyHistoricalApiDto.getSunshine_duration().get(i) != null ? UnitConverterService.convertSecondsToTime(dailyHistoricalApiDto.getSunshine_duration().get(i)) : null));
            historicalDailyDto.setTemperature_2m_max(dailyHistoricalApiDto.getTemperature_2m_max().get(i));
            historicalDailyDto.setTemperature_2m_mean(dailyHistoricalApiDto.getTemperature_2m_mean().get(i));
            historicalDailyDto.setTemperature_2m_min(dailyHistoricalApiDto.getTemperature_2m_min().get(i));
            historicalDailyDto.setWind_gusts_10m_max(dailyHistoricalApiDto.getWind_gusts_10m_max().get(i));
            historicalDailyDto.setWind_direction_10m_dominant(dailyHistoricalApiDto.getWind_direction_10m_dominant().get(i));
            historicalDailyDto.setWind_speed_10m_max(dailyHistoricalApiDto.getWind_speed_10m_max().get(i));
            historicalDailyDto.setWeather_description(dailyHistoricalApiDto.getWeather_code().get(i) != null ? WeatherCondition.descriptionFromCode(dailyHistoricalApiDto.getWeather_code().get(i)) : null);
            historyWeather.add(historicalDailyDto);
        }
        return historyWeather;
    }

    public List<HistoricalDailyWeatherDto> getHistoricalWeatherData(double lat, double lon, int days) {
        String yesterday = DateTimeFormatter.ISO_LOCAL_DATE.format(LocalDate.now().minusDays(1));
        String startDate = DateTimeFormatter.ISO_LOCAL_DATE.format(LocalDate.now().minusDays(days));
        HistoricalWeatherApiDto historicalApiDto = connector.getHistoricalWeatherForCity(lat, lon, startDate, yesterday);
        return transformDto(historicalApiDto.getDaily());
    }

    public HistoricalTimeSeriesDto getHistoricalTimeSeries(double lat, double lon, int days) {
        String yesterday = DateTimeFormatter.ISO_LOCAL_DATE.format(LocalDate.now().minusDays(1));
        String startDate = DateTimeFormatter.ISO_LOCAL_DATE.format(LocalDate.now().minusDays(days));
        var weatherHistory = connector.getHistoricalWeatherForCity(lat, lon, startDate, yesterday);
        HistoricalTimeSeriesDto historicalTimeSeriesDto = new HistoricalTimeSeriesDto();
        historicalTimeSeriesDto.setElevation(weatherHistory.getElevation());
        historicalTimeSeriesDto.setDaily_units(weatherHistory.getDaily_units());
        //historicalTimeSeriesDto.setDaily((DailyHistoryDto) weatherHistory.getDaily());
        //for (int i = 0; i < weatherHistory.getDaily().getTime().size(); i++) {
        DailyHistoryDto dailyHistoryDto = new DailyHistoryDto();
        dailyHistoryDto.setTime(weatherHistory.getDaily().getTime());
        dailyHistoryDto.setDaylight_duration(weatherHistory.getDaily().getDaylight_duration());
        dailyHistoryDto.setSunshine_duration(weatherHistory.getDaily().getSunshine_duration());
        dailyHistoryDto.setApparent_temperature_max(weatherHistory.getDaily().getApparent_temperature_max());
        dailyHistoryDto.setApparent_temperature_min(weatherHistory.getDaily().getApparent_temperature_min());
        dailyHistoryDto.setApparent_temperature_mean(weatherHistory.getDaily().getApparent_temperature_mean());
        dailyHistoryDto.setPrecipitation_hours(weatherHistory.getDaily().getPrecipitation_hours());
        dailyHistoryDto.setRain_sum(weatherHistory.getDaily().getRain_sum());
        dailyHistoryDto.setSnowfall_sum(weatherHistory.getDaily().getSnowfall_sum());
        dailyHistoryDto.setPrecipitation_sum(weatherHistory.getDaily().getPrecipitation_sum());
        dailyHistoryDto.setSunrise(weatherHistory.getDaily().getSunrise());
        dailyHistoryDto.setSunset(weatherHistory.getDaily().getSunset());
        dailyHistoryDto.setTemperature_2m_max(weatherHistory.getDaily().getTemperature_2m_max());
        dailyHistoryDto.setTemperature_2m_mean(weatherHistory.getDaily().getTemperature_2m_mean());
        dailyHistoryDto.setTemperature_2m_min(weatherHistory.getDaily().getTemperature_2m_min());
        dailyHistoryDto.setWeather_code(weatherHistory.getDaily().getWeather_code());
        dailyHistoryDto.setWind_gusts_10m_max(weatherHistory.getDaily().getWind_gusts_10m_max());
        dailyHistoryDto.setWind_direction_10m_dominant(weatherHistory.getDaily().getWind_direction_10m_dominant());
        dailyHistoryDto.setWind_speed_10m_max(weatherHistory.getDaily().getWind_speed_10m_max());
        historicalTimeSeriesDto.setDaily(dailyHistoryDto);
        //}
        historicalTimeSeriesDto.setLatitude(weatherHistory.getLatitude());
        historicalTimeSeriesDto.setLongitude(weatherHistory.getLongitude());
        historicalTimeSeriesDto.setGenerationtime_ms(weatherHistory.getGenerationtime_ms());
        historicalTimeSeriesDto.setTimezone(weatherHistory.getTimezone());
        historicalTimeSeriesDto.setTimezone_abbreviation(weatherHistory.getTimezone_abbreviation());
        historicalTimeSeriesDto.setUtc_offset_seconds(weatherHistory.getUtc_offset_seconds());
        for (int i = 0; i < (weatherHistory.getDaily()).getDaylight_duration().size(); i++) {
            historicalTimeSeriesDto.getDaily().getDaylight_time().add(UnitConverterService.convertSecondsToTime(weatherHistory.getDaily().getDaylight_duration().get(i)));
            historicalTimeSeriesDto.getDaily().getSunshine_time().add(UnitConverterService.convertSecondsToTime(weatherHistory.getDaily().getSunshine_duration().get(i)));
        }
        return historicalTimeSeriesDto;
    }
}
