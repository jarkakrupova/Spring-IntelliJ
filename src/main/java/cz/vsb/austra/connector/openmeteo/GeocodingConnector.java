package cz.vsb.austra.connector.openmeteo;

import cz.vsb.austra.dto.openmeteo.Geocoding;
import cz.vsb.austra.dto.openmeteo.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Component
public class GeocodingConnector {
    private static String baseURL = "https://geocoding-api.open-meteo.com/v1/";
    private static String urlParams = "search?";
    private static String url = baseURL + urlParams;
    //všechny: https://geocoding-api.open-meteo.com/v1/search?name=Side&count=10&language=en&format=json

    //1 kus: https://geocoding-api.open-meteo.com/v1/get?id=2950159
    public Geocoding getGeocodingForCity (String name, int count) {
        RestTemplate template = new RestTemplate();
        URI uri = null;
        try {
            uri = new URI(url + "name=" + name+"&count="+ count +"&language=en&format=json");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        ResponseEntity<Geocoding> response = template.getForEntity(uri, Geocoding.class);
        return response.getBody();
    }

    public Result getGeocodingForId (int id) {
        RestTemplate template = new RestTemplate();
        URI uri = null;
        try {
            uri = new URI(baseURL + "get?id=" + id);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        ResponseEntity<Result> response = template.getForEntity(uri, Result.class);
        return response.getBody();
    }
}
