package cz.vsb.austra.service;

import cz.vsb.austra.connector.FlagpediaConnector;
import cz.vsb.austra.connector.openmeteo.GeocodingConnector;
import cz.vsb.austra.dto.GeocodingDto;
import cz.vsb.austra.dto.GeocodingList;
import cz.vsb.austra.dto.openmeteo.Geocoding;
import cz.vsb.austra.dto.openmeteo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeocodingService {
    GeocodingConnector connector;
    FlagpediaConnector flagConnector;

    @Autowired
    public GeocodingService(GeocodingConnector connector, FlagpediaConnector flagConnector) {
        this.connector = connector;
        this.flagConnector = flagConnector;
    }

    public GeocodingList getGeocodingForTheCity(String city, int count) {
        Geocoding geocodingDto = connector.getGeocodingForCity(city, count);
        return transformDto(geocodingDto);
    }

    private GeocodingList transformDto(Geocoding geocodingInput) {
        GeocodingList geocodingList = new GeocodingList();
        for (Result result : geocodingInput.getResults()) {
            GeocodingDto geocodingDto = new GeocodingDto();
            geocodingDto.setId(result.getId());
            geocodingDto.setAdmin1_id(result.getAdmin1_id());
            geocodingDto.setAdmin1(result.getAdmin1());
            geocodingDto.setAdmin2(result.getAdmin2());
            geocodingDto.setAdmin2_id(result.getAdmin2_id());
            geocodingDto.setAdmin3(result.getAdmin3());
            geocodingDto.setAdmin3_id(result.getAdmin3_id());
            geocodingDto.setAdmin4(result.getAdmin4());
            geocodingDto.setAdmin4_id(result.getAdmin4_id());
            geocodingDto.setElevation(result.getElevation());
            geocodingDto.setCountry(result.getCountry());
            geocodingDto.setCountry_code(result.getCountry_code());
            geocodingDto.setFeature_code(result.getFeature_code());
            geocodingDto.setCountry_id(result.getCountry_id());
            geocodingDto.setLatitude(result.getLatitude());
            geocodingDto.setLongitude(result.getLongitude());
            geocodingDto.setName(result.getName());
            geocodingDto.setTimezone(result.getTimezone());
            geocodingDto.setPopulation(result.getPopulation());
            geocodingDto.setPostcodes(result.getPostcodes());
            String flagUrl = flagConnector.getFlagForCountry(result.getCountry_code());
            geocodingDto.setFlagUrl(flagUrl);
            geocodingList.getGeocodingDtos().add(geocodingDto);
        }
        return geocodingList;
    }

    public GeocodingDto getGeocodingForId(int id) {
        Result geocodingDto = connector.getGeocodingForId(id);
        return transformDto(geocodingDto);
    }

    private GeocodingDto transformDto(Result result) {
        GeocodingDto geocodingDto = new GeocodingDto();
        geocodingDto.setId(result.getId());
        geocodingDto.setAdmin1_id(result.getAdmin1_id());
        geocodingDto.setAdmin1(result.getAdmin1());
        geocodingDto.setAdmin2(result.getAdmin2());
        geocodingDto.setAdmin2_id(result.getAdmin2_id());
        geocodingDto.setAdmin3(result.getAdmin3());
        geocodingDto.setAdmin3_id(result.getAdmin3_id());
        geocodingDto.setAdmin4(result.getAdmin4());
        geocodingDto.setAdmin4_id(result.getAdmin4_id());
        geocodingDto.setElevation(result.getElevation());
        geocodingDto.setCountry(result.getCountry());
        geocodingDto.setCountry_code(result.getCountry_code());
        geocodingDto.setFeature_code(result.getFeature_code());
        geocodingDto.setCountry_id(result.getCountry_id());
        geocodingDto.setLatitude(result.getLatitude());
        geocodingDto.setLongitude(result.getLongitude());
        geocodingDto.setName(result.getName());
        geocodingDto.setTimezone(result.getTimezone());
        geocodingDto.setPopulation(result.getPopulation());
        geocodingDto.setPostcodes(result.getPostcodes());
        return geocodingDto;
    }
}
