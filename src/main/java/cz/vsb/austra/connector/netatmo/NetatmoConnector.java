package cz.vsb.austra.connector.netatmo;

import cz.vsb.austra.dto.NetatmoStationDto;
import cz.vsb.austra.dto.netatmo.ApiResponse;
import cz.vsb.austra.dto.netatmo.WeatherStation;
import cz.vsb.austra.service.UnitConverterService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
public class NetatmoConnector {
//https://api.netatmo.com/api/getpublicmeasures?zoom=14&lat_ne=49.908787000867136&lon_ne=18.193359375
// &lat_sw=48.89463439573421&lon_sw=18.00138671875
// &access_token=52d42bfc1777599b298b456c|aa2b4778751e29bb828066de3f891be6

    public static String baseUrl = "https://api.netatmo.com/api/";
    public static String endpoint = "getpublicmeasures";
    public static String zoomParam = "?zoom=";
    public static String latneParam = "&lat_ne=";
    public static String lonneParam = "&lon_ne=";
    public static String latswParam = "&lat_sw=";
    public static String lonswParam = "&lon_sw=";
    public static String accessTokenParam = "&access_token=";
    //public static String accessToken = "69638da7f9df013c11075b24|1c8d7622263513dc7438ee325d76f5cb";
    //69638da7f9df013c11075b24|8cb8970b1131dbc70998e28a2d2b9021
    //69638da7f9df013c11075b24%7C8cb8970b1131dbc70998e28a2d2b9021
    public static String clientId = "69638e26a7e1a2873b06e4b4";
    public static String clientSecret = "Wf5JcO8NuvOIYA8RMOmxZ4uhkrBZlx";

    //svislice v tokenu je nekdy treba nahradit %7C

