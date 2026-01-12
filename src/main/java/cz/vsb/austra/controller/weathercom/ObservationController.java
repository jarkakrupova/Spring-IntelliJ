package cz.vsb.austra.controller.weathercom;

import cz.vsb.austra.connector.weathercom.NearConnector;
import cz.vsb.austra.dto.WeatherComObservationDto;
import cz.vsb.austra.dto.WeatherComStationObservationDto;
import cz.vsb.austra.service.ObservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ObservationController {
    ObservationService observationService;
    NearConnector nearConnector;

    @Autowired
    public ObservationController(ObservationService observationService, NearConnector nearConnector) {
        this.observationService = observationService;
        this.nearConnector = nearConnector;
    }

    @CrossOrigin
    @RequestMapping(value = "/observation/{lat}/{lon}", method = RequestMethod.GET)
    public WeatherComObservationDto getObservationForLatLon(@PathVariable("lat") Double lat, @PathVariable("lon") Double lon) {
        System.out.println("Jedem");
        return observationService.getWeatherObservationForLatLon(lat, lon);
    }

    @CrossOrigin
    @RequestMapping(value = "/observation/{stationCode}", method = RequestMethod.GET)
    public WeatherComStationObservationDto getObservationForStation(@PathVariable("stationCode") String stationCode) {
        return observationService.getWeatherObservationForStation(stationCode);
    }

    @CrossOrigin
    @RequestMapping(value = "/nearby/{lat},{lon}", method = RequestMethod.GET)
    public List<WeatherComStationObservationDto> getNearbyStationsObservationsForLatLon(@PathVariable("lat") double lat, @PathVariable("lon") double lon) {
        List<String> stationIds = nearConnector.getNearbyStationIdsForLatLon(lat, lon);
        List<WeatherComStationObservationDto> nearbyStations = new ArrayList<>();
        for (String stationId : stationIds) {
            nearbyStations.add(observationService.getWeatherObservationForStation(stationId));
        }
        return nearbyStations;
    }
}
