package cz.vsb.austra.service;

import cz.vsb.austra.connector.weathercom.NearConnector;
import cz.vsb.austra.connector.weathercom.ObservationsConnector;
import cz.vsb.austra.dto.NetatmoStationDto;
import cz.vsb.austra.dto.WeatherComStationObservationDto;
import cz.vsb.austra.dto.WeatherStationDto;
import cz.vsb.austra.dto.weathercom.ObservationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonalWeatherStationService {
    NetatmoService netatmoService;
    ObservationService observationService;
    NearConnector nearConnector;

    @Autowired
    public PersonalWeatherStationService(NetatmoService netatmoService, ObservationService observationService, NearConnector nearConnector) {
        this.netatmoService = netatmoService;
        this.observationService = observationService;
        this.nearConnector = nearConnector;
    }

    public List<WeatherStationDto> getWeatherDataForStations(Double lat, Double lon) {
        var netatmoData = netatmoService.getNetatmoStationsDataForSquare(lat + 0.05, lon + 0.05, lat - 0.05, lon - 0.05, 15);
        //var wuData = observationsConnector.getWeatherForLatLon(lat, lon);
        //nastane, pokud v oblasti nejsou stanice: zvetsit polomer nebo se na to vybodnout?
        if (netatmoData.isEmpty()) {
            netatmoData = netatmoService.getNetatmoStationsDataForSquare(lat + 0.1, lon + 0.1, lat - 0.1, lon - 0.1, 15);
        }
        List<String> stationIds = nearConnector.getNearbyStationIdsForLatLon(lat, lon);
        List<WeatherComStationObservationDto> nearbyStations = new ArrayList<>();
        for (String stationId : stationIds) {
            var observation = observationService.getWeatherObservationForStation(stationId);
            if (observation!=null) {
                nearbyStations.add(observation);
            }
        }

        return transformData(netatmoData, nearbyStations);
    }

    private List<WeatherStationDto> transformData(List<NetatmoStationDto> netatmoData, List<WeatherComStationObservationDto> wuData) {
        List<WeatherStationDto> weatherStationDtos = new ArrayList<>();
        if (!netatmoData.isEmpty()) {
            for (NetatmoStationDto netatmoStationDto : netatmoData) {
                WeatherStationDto weatherStationDto = new WeatherStationDto();
                //elev a country by se daly zjistit pres geocoding;
                weatherStationDto.setHumidity(netatmoStationDto.getHumidity());
                weatherStationDto.setLatitude(Double.valueOf(netatmoStationDto.getLat()));
                weatherStationDto.setLongitude(Double.valueOf(netatmoStationDto.getLon()));
                weatherStationDto.setNeighborhood(netatmoStationDto.getCity() + (netatmoStationDto.getStreet().equals("neznámá")||netatmoStationDto.getStreet().equals("unnamed road")?"":", "+netatmoStationDto.getStreet()));
                weatherStationDto.setGustAngle(netatmoStationDto.getGustAngle());
                weatherStationDto.setObsTimeLocal(netatmoStationDto.getPresTimestamp());
                weatherStationDto.setRain24h(netatmoStationDto.getRain24h());
                weatherStationDto.setRain60min(netatmoStationDto.getRain60min());
                weatherStationDto.setRainLive(netatmoStationDto.getRainLive());
                weatherStationDto.setRainTimeutc(netatmoStationDto.getRainTimeutc());
                weatherStationDto.setStationId(netatmoStationDto.getId());
                weatherStationDto.setPressure(netatmoStationDto.getPressure());
                weatherStationDto.setWindStrength(netatmoStationDto.getWindStrength());
                weatherStationDto.setWindDir(netatmoStationDto.getWindAngle() == null ? null : netatmoStationDto.getWindAngle());
                weatherStationDto.setTemperature(netatmoStationDto.getTemperature() == null ? null : netatmoStationDto.getTemperature());
                weatherStationDtos.add(weatherStationDto);
            }
        }
        if (!wuData.isEmpty()) {
            for (WeatherComStationObservationDto weatherComStationObservationDto : wuData) {
                WeatherStationDto weatherStationDto = new WeatherStationDto();
                weatherStationDto.setLatitude(weatherComStationObservationDto.getLat());
                weatherStationDto.setLongitude(weatherComStationObservationDto.getLon());
                weatherStationDto.setLatitude(weatherComStationObservationDto.getLat());
                weatherStationDto.setNeighborhood(weatherComStationObservationDto.getNeighborhood());
                weatherStationDto.setStationId(weatherComStationObservationDto.getStationID());
                weatherStationDto.setObsTimeUtc(weatherComStationObservationDto.getObsTimeUtc());
                weatherStationDto.setObsTimeLocal(weatherComStationObservationDto.getObsTimeLocal());
                weatherStationDto.setObsTimeLocal(weatherComStationObservationDto.getObsTimeLocal());
                weatherStationDto.setPrecipRate(weatherComStationObservationDto.getPrecipRate());
                weatherStationDto.setHeatIndex(weatherComStationObservationDto.getHeatIndex());
                weatherStationDto.setUv(weatherComStationObservationDto.getUv());
                weatherStationDto.setCountry(weatherComStationObservationDto.getCountry());
                weatherStationDto.setDewpt(weatherComStationObservationDto.getDewpt());
                weatherStationDto.setSolarRadiation(weatherComStationObservationDto.getSolarRadiation());
                weatherStationDto.setPressure(weatherComStationObservationDto.getPressure());
                weatherStationDto.setTemperature(weatherComStationObservationDto.getTemp());
                weatherStationDto.setPrecipTotal(weatherComStationObservationDto.getPrecipTotal());
                weatherStationDto.setHumidity(weatherComStationObservationDto.getHumidity() == null ? null : Double.valueOf(weatherComStationObservationDto.getHumidity()));
                weatherStationDto.setWindGust(weatherComStationObservationDto.getWindGust());
                weatherStationDto.setWindDir(weatherComStationObservationDto.getWindDir());
                weatherStationDto.setWindChill(weatherComStationObservationDto.getWindChill());
                weatherStationDto.setWindSpeed(weatherComStationObservationDto.getWindSpeed());

                weatherStationDtos.add(weatherStationDto);
            }
        }
        return weatherStationDtos;
    }
}
