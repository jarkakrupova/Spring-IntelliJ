package cz.vsb.austra.connector.openmeteo;

import cz.vsb.austra.dto.openmeteo.HistoricalWeatherApiDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

public class WeatherOpenMeteoConnector {
    //https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&hourly=temperature_2m,relative_humidity_2m,dew_point_2m,apparent_temperature,precipitation_probability,precipitation,rain,showers,snowfall,snow_depth,weather_code,pressure_msl,surface_pressure,cloud_cover,wind_speed_10m,wind_gusts_10m,visibility,uv_index,sunshine_duration,cloud_cover_low,cloud_cover_mid,cloud_cover_high,wind_direction_10m&forecast_days=1

    private static String baseURL = "https://archive-api.open-meteo.com/v1/";
    private static String urlParams = "archive?";
    private static String url = baseURL + urlParams;
    public HistoricalWeatherApiDto getHistoricalWeatherForCity (double lat, double lon) {
        RestTemplate template = new RestTemplate();
        URI uri = null;
        try {
            uri = new URI(url + "latitude=" + lat+"&longitude="+lon + "&hourly=temperature_2m,relative_humidity_2m,dew_point_2m,apparent_temperature,precipitation_probability,precipitation,rain,showers,snowfall,snow_depth,weather_code,pressure_msl,surface_pressure,cloud_cover,wind_speed_10m,wind_gusts_10m,visibility,uv_index,sunshine_duration,cloud_cover_low,cloud_cover_mid,cloud_cover_high,wind_direction_10m&forecast_days=3");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        ResponseEntity<HistoricalWeatherApiDto> response = template.getForEntity(uri, HistoricalWeatherApiDto.class);
        return response.getBody();
    }
}



