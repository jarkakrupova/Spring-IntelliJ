package cz.vsb.austra.connector;

import cz.vsb.austra.dto.meteostat.ClimateNormalApiDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ClimateNormalsConnector {
    private static String baseURL = "https://meteostat.p.rapidapi.com/point/";
    private static String urlParams = "normals?";
    //private static String APIKey = "2f3d5a0c8d0a4dd7986132149232003";

    public ClimateNormalApiDto getClimateNormalForLatLon(double lat, double lon) {
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("https://meteostat.p.rapidapi.com/point/normals?lat=59.9127&lon=10.7461&alt=26&start=1961&end=1990"))
//                .header("x-rapidapi-key", "d5f26647bamsh87848506070211cp1870f9jsnb4a8ff5ce0ea")
//                .header("x-rapidapi-host", "meteostat.p.rapidapi.com")
//                .method("GET", HttpRequest.BodyPublishers.noBody())
//                .build();
//        HttpResponse<String> response = null;
//        try {
//            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return response.body();
//String url = "https://meteostat.p.rapidapi.com/point/normals?lat=59.9127&lon=10.7461&start=1961&end=1990";
        String url = baseURL + urlParams+"lat="+lat+"&lon="+lon+"&start=1991&end=2020";
        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", "d5f26647bamsh87848506070211cp1870f9jsnb4a8ff5ce0ea");
        headers.set("x-rapidapi-host", "meteostat.p.rapidapi.com");
        HttpEntity entity = new HttpEntity(headers);
//
        ResponseEntity<ClimateNormalApiDto> response = template.exchange(url, HttpMethod.GET, entity, ClimateNormalApiDto.class);
//            ResponseEntity<AstroApiDto> response = template.getForEntity(uri, AstroApiDto.class);
        return response.getBody();
    }
}

