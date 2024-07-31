package cz.vsb.austra.service;

import cz.vsb.austra.City;
import cz.vsb.austra.connector.ClimateNormalsConnector;
import cz.vsb.austra.connector.LocationConnector;
import cz.vsb.austra.dto.SearchLocation;
import cz.vsb.austra.dto.meteostat.ClimateNormalApiDto;
import cz.vsb.austra.dto.meteostat.Datum;
import cz.vsb.austra.dto.meteostat.MonthlyClimateNormalDto;
import cz.vsb.austra.dto.meteostat.MonthlyNormalDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClimateNormalsService {
    LocationConnector locationConnector;
    ClimateNormalsConnector connector;

    @Autowired
    public ClimateNormalsService(LocationConnector locationConnector, ClimateNormalsConnector connector) {
        this.locationConnector = locationConnector;
        this.connector = connector;
    }

    public MonthlyClimateNormalDto getSunMoonAstroDataForTheCity(City city) {
        //LocationConnector locationConnector = new LocationConnector();
        SearchLocation cityLocation = locationConnector.getLocationForCity(city)[0];
        double lat = cityLocation.getLat();
        double lng = cityLocation.getLon();
        //ClimateNormalsConnector connector = new ClimateNormalsConnector();
        ClimateNormalApiDto climateNormalApiDto = connector.getClimateNormalForLatLon(lat, lng);
        return transformDto(climateNormalApiDto);
    }

    private MonthlyClimateNormalDto transformDto(ClimateNormalApiDto climateNormalApiDto) {
        MonthlyClimateNormalDto monthlyClimateNormalDto = new MonthlyClimateNormalDto();
        for (Datum datum : climateNormalApiDto.getData()) {
            MonthlyNormalDto monthlyNormalDto = new MonthlyNormalDto();
            monthlyNormalDto.setAverageDailyTemperature(datum.getTavg());
            monthlyNormalDto.setAverageAirPressureSeaLevelHpa(datum.getPres());
            monthlyNormalDto.setMonth(datum.getMonth());
            monthlyNormalDto.setMonthlyPrecipitationTotalInMm(datum.getPrcp());
            monthlyNormalDto.setAverageMaximumDailyTemperature(datum.getTmax());
            monthlyNormalDto.setAverageMinimalDailyTemperature(datum.getTmin());
            monthlyNormalDto.setAverageSunshineMinutes(datum.getTsun());
            monthlyNormalDto.setMonthInWords("Dopln....");
            monthlyNormalDto.setAverageWindSpeedKmH(datum.getWspd());
            monthlyClimateNormalDto.getMonthlyNormals().add(monthlyNormalDto);
        }
        return monthlyClimateNormalDto;
    }
}
