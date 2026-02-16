package cz.vsb.austra.connector.openmeteo;

import cz.vsb.austra.dto.openmeteo.HistoricalWeatherApiDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
@Component
public class HistoricalWeatherConnector {
//https://archive-api.open-meteo.com/v1/archive?latitude=52.52&longitude=13.41&start_date=2024-07-10&end_date=2024-07-24&daily=weather_code,temperature_2m_max,temperature_2m_min,temperature_2m_mean,apparent_temperature_max,apparent_temperature_min,apparent_temperature_mean,sunrise,sunset,daylight_duration,sunshine_duration,precipitation_sum,rain_sum,snowfall_sum,precipitation_hours,wind_speed_10m_max,wind_gusts_10m_max,wind_direction_10m_dominant&timezone=Europe%2FBerlin
    private static String baseURL = "https://archive-api.open-meteo.com/v1/";
    private static String urlParams = "archive?";
    private static String url = baseURL + urlParams;
    public HistoricalWeatherApiDto getHistoricalWeatherForCity (double lat, double lon, String startDate, String endDate) {
        RestTemplate template = new RestTemplate();
        URI uri = null;
        try {
            uri = new URI(url + "latitude=" + lat+"&longitude="+lon + "&start_date=" + startDate + "&end_date=" + endDate + "&daily=weather_code,temperature_2m_max,temperature_2m_min,temperature_2m_mean,apparent_temperature_max,apparent_temperature_min,apparent_temperature_mean,sunrise,sunset,daylight_duration,sunshine_duration,precipitation_sum,rain_sum,snowfall_sum,precipitation_hours,wind_speed_10m_max,wind_gusts_10m_max,wind_direction_10m_dominant&timezone=Europe%2FBerlin");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        ResponseEntity<HistoricalWeatherApiDto> response = template.getForEntity(uri, HistoricalWeatherApiDto.class);
        return response.getBody();
    }
}
