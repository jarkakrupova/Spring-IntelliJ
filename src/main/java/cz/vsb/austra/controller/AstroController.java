package cz.vsb.austra.controller;

import cz.vsb.austra.dto.SunMoonAstroDto;
import cz.vsb.austra.service.AstroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class AstroController {
    AstroService service;
    @Autowired
    public AstroController(AstroService service) {
        this.service = service;
    }

    @CrossOrigin
    //@GetMapping("/astro/{city}")
    @RequestMapping(value = "/astro/{city}", method = RequestMethod.GET)
    public Mono<SunMoonAstroDto> getSunMoonAstroForCity(@PathVariable("city") String city){
        //City cityEnum = City.valueOf(city.toUpperCase());
        //service = new WeatherService();
        return service.getSunMoonAstroDataForCity(city);
    }
//    @CrossOrigin
//    @GetMapping("/astro")
//    public Collection<SunMoonAstroDto> getSunMoonAstro() {
//        List<SunMoonAstroDto> weatherList = new ArrayList<>();
//        //service = new WeatherService();
//        for(City city: City.values()) {
//            SunMoonAstroDto weatherDto = service.getSunMoonAstroDataForTheCity(city.name());
//            weatherList.add(weatherDto);
//        }
//        return weatherList;
//    }

    @CrossOrigin
    //@GetMapping("/astro/{city}")
    @RequestMapping(value = "/astro/{lat},{lon}", method = RequestMethod.GET)
    public Mono<SunMoonAstroDto> getSunMoonAstroForCity(@PathVariable("lat") double lat, @PathVariable("lon") double lon){
        //City cityEnum = City.valueOf(city.toUpperCase());
        //service = new WeatherService();
        return service.getSunMoonAstroDataForTheLatLon(lat, lon);
    }
}