    public List<NetatmoStationDto> getData(Double latNe, Double lonNe, Double latSw, Double lonSw, int zoom) {
        String newAccessToken = getNewAccessToken();

        //zde zacina samotne volani
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "https://api.netatmo.com/api/getpublicmeasures?zoom=15&lat_ne=49.908787000867136&lon_ne=18.193359375&lat_sw=48.89463439573421&lon_sw=18.10138671875&access_token=" + newAccessToken;
        System.out.println(apiUrl);
        String jsonResponse = null;
        List<NetatmoStationDto> stationsData = new ArrayList<>();
        try {
            jsonResponse = restTemplate.getForObject(apiUrl, String.class);
            // Příklady práce s daty
            JSONObject jsonObject = new JSONObject(jsonResponse);

            // Získání pole "body" jako JSONArray
            JSONArray bodyArray = jsonObject.getJSONArray("body");

            // Procházení všech stanic v poli "body"
            for (int i = 0; i < bodyArray.length(); i++) {
                NetatmoStationDto stationDto = new NetatmoStationDto();
                JSONObject station = bodyArray.getJSONObject(i);

                // Získání ID stanice
                String stationId = station.getString("_id");
                System.out.println("ID stanice: " + stationId);
                stationDto.setId(stationId);

                // Získání místa
                JSONObject place = station.getJSONObject("place");
                System.out.println("Město: " + place.getString("city"));
                String city = place.getString("city");
                stationDto.setCity(city);
                String street = place.optString("street", "neznámá"); // Pokud "street" chybí, vrátí "neznámá"
                stationDto.setStreet(street);
                JSONArray location = place.getJSONArray("location");
                double lon = location.getDouble(0); // Zeměpisná délka
                double lat = location.getDouble(1); // Zeměpisná šířka
                stationDto.setLat(String.valueOf(lat));
                stationDto.setLon(String.valueOf(lon));

                // Vytisknutí dat
//                System.out.println("ID stanice: " + stationId);
//                System.out.println("Město: " + city);
                System.out.println("Ulice: " + street);
                System.out.println("Zeměpisná šířka (lat): " + lat);
                System.out.println("Zeměpisná délka (lon): " + lon);
                // Získání měření
                JSONObject measures = station.getJSONObject("measures");

                // Procházení všech modulů
                for (String moduleId : measures.keySet()) {
                    JSONObject moduleData = measures.getJSONObject(moduleId);
                    System.out.println("Modul ID: " + moduleId);

//                    // Získání výsledků měření
//                    if (moduleData.has("res")) {
//                        JSONObject res = moduleData.getJSONObject("res");
//                        System.out.println("Výsledky měření: " + res);
//                    }
//
//                    // Získání typu měření
//                    if (moduleData.has("type")) {
//                        JSONArray types = moduleData.getJSONArray("type");
//                        System.out.println("Typy měření: " + types);
//                    }
                    // Získání výsledků měření
                    if (moduleData.has("res")) {
                        JSONObject res = moduleData.getJSONObject("res");

                        // Procházení jednotlivých měření v objektu "res"
                        for (String timestamp : res.keySet()) {
                            System.out.println(timestamp);
                            JSONArray values = res.getJSONArray(timestamp);

                            // Získání typu měření
                            if (moduleData.has("type")) {
                                JSONArray types = moduleData.getJSONArray("type");

                                // Procházení jednotlivých typů měření
                                for (int j = 0; j < types.length(); j++) {
                                    String type = types.getString(j);
                                    double value = values.getDouble(j);

                                    // Zobrazení hodnoty podle typu měření
                                    switch (type) {
                                        case "temperature":
                                            System.out.println("Teplota: " + value + " °C");
                                            stationDto.setTemperature(value);
                                            stationDto.setTempHumTimestamp(UnitConverterService.convertTimestampToDate(Long.valueOf(timestamp)));
                                            stationDto.setTempHumModuleId(moduleId);
                                            break;
                                        case "humidity":
                                            System.out.println("Vlhkost: " + value + " %");
                                            stationDto.setHumidity(value);
                                            break;
                                        case "pressure":
                                            System.out.println("Tlak: " + value + " hPa");
                                            stationDto.setPressure(value);
                                            stationDto.setPresTimestamp(UnitConverterService.convertTimestampToDate(Long.valueOf(timestamp)));
                                            stationDto.setPresModuleId(moduleId);
                                            break;
                                        default:
                                            System.out.println(type + ": " + value);
                                    }
                                }
                            }
                        }
                    }
                }
                stationsData.add(stationDto);
                System.out.println("---");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stationsData;
    }

    private static String getNewAccessToken() {
        // Nahraď následující hodnoty svými údaji
        String refreshToken = "69638da7f9df013c11075b24|d9baa629334fc4a68d0f2d63d780020b";

        HttpClient client = HttpClient.newHttpClient();

        // Sestavení těla požadavku
        String requestBody = String.format(
                "grant_type=refresh_token&" +
                        "refresh_token=%s&" +
                        "client_id=%s&" +
                        "client_secret=%s",
                URLEncoder.encode(refreshToken, StandardCharsets.UTF_8),
                URLEncoder.encode(clientId, StandardCharsets.UTF_8),
                URLEncoder.encode(clientSecret, StandardCharsets.UTF_8)
        );

        // Vytvoření požadavku
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.netatmo.com/oauth2/token"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        String newAccessToken = "";
        String newRefreshToken = "";
        try {
            // Odeslání požadavku
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Vytisknutí odpovědi
            System.out.println("Odpověď serveru: " + response.body());

            // Zpracování odpovědi (např. extrahování nového access tokenu)
            String responseBody = response.body();
            // Zde můžeš použít knihovnu jako `org.json` pro zpracování JSON odpovědi
            JSONObject jsonResponse = new JSONObject(responseBody);
            newAccessToken = jsonResponse.getString("access_token");
            newRefreshToken = jsonResponse.getString("refresh_token");

            System.out.println("Nový access token: " + newAccessToken);
            System.out.println("Nový refresh token: " + newRefreshToken);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newAccessToken;
    }
}
