package cz.vsb.austra.connector;

import cz.vsb.austra.dto.SunriseSunsetApiDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
@Component
public class SunriseSunsetConnector {
    //https://api.sunrisesunset.io/json?lat=38.907192&lng=-77.036873
    private static String baseURL = "https://api.sunrisesunset.io/";
    private static String urlParams = "json?";

    private static String url = baseURL + urlParams;
    public SunriseSunsetApiDto getSunriseSunsetDataForCity(double lat, double lng) {
        RestTemplate template = new RestTemplate();
        URI uri = null;
        try {
            uri = new URI(url + "lat=" + lat + "&lng=" + lng);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        ResponseEntity<SunriseSunsetApiDto> response = template.getForEntity(uri, SunriseSunsetApiDto.class);
        return response.getBody();
    }

}

