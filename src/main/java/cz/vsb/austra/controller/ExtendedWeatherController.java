package cz.vsb.austra.controller;

import cz.vsb.austra.dto.ExtendedWeatherDto;
import cz.vsb.austra.service.ExtendedWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExtendedWeatherController {
    ExtendedWeatherService service;

    @Autowired
    public ExtendedWeatherController(ExtendedWeatherService service) {
        this.service = service;
    }

//    /**
//     * @param city the city to fetch info from - restricted to cities in City enum
//     * @return the extended weather object for the city given
//     */
//    @CrossOrigin
//    @GetMapping("/extended_weather/{city}")
//    public ExtendedWeatherDto getWeatherForLatLon(@PathVariable("city") String city) {
//        //City cityEnum = City.valueOf(city.toUpperCase());
//        return service.getWeatherForCity(city);
//    }

    @CrossOrigin
    @GetMapping("/extended_weather/{lat},{lon}")
    public ExtendedWeatherDto getWeatherForLatLon(@PathVariable("lat") double lat, @PathVariable("lon") double lon) {
        //City cityEnum = City.valueOf(city.toUpperCase());
        return service.getWeatherForCity(lat, lon);
    }

//    @CrossOrigin
//    @GetMapping("/extended_weather")
//    public Collection<WeatherDto> getWeather() {
//        List<WeatherDto> weatherList = new ArrayList<>();
//        //service = new WeatherService();
//        for (City city : City.values()) {
//            WeatherDto weatherDto = service.getWeatherForCity(city);
//            weatherList.add(weatherDto);
//        }
//        return weatherList;
//    }
//    public String getWeather(){
//        return "Počasí pro všechna města";
//    }
}
