package cz.vsb.austra.connector.tomorrowio;

import cz.vsb.austra.dto.tomorrowio.current.TomorrowCurrentWeatherApiDto;
import cz.vsb.austra.dto.tomorrowio.forecast.TomorrowForecastApiDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
@Component
public class TomorrowioForecastConnector {
    //https://api.tomorrow.io/v4/weather/forecast?location=toronto&apikey=2xuEThz8mkNbBDiBcW4n5DIrNC7DXqBK

    private static String baseURL = "https://api.tomorrow.io/v4/";
    private static String urlParams = "weather/forecast?location=";
    private static String APIKey = "2xuEThz8mkNbBDiBcW4n5DIrNC7DXqBK";
    private static String url = baseURL + urlParams;

    public TomorrowForecastApiDto getTomorrowioForecastForCity(String city) {
        RestTemplate template = new RestTemplate();
        URI uri = null;
        try {
            uri = new URI(url + city + "&apikey=" + APIKey);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        ResponseEntity<TomorrowForecastApiDto> response = template.getForEntity(uri, TomorrowForecastApiDto.class);
        return response.getBody();
    }
//https://api.tomorrow.io/v4/weather/forecast?location=49.89,18.18&apikey=2xuEThz8mkNbBDiBcW4n5DIrNC7DXqBK
    //5 dnů, 120 hodin, 60 minut
    public TomorrowForecastApiDto getTomorrowioForecastForCity(double lat, double lon) {
        RestTemplate template = new RestTemplate();
        URI uri = null;
        try {
            uri = new URI(url + lat + "," + lon + "&apikey=" + APIKey);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        ResponseEntity<TomorrowForecastApiDto> response = template.getForEntity(uri, TomorrowForecastApiDto.class);
        return response.getBody();
    }
}
