package cz.vsb.austra.connector;

import cz.vsb.austra.City;
import cz.vsb.austra.dto.AstroApiDto;
import cz.vsb.austra.dto.WeatherApiDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

public class AstroConnector {
    //http://api.weatherapi.com/v1/astronomy.json?key=2f3d5a0c8d0a4dd7986132149232003&q=ostrava&dt=2024-07-26
    //dt neni povinne, funguje to i bez nej
    private static String baseURL = "https://api.weatherapi.com/v1/";
    private static String urlParams = "astronomy.json?key=";
    private static String APIKey = "2f3d5a0c8d0a4dd7986132149232003";
    private static String url = baseURL + urlParams + APIKey + "&q=";
    public AstroApiDto getAstroForCity(City city) {
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
//    public AstroApiDto getAstroForCity(double lat, double lng) {
//        RestTemplate template = new RestTemplate();
//        URI uri = null;
//        try {
//            uri = new URI(url + lat+","+lng);
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
//        ResponseEntity<AstroApiDto> response = template.getForEntity(uri, AstroApiDto.class);
//        return response.getBody();
//    }
}
