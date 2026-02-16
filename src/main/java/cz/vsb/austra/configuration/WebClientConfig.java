package cz.vsb.austra.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    //----------------/
    //WEATHERAPI.COM//
    //---------------/

    // WebClient pro volání aktuálního počasí z WeatherApi
    //https://api.weatherapi.com/v1/current.json?key=2f3d5a0c8d0a4dd7986132149232003&q=49.89,18.18&aqi=no
    @Bean
    public WebClient weatherApiCurrentWeatherWebClient() {
        String apiKey = "2f3d5a0c8d0a4dd7986132149232003";
        return WebClient.builder()
                .baseUrl("https://api.weatherapi.com/v1/current.json?key=" + apiKey)
                .build();
    }

    //http://api.weatherapi.com/v1/search.json?key=2f3d5a0c8d0a4dd7986132149232003&q=ostrava
    @Bean
    public WebClient weatherApiLocationWebClient() {
        String apiKey = "2f3d5a0c8d0a4dd7986132149232003";
        return WebClient.builder()
                .baseUrl("http://api.weatherapi.com/v1/search.json?key=" + apiKey)
                .build();
    }

    // WebClient pro volání předpovědi z WeatherApi
    //https://api.weatherapi.com/v1/forecast.json?key=2f3d5a0c8d0a4dd7986132149232003&q=Ostrava&days=3&aqi=no&alerts=no
    //anebo https://api.weatherapi.com/v1/forecast.json?key=2f3d5a0c8d0a4dd7986132149232003&q=49.89,18.18&days=3
    @Bean
    public WebClient weatherApiForecastWebClient() {
        String apiKey = "2f3d5a0c8d0a4dd7986132149232003";
        return WebClient.builder()
                .baseUrl("https://api.weatherapi.com/v1/forecast.json?key=" + apiKey)
                .build();
    }

    // WebClient pro volání předpovědi z WeatherApi
    //http://api.weatherapi.com/v1/astronomy.json?key=2f3d5a0c8d0a4dd7986132149232003&q=ostrava&dt=2024-07-26

    @Bean
    public WebClient weatherApiAstroWebClient() {
        String apiKey = "2f3d5a0c8d0a4dd7986132149232003";
        return WebClient.builder()
                .baseUrl("http://api.weatherapi.com/v1/astronomy.json?key=" + apiKey)
                .build();
    }

    //----------------/
    //OPEN-METEO.COM//
    //---------------/

    //všechny: https://geocoding-api.open-meteo.com/v1/search?name=Side&count=10&language=en&format=json
    @Bean
    public WebClient openMeteoGeocodingSearchWebClient() {
        return WebClient.builder()
                .baseUrl("https://geocoding-api.open-meteo.com/v1/search?" )
                .build();
    }
    //1 kus: https://geocoding-api.open-meteo.com/v1/get?id=2950159
    @Bean
    public WebClient openMeteoGeocodingByIdWebClient() {
        return WebClient.builder()
                .baseUrl("https://geocoding-api.open-meteo.com/v1/get?")
                .build();
    }

//https://archive-api.open-meteo.com/v1/archive?latitude=52.52&longitude=13.41&start_date=2024-07-10&end_date=2024-07-24&daily=weather_code,temperature_2m_max,temperature_2m_min,temperature_2m_mean,apparent_temperature_max,apparent_temperature_min,apparent_temperature_mean,sunrise,sunset,daylight_duration,sunshine_duration,precipitation_sum,rain_sum,snowfall_sum,precipitation_hours,wind_speed_10m_max,wind_gusts_10m_max,wind_direction_10m_dominant&timezone=Europe%2FBerlin
@Bean
public WebClient openMeteoHistoricalWeatherWebClient() {
    String apiKey = "2f3d5a0c8d0a4dd7986132149232003";
    return WebClient.builder()
            .baseUrl("https://archive-api.open-meteo.com/v1/archive?" + apiKey)
            .build();
}

}
