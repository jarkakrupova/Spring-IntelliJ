package cz.vsb.austra.service;

import cz.vsb.austra.connector.netatmo.NetatmoConnector;
import cz.vsb.austra.dto.NetatmoStationDto;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NetatmoService {
    NetatmoConnector netatmoConnector;

    @Autowired
    public NetatmoService(NetatmoConnector netatmoConnector) {
        this.netatmoConnector = netatmoConnector;
    }

    public List<NetatmoStationDto> getNetatmoStationsDataForSquare(Double latNe, Double lonNe, Double latSw, Double lonSw, Integer zoom) {
        String response = netatmoConnector.getStationsDataForSquare(latNe, lonNe, latSw, lonSw, zoom);
        return transformJsonToData(response);
    }

    List<NetatmoStationDto> transformJsonToData(String jsonResponse) {
        List<NetatmoStationDto> stationsData = new ArrayList<>();
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
//            System.out.println("Město: " + place.getString("city"));
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
//            System.out.println("Ulice: " + street);
            System.out.println("Zeměpisná šířka (lat): " + lat);
            System.out.println("Zeměpisná délka (lon): " + lon);
            // Získání měření
            JSONObject measures = station.getJSONObject("measures");

            // Procházení všech modulů
            for (String moduleId : measures.keySet()) {
                JSONObject moduleData = measures.getJSONObject(moduleId);
//                System.out.println("Modul ID: " + moduleId);

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
//                        System.out.println(timestamp);
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
//                                        System.out.println("Teplota: " + value + " °C");
                                        stationDto.setTemperature(value);
                                        stationDto.setTempHumTimestamp(UnitConverterService.convertTimestampToDate(Long.valueOf(timestamp)));
                                        stationDto.setTempHumModuleId(moduleId);
                                        break;
                                    case "humidity":
//                                        System.out.println("Vlhkost: " + value + " %");
                                        stationDto.setHumidity(value);
                                        break;
                                    case "pressure":
//                                        System.out.println("Tlak: " + value + " hPa");
                                        stationDto.setPressure(value);
                                        stationDto.setPresTimestamp(UnitConverterService.convertTimestampToDate(Long.valueOf(timestamp)));
                                        stationDto.setPresModuleId(moduleId);
                                        break;
                                    default:
//                                        System.out.println(type + ": " + value);
                                }
                            }
                        }
                    }
                }
                if (moduleData.has("rain_60min")) {
                    double rain60min = moduleData.getDouble("rain_60min");
                    double rain24h = moduleData.getDouble("rain_24h");
                    double rainLive = moduleData.getDouble("rain_live");
                    long rainTimeutc = moduleData.getLong("rain_timeutc");
                    stationDto.setRain24h(rain24h);
                    stationDto.setRainLive(rainLive);
                    stationDto.setRain60min(rain60min);
                    stationDto.setRainTimeutc(UnitConverterService.convertTimestampToDate(rainTimeutc));
                }
                if (moduleData.has("wind_strength")) {

                    // Extrahování dat o větru
                    double windStrength = moduleData.getDouble("wind_strength");
                    int windAngle = moduleData.getInt("wind_angle");
                    double gustStrength = moduleData.getDouble("gust_strength");
                    double gustAngle = moduleData.getDouble("gust_angle");
                    long windTimeutc = moduleData.getLong("wind_timeutc");
                    stationDto.setGustStrength(gustStrength);
                    stationDto.setGustAngle(gustAngle);
                    stationDto.setWindAngle(windAngle);
                    stationDto.setWindStrength(windStrength);
                    stationDto.setWindTimeutc(UnitConverterService.convertTimestampToDate(windTimeutc));
                }
            }
            stationsData.add(stationDto);
            System.out.println("---");
        }
        return stationsData;
    }
}
