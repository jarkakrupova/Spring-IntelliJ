package cz.vsb.austra.controller;

import cz.vsb.austra.City;
import cz.vsb.austra.dto.WeatherDto;
import cz.vsb.austra.service.WeatherService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class WeatherController {

    WeatherService service;

    @Autowired
    public WeatherController(WeatherService service) {
        this.service = service;
    }

    /**
     * @param city the city to fetch info from - restricted to cities in City enum
     * @return the weather object for the city given
     */
    @CrossOrigin
    @GetMapping("/weather/{city}")
    public WeatherDto getWeatherForCity(@PathVariable("city") @Parameter(name = "city", description = "funguje pro Ostravu, Prahu, Rovaniemi, Sydney, Reykjavik a Valencii", example = "ostrava")String city ) {
        //City cityEnum = City.valueOf(city.toUpperCase());
        //service = new WeatherService();
        return service.getWeatherForCity(city);
    }

    @CrossOrigin
    @GetMapping("/weather")
    //[SwaggerResponse(HttpStatusCode.NotFound, Type = typeof(NotFoundResult))]
    public Collection<WeatherDto> getWeather() {
        List<WeatherDto> weatherList = new ArrayList<>();
        //service = new WeatherService();
        for (City city : City.values()) {
            WeatherDto weatherDto = service.getWeatherForCity(city.name());
            weatherList.add(weatherDto);
        }
        return weatherList;
    }

    @CrossOrigin
    @GetMapping("/weather/{lat}/{lon}")
    //[SwaggerResponse(HttpStatusCode.NotFound, Type = typeof(NotFoundResult))]
    public WeatherDto getWeatherForLatLon(@PathVariable("lat") double lat, @PathVariable("lon") double lon) {
        return service.getWeatherForCity(lat, lon);
    }
}
