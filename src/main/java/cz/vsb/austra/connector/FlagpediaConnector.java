package cz.vsb.austra.connector;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
@Component
public class FlagpediaConnector {
    //https://flagcdn.com/40x30/ua.png
    private static String baseURL = "https://flagcdn.com/";
    private static String size = "w40/";
    private static String extension = ".png";

    public String getFlagForCountry(String countryCode) {
        RestTemplate template = new RestTemplate();
        URI uri = null;
        try {
            uri = new URI(baseURL+size+countryCode.toLowerCase()+extension);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return uri.toString();
    }
}
