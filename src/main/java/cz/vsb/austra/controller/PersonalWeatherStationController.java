package cz.vsb.austra.controller;

import cz.vsb.austra.dto.WeatherStationDto;
import cz.vsb.austra.service.NetatmoService;
import cz.vsb.austra.service.ObservationService;
import cz.vsb.austra.service.PersonalWeatherStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class PersonalWeatherStationController {
    PersonalWeatherStationService service;

    @Autowired
    public PersonalWeatherStationController(PersonalWeatherStationService service) {
        this.service = service;
    }

    @GetMapping("/stationData/{lat}/{lon}")
    public List<WeatherStationDto> getWeatherForLatLon(@PathVariable("lat") Double lat, @PathVariable("lon") Double lon) {
        var stationsData = service.getWeatherDataForStations(lat, lon);
        return stationsData;
    }
}
