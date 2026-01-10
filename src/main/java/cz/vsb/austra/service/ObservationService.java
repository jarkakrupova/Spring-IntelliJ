package cz.vsb.austra.service;

import cz.vsb.austra.connector.weathercom.ObservationsConnector;
import cz.vsb.austra.dto.WeatherComObservationDto;
import cz.vsb.austra.dto.WeatherComStationObservationDto;
import cz.vsb.austra.dto.weathercom.ObservationDto;
import cz.vsb.austra.dto.weathercom.StationObservationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObservationService {
    ObservationsConnector observationsConnector;

    @Autowired
    public ObservationService(ObservationsConnector observationsConnector) {
        this.observationsConnector = observationsConnector;
    }

    public WeatherComObservationDto getWeatherObservationForLatLon(Double lat, Double lon){
        var apiData = observationsConnector.getWeatherForLatLon(lat, lon);
        return transformDto(apiData);
    }

    public WeatherComStationObservationDto getWeatherObservationForStation(String stationCode){
        var apiData = observationsConnector.getWeatherForStation(stationCode);
        return transformDto(apiData);
    }

    private WeatherComStationObservationDto transformDto(StationObservationDto apiData) {
        WeatherComStationObservationDto result = new WeatherComStationObservationDto();
        result.setCountry(apiData.getObservations().get(0).getCountry());
        result.setDewpt(apiData.getObservations().get(0).getMetric().getDewpt());
        result.setElev(apiData.getObservations().get(0).getMetric().getElev());
        result.setLat(apiData.getObservations().get(0).getLat());
        result.setHumidity(apiData.getObservations().get(0).getHumidity());
        result.setLon(apiData.getObservations().get(0).getLon());
        result.setNeighborhood(apiData.getObservations().get(0).getNeighborhood());
        result.setHeatIndex(apiData.getObservations().get(0).getMetric().getHeatIndex());
        result.setObsTimeLocal(apiData.getObservations().get(0).getObsTimeLocal());
        result.setObsTimeUtc(apiData.getObservations().get(0).getObsTimeUtc());
        result.setPrecipTotal(apiData.getObservations().get(0).getMetric().getPrecipTotal());
        result.setPrecipRate(apiData.getObservations().get(0).getMetric().getPrecipRate());
        result.setPressure(apiData.getObservations().get(0).getMetric().getPressure());
        result.setSolarRadiation(apiData.getObservations().get(0).getSolarRadiation());
        result.setStationID(apiData.getObservations().get(0).getStationID());
        result.setTemp(apiData.getObservations().get(0).getMetric().getTemp());
        result.setUpdateIntervalMinutes(apiData.getObservations().get(0).getRealtimeFrequency());
        result.setUv(apiData.getObservations().get(0).getUv());
        result.setWindChill(apiData.getObservations().get(0).getMetric().getWindChill());
        result.setWindDir(apiData.getObservations().get(0).getWinddir());
        result.setWindGust(apiData.getObservations().get(0).getMetric().getWindGust());
        result.setWindSpeed(apiData.getObservations().get(0).getMetric().getWindSpeed());
        return result;
    }

    private WeatherComObservationDto transformDto(ObservationDto apiData) {
        WeatherComObservationDto result = new WeatherComObservationDto();
        result.setCloudCover(apiData.getCloudCover());
        result.setDayOfWeek(apiData.getDayOfWeek());
        result.setIconCode(apiData.getIconCode());
        result.setPressureChange(apiData.getPressureChange());
        result.setTemperature(apiData.getTemperature());
        result.setCloudCoverPhrase(apiData.getCloudCoverPhrase());
        result.setVisibility(apiData.getVisibility());
        result.setRelativeHumidity(apiData.getRelativeHumidity());
        result.setIconCodeExtend(apiData.getIconCodeExtend());
        result.setWindDirection(apiData.getWindDirection());
        result.setPressureMeanSeaLevel(apiData.getPressureMeanSeaLevel());
        result.setPressureTendencyTrend(apiData.getPressureTendencyTrend());
        result.setTemperatureChange24Hour(apiData.getTemperatureChange24Hour());
        result.setTemperatureDewPoint(apiData.getTemperatureDewPoint());
        result.setTemperatureFeelsLike(apiData.getTemperatureFeelsLike());
        result.setTemperatureHeatIndex(apiData.getTemperatureHeatIndex());
        result.setUvDescription(apiData.getUvDescription());
        result.setUvIndex(apiData.getUvIndex());
        result.setValidTimeLocal(UnitConverterService.convertIsoToCustomFormat(apiData.getValidTimeLocal().substring(0,19)));
        result.setWindDirectionCardinal(apiData.getWindDirectionCardinal());
        result.setWindGust(apiData.getWindGust());
        result.setWindSpeed(apiData.getWindSpeed());
        result.setWxPhraseLong(apiData.getWxPhraseLong());
        return result;
    }

}
