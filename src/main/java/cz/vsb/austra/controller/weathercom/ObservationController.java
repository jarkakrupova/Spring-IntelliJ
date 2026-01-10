package cz.vsb.austra.controller.weathercom;

import cz.vsb.austra.dto.WeatherComObservationDto;
import cz.vsb.austra.dto.WeatherComStationObservationDto;
import cz.vsb.austra.service.ObservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ObservationController {
    ObservationService observationService;

    @Autowired
    public ObservationController(ObservationService observationService) {
        this.observationService = observationService;
    }

    @CrossOrigin
    @RequestMapping(value = "/observation/{lat},{lon}", method = RequestMethod.GET)
    public WeatherComObservationDto getObservationForLatLon(@PathVariable("lat") double lat, @PathVariable("lon") double lon){
        return observationService.getWeatherObservationForLatLon(lat, lon);
    }

    @CrossOrigin
    @RequestMapping(value = "/observation/{stationCode}", method = RequestMethod.GET)
    public WeatherComStationObservationDto getObservationForLatLon(@PathVariable("stationCode") String stationCode){
        return observationService.getWeatherObservationForStation(stationCode);
    }
}
