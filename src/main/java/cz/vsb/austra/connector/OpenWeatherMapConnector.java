package cz.vsb.austra.connector;

import cz.vsb.austra.dto.openweathermap.OpenWeatherMapApiCurrentDto;
import cz.vsb.austra.dto.tomorrowio.current.TomorrowCurrentWeatherApiDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
@Component
public class OpenWeatherMapConnector {
    //https://api.openweathermap.org/data/2.5/weather?lat=44.34&lon=10.99&appid={API key}

    private static String baseURL = "https://api.openweathermap.org/data/2.5/";
    private static String urlParams = "weather?";
    private static String APIKey = "65031b2768f1f4d3ee1349185d91ef44";
    private static String url = baseURL + urlParams;

    public OpenWeatherMapApiCurrentDto getWeatherForCity(String city) {
        RestTemplate template = new RestTemplate();
        URI uri = null;
        try {
            uri = new URI(url + city + "&appid=" + APIKey);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        ResponseEntity<OpenWeatherMapApiCurrentDto> response = template.getForEntity(uri, OpenWeatherMapApiCurrentDto.class);
        return response.getBody();
    }

    public OpenWeatherMapApiCurrentDto getWeatherForLatLon(double lat, double lon) {
        RestTemplate template = new RestTemplate();
        URI uri = null;
        try {
            uri = new URI(url + "lat="+lat + "&lon=" + lon + "&appid=" + APIKey);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        ResponseEntity<OpenWeatherMapApiCurrentDto> response = template.getForEntity(uri, OpenWeatherMapApiCurrentDto.class);
        return response.getBody();
    }
}
