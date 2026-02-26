package cz.vsb.austra.connector.weatherapicom;

import cz.vsb.austra.dto.weatherapi.WeatherApiDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
@Component
public class WeatherApiConnector {
    //https://api.weatherapi.com/v1/current.json?key=2f3d5a0c8d0a4dd7986132149232003&q=Ostrava&aqi=no
    private static String baseURL = "https://api.weatherapi.com/v1/";
    private static String urlParams = "current.json?key=";
    private static String APIKey = "2f3d5a0c8d0a4dd7986132149232003";
    private static String url = baseURL + urlParams + APIKey + "&q=";
    public WeatherApiDto getWeatherForCity(String city) {
        RestTemplate template = new RestTemplate();
        URI uri = null;
        try {
            uri = new URI(url + city);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        ResponseEntity<WeatherApiDto> response = template.getForEntity(uri, WeatherApiDto.class);
        return response.getBody();
    }

    public WeatherApiDto getWeatherForLatLon(double lat, double lon) {
        RestTemplate template = new RestTemplate();
        URI uri = null;
        try {
            uri = new URI(url + lat+","+lon);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        ResponseEntity<WeatherApiDto> response = template.getForEntity(uri, WeatherApiDto.class);
        return response.getBody();
    }
}

