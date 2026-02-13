package cz.vsb.austra.connector.weathercom;

import cz.vsb.austra.dto.weathercom.NearStationsDto;
import cz.vsb.austra.dto.weathercom.ObservationDto;
import cz.vsb.austra.dto.weathercom.StationObservationDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

@Component
public class ObservationsConnector {
    //https://api.weather.com/v3/wx/observations/current?apiKey=e1f10a1e78da46f5b10a1e78da96f525&geocode=49.897%2C18.188&language=en-US&units=m&format=json
    private static String baseURL = "https://api.weather.com/";
    private static String v3params = "v3/wx/observations/";
    private static String v2params = "v2/pws/observations/";
    private static String urlParams = "current?apiKey=";
    private static String APIKey = "e1f10a1e78da46f5b10a1e78da96f525";
    private static String formatAndUnits = "&units=m&format=json";

    public ObservationDto getWeatherForLatLon(Double lat, Double lon) {
        String url = baseURL + v3params + urlParams + APIKey + "&geocode=";
        System.out.println(url + lat + "%2C" + lon + "&language=en-US"+formatAndUnits);

        RestTemplate template = new RestTemplate();
        URI uri = null;
        try {
            System.out.println(url + lat + "%2C" + lon + "&language=en-US"+formatAndUnits);
            uri = new URI(url + lat + "%2C" + lon + "&language=en-US"+formatAndUnits);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        ResponseEntity<ObservationDto> response = template.getForEntity(uri, ObservationDto.class);
        return response.getBody();
    }

    //https://api.weather.com/v2/pws/observations/current?apiKey=e1f10a1e78da46f5b10a1e78da96f525&units=m&stationId=ILUDGE22&format=json

    public StationObservationDto getWeatherForStation(String stationCode) {
        String url = baseURL + v2params + urlParams + APIKey + "&stationId=";

        RestTemplate template = new RestTemplate();
        URI uri = null;
        try {
            uri = new URI(url + stationCode.toUpperCase() +formatAndUnits);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        ResponseEntity<StationObservationDto> response = null;
        try {
            response = template.getForEntity(uri, StationObservationDto.class);
        } catch (RestClientException e) {
            e.printStackTrace();
            return null;
        }
        return response.getBody();
    }
}
