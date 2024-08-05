package cz.vsb.austra.connector;

import cz.vsb.austra.City;
import cz.vsb.austra.dto.weatherapi.ForecastApiDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
@Component
public class ForecastConnector {
//https://api.weatherapi.com/v1/forecast.json?key=2f3d5a0c8d0a4dd7986132149232003&q=Ostrava&days=3&aqi=no&alerts=no
private static String baseURL = "https://api.weatherapi.com/v1/";
    private static String urlParams = "forecast.json?key=";
    private static String APIKey = "2f3d5a0c8d0a4dd7986132149232003";
    private static String url = baseURL + urlParams + APIKey + "&q=";
    public ForecastApiDto getForecastForCity(City city) {
        RestTemplate template = new RestTemplate();
        URI uri = null;
        try {
            uri = new URI(url + city+"&days=3&aqi=no&alerts=no");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        ResponseEntity<ForecastApiDto> response = template.getForEntity(uri, ForecastApiDto.class);
        return response.getBody();
    }

}
