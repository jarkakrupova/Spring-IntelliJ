package cz.vsb.austra.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    // WebClient pro volání s lat/lon
//    @Bean
//    public WebClient weatherByCoordinatesWebClient() {
//        return WebClient.builder()
//                .baseUrl("https://api.weatherapi.com/v1/current.json?key=2f3d5a0c8d0a4dd7986132149232003")
//                .build();
//    }

    // WebClient pro volání s city
    @Bean
    public WebClient weatherApiCurrentWeatherWebClient() {
        String apiKey = "2f3d5a0c8d0a4dd7986132149232003";
        return WebClient.builder()
                .baseUrl("https://api.weatherapi.com/v1/current.json?key="+apiKey)
                .build();
    }
}
