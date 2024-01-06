package cz.vsb.austra.service;

import cz.vsb.austra.City;
import cz.vsb.austra.connector.ForecastConnector;
import cz.vsb.austra.dto.*;

public class ForecastService {
    public ForecastDto getWeatherForCity(City cityEnum) {
        ForecastConnector connector = new ForecastConnector();
        ForecastApiDto forecastApiDto = connector.getForecastForCity(cityEnum);
        return transformDto(forecastApiDto);
    }

    private ForecastDto transformDto(ForecastApiDto forecastApiDto) {
        ForecastDto forecastDto = new ForecastDto();
        for (int i = 0; i < forecastApiDto.getForecast().getForecastday().size(); i++) {
            Forecastday fday = forecastApiDto.getForecast().getForecastday().get(i);
            Astro astro = fday.getAstro();
            DailyDto dailyDto = new DailyDto();
            SunMoonDto smdto = new SunMoonDto();
            smdto.setMoonrise(astro.getMoonrise());
            smdto.setMoonset(astro.getMoonset());
            smdto.setMoon_phase(astro.getMoon_phase());
            smdto.setSunset(astro.getSunset());
            smdto.setSunrise(astro.getSunrise());
            forecastDto.getDailyData().get(i).getSunMoonData().set(i, smdto);
        }
        return forecastDto;
    }
}
