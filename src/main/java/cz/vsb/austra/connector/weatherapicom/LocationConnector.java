package cz.vsb.austra.connector.weatherapicom;

import cz.vsb.austra.dto.SearchLocation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
@Component
public class LocationConnector {
    //http://api.weatherapi.com/v1/search.json?key=2f3d5a0c8d0a4dd7986132149232003&q=ostrava
    private static String baseURL = "https://api.weatherapi.com/v1/";
    private static String urlParams = "search.json?key=";
    private static String APIKey = "2f3d5a0c8d0a4dd7986132149232003";
    private static String url = baseURL + urlParams + APIKey + "&q=";
    public SearchLocation[] getLocationForCity (String city) {
        RestTemplate template = new RestTemplate();
        URI uri = null;
        try {
            uri = new URI(url + city);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        ResponseEntity<SearchLocation[]> response = template.getForEntity(uri, SearchLocation[].class);
        return response.getBody();
    }
}
