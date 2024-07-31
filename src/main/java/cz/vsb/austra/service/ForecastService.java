package cz.vsb.austra.service;

import cz.vsb.austra.City;
import cz.vsb.austra.connector.ForecastConnector;
import cz.vsb.austra.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ForecastService {
    @Autowired
    public ForecastService(ForecastConnector connector) {
        this.connector = connector;
    }

    ForecastConnector connector;
    public ForecastDto getWeatherForCity(City cityEnum) {
        //ForecastConnector connector = new ForecastConnector();
        ForecastApiDto forecastApiDto = connector.getForecastForCity(cityEnum);
        return transformDto(forecastApiDto);
    }

    private ForecastDto transformDto(ForecastApiDto forecastApiDto) {
        ForecastDto forecastDto = new ForecastDto();
        for (int i = 0; i < forecastApiDto.getForecast().getForecastday().size(); i++) {
            Forecastday fday = forecastApiDto.getForecast().getForecastday().get(i);
            Astro astro = fday.getAstro();
            SunMoonAstroDto smdto = new SunMoonAstroDto();
            smdto.setMoonrise(astro.getMoonrise());
            smdto.setMoonset(astro.getMoonset());
            smdto.setMoon_phase(astro.getMoon_phase());
            smdto.setSunset(astro.getSunset());
            smdto.setSunrise(astro.getSunrise());
            forecastDto.getDailyData().add(new DailyDto());
            forecastDto.getDailyData().get(i).setSunMoonData(smdto);

            Day day = fday.getDay();
            MinMaxPrecipSnowDto minMaxPrecipSnowDto = new MinMaxPrecipSnowDto();
            minMaxPrecipSnowDto.setChance_of_snow(day.getDaily_chance_of_snow());
            minMaxPrecipSnowDto.setMax_temperature(day.getMaxtemp_c());
            minMaxPrecipSnowDto.setMin_temperature(day.getMintemp_c());
            minMaxPrecipSnowDto.setTotal_precip_mm(day.getTotalprecip_mm());
            minMaxPrecipSnowDto.setTotal_snow_cm(day.getTotalsnow_cm());
            minMaxPrecipSnowDto.setAvg_temperature(day.getAvgtemp_c());
            minMaxPrecipSnowDto.setChance_of_rain(day.getDaily_chance_of_rain());
            forecastDto.getDailyData().get(i).setMinMaxPrecipSnowData(minMaxPrecipSnowDto);
            ArrayList<Hour> hours = fday.getHour();
            for (int j = 0; j < hours.size(); j++) {
                HourlyDto wDto = new HourlyDto();
                wDto.setLocation(forecastApiDto.getLocation().getName());
                wDto.setRel_humidity(hours.get(j).getHumidity());
                wDto.setTemp_celsius(hours.get(j).getTemp_c());
                wDto.setTimestamp(hours.get(j).getTime());
                wDto.setWeatherDescription(hours.get(j).getCondition().getText());
                wDto.setWindDirection(hours.get(j).getWind_dir());
                wDto.setWindSpeed_mps(Math.round(hours.get(j).getWind_kph() / 3.6));
                wDto.setCloud(hours.get(j).getCloud());
                wDto.setFeelslike_c(hours.get(j).getFeelslike_c());
                wDto.setPressure_mb(hours.get(j).getPressure_mb());
                wDto.setSnow_cm(hours.get(j).getSnow_cm());
                wDto.setIcon(hours.get(j).getCondition().getIcon());
                wDto.setPrecip_mm(hours.get(i).getPrecip_mm());
                forecastDto.getDailyData().get(i).getHourlyData().add(wDto);
            }
        }
        return forecastDto;
    }
}
