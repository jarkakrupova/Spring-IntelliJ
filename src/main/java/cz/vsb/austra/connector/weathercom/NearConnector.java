package cz.vsb.austra.connector.weathercom;

import cz.vsb.austra.dto.weathercom.NearStationsDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
@Component
public class NearConnector {
//https://api.weather.com/v3/location/near?apiKey=e1f10a1e78da46f5b10a1e78da96f525&geocode=49.897%2C18.188&product=pws&format=json
    private static String baseURL = "https://api.weather.com/v3/location/";
    private static String urlParams = "near?apiKey=";
    private static String APIKey = "e1f10a1e78da46f5b10a1e78da96f525";
    private static String format = "&format=json";


    private static String url = baseURL + urlParams + APIKey + "&geocode=";
    public NearStationsDto getNearbyPrivateStationsForLatLon (String lat, String lon) {
        RestTemplate template = new RestTemplate();
        URI uri = null;
        try {
            uri = new URI(url + lat + "%2C" + lon + "&product=pws" + format);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        ResponseEntity<NearStationsDto> response = template.getForEntity(uri, NearStationsDto.class);
        return response.getBody();
    }

    //https://api.weather.com/v3/location/near?apiKey=e1f10a1e78da46f5b10a1e78da96f525&geocode=49.897%2C18.188&product=pws&format=json
    public List<String> getNearbyStationIdsForLatLon(Double lat, Double lon) {
        String url = baseURL + urlParams + APIKey + "&geocode=";

        RestTemplate template = new RestTemplate();
        URI uri = null;
        try {
            uri = new URI(url + lat + "%2C" + lon + "&product=pws" + format);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        ResponseEntity<NearStationsDto> response = template.getForEntity(uri, NearStationsDto.class);
        return response.getBody().getLocation().getStationId();
    }
}
