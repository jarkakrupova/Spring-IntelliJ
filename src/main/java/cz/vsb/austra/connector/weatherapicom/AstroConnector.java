package cz.vsb.austra.connector.weatherapicom;

import cz.vsb.austra.dto.weatherapi.AstroApiDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
@Component
public class AstroConnector {
    //http://api.weatherapi.com/v1/astronomy.json?key=2f3d5a0c8d0a4dd7986132149232003&q=ostrava&dt=2024-07-26
    //dt neni povinne, funguje to i bez nej
    private static String baseURL = "https://api.weatherapi.com/v1/";
    private static String urlParams = "astronomy.json?key=";
    private static String APIKey = "2f3d5a0c8d0a4dd7986132149232003";
    private static String url = baseURL + urlParams + APIKey + "&q=";
    public AstroApiDto getAstroForCity(String city) {
        RestTemplate template = new RestTemplate();
        URI uri = null;
        try {
            uri = new URI(url + city);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        ResponseEntity<AstroApiDto> response = template.getForEntity(uri, AstroApiDto.class);
        return response.getBody();
    }

    public AstroApiDto getAstroForLatLon(double lat, double lon) {
        RestTemplate template = new RestTemplate();
        URI uri = null;
        try {
            uri = new URI(url + lat+","+lon);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        ResponseEntity<AstroApiDto> response = template.getForEntity(uri, AstroApiDto.class);
        return response.getBody();
    }
}
