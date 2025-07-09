package cz.vsb.austra.service;

import cz.vsb.austra.City;
import cz.vsb.austra.connector.AstroConnector;
import cz.vsb.austra.connector.LocationConnector;
import cz.vsb.austra.connector.SunriseSunsetConnector;
import cz.vsb.austra.dto.*;
import cz.vsb.austra.dto.weatherapi.AstroApiDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AstroService {
    SunriseSunsetConnector connector;
    LocationConnector locationConnector;
    AstroConnector astroConnector;

    @Autowired
    public AstroService(SunriseSunsetConnector connector, LocationConnector locationConnector, AstroConnector astroConnector) {
        this.connector = connector;
        this.locationConnector = locationConnector;
        this.astroConnector = astroConnector;
    }

    public SunMoonAstroDto getSunMoonAstroDataForTheCity(String city) {
        //LocationConnector locationConnector = new LocationConnector();
        SearchLocation cityLocation = locationConnector.getLocationForCity(city)[0];
        double lat = cityLocation.getLat();
        double lng = cityLocation.getLon();
        //SunriseSunsetConnector connector = new SunriseSunsetConnector();
        SunriseSunsetApiDto sunriseSunsetApiDto = connector.getForecastForCity(lat, lng);
        //AstroConnector astroConnector = new AstroConnector();
        AstroApiDto astroApiDto = astroConnector.getAstroForCity(city);
        return transformDto(sunriseSunsetApiDto, astroApiDto);
    }

    private SunMoonAstroDto transformDto(SunriseSunsetApiDto sunriseSunsetApiDto, AstroApiDto astroApiDto) {
        SunMoonAstroDto sunMoonDto = new SunMoonAstroDto();
        sunMoonDto.setMoon_phase(astroApiDto.getAstronomy().getAstro().getMoon_phase());
        sunMoonDto.setMoonrise(astroApiDto.getAstronomy().getAstro().getMoonrise());
        sunMoonDto.setMoonset(astroApiDto.getAstronomy().getAstro().getMoonset());
        sunMoonDto.setSunrise(astroApiDto.getAstronomy().getAstro().getSunrise());
        sunMoonDto.setSunset(astroApiDto.getAstronomy().getAstro().getSunset());
        sunMoonDto.setDawn(sunriseSunsetApiDto.getResults().getDawn());
        sunMoonDto.setDusk(sunriseSunsetApiDto.getResults().getDusk());
        sunMoonDto.setDayLength(sunriseSunsetApiDto.getResults().getDay_length());
        sunMoonDto.setFirst_light(sunriseSunsetApiDto.getResults().getFirst_light());
        sunMoonDto.setLast_light(sunriseSunsetApiDto.getResults().getLast_light());
        sunMoonDto.setGoldenHour(sunriseSunsetApiDto.getResults().getGolden_hour());
        sunMoonDto.setTimezone(sunriseSunsetApiDto.getResults().getTimezone());
        return sunMoonDto;
    }
}
