//package cz.vsb.austra.service;
//
//import cz.vsb.austra.City;
//import cz.vsb.austra.connector.WeatherApiConnector;
//import cz.vsb.austra.dto.weatherapi.WeatherApiDto;
//import cz.vsb.austra.dto.WeatherDto;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class WeatherService {
//    WeatherApiConnector connector;
//
//    @Autowired
//    public WeatherService(WeatherApiConnector connector) {
//        this.connector = connector;
//    }
//
//    public WeatherDto getWeatherForCity(String cityEnum) {
//        //connector = new WeatherApiConnector();
//        WeatherApiDto weatherApiDto = connector.getWeatherForCity(cityEnum);
//        return transformDto(weatherApiDto);
//    }
//

//
//    public WeatherDto getWeatherForCity(double lat, double lon) {
//        WeatherApiDto weatherApiDto = connector.getWeatherForCity(lat,lon);
//        return transformDto(weatherApiDto);
//    }
//}
package cz.vsb.austra.service;
import cz.vsb.austra.dto.WeatherDto;
import cz.vsb.austra.dto.weatherapi.WeatherApiDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WeatherService {

//    private final WebClient weatherByCoordinatesWebClient;
    private final WebClient weatherByCityWebClient;

    public WeatherService(
//            @Qualifier("weatherByCoordinatesWebClient") WebClient weatherByCoordinatesWebClient,
            @Qualifier("weatherApiCurrentWeatherWebClient") WebClient weatherApiCurrentWeatherWebClient) {
//        this.weatherByCoordinatesWebClient = weatherByCoordinatesWebClient;
        this.weatherByCityWebClient = weatherApiCurrentWeatherWebClient;
    }

    // Metoda pro volání s lat/lon
//    public Mono<WeatherApiDto> getWeatherForCoordinates(double lat, double lon) {
//        return weatherByCoordinatesWebClient.get()
//                .uri(uriBuilder -> uriBuilder
//                        .queryParam("q", lat)
//                        .build())
//                .retrieve()
//                .bodyToMono(WeatherApiDto.class);
//    }

    // Metoda pro volání s city
    public Mono<WeatherDto> getWeatherFromWeatherApi(String city) {
        return weatherByCityWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("q", city)
                        .build())
                .retrieve()
                .bodyToMono(WeatherApiDto.class)
                .map(this::transformDto);
    }

    private WeatherDto transformDto(WeatherApiDto weatherApiDto) {
        WeatherDto wDto = new WeatherDto();
        wDto.setLocation(weatherApiDto.getLocation().getName());
        wDto.setRel_humidity(weatherApiDto.getCurrent().getHumidity());
        wDto.setTemp_celsius(weatherApiDto.getCurrent().getTemp_c());
        wDto.setTimestamp(weatherApiDto.getLocation().getLocaltime());
        wDto.setWeatherDescription(weatherApiDto.getCurrent().getCondition().getText());
        wDto.setWindDirection(weatherApiDto.getCurrent().getWind_dir());
        wDto.setWindSpeed_mps(Math.round(weatherApiDto.getCurrent().getWind_kph() / 3.6));
        return wDto;
    }
}

