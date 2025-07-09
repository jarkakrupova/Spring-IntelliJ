package cz.vsb.austra.connector;

import cz.vsb.austra.City;
import cz.vsb.austra.dto.tomorrowio.current.TomorrowCurrentWeatherApiDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
@Component
public class ExtendedWeatherConnector {
     //https://api.tomorrow.io/v4/weather/realtime?location=toronto&apikey=2xuEThz8mkNbBDiBcW4n5DIrNC7DXqBK

    private static String baseURL = "https://api.tomorrow.io/v4/";
    private static String urlParams = "weather/realtime?location=";
    private static String APIKey = "2xuEThz8mkNbBDiBcW4n5DIrNC7DXqBK";
    private static String url = baseURL + urlParams;
    public TomorrowCurrentWeatherApiDto getWeatherForCity(String city) {
        RestTemplate template = new RestTemplate();
        URI uri = null;
        try {
            uri = new URI(url + city + "&apikey="+APIKey);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        ResponseEntity<TomorrowCurrentWeatherApiDto> response = template.getForEntity(uri, TomorrowCurrentWeatherApiDto.class);
        return response.getBody();
    }

}
