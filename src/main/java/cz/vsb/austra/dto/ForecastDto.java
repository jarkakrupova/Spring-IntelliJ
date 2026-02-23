package cz.vsb.austra.dto;

import java.util.ArrayList;

public class ForecastDto {
    private ArrayList<WeatherApiForecastDailyDto> dailyData;
    private ArrayList<TomorrowioForecastDayDto> tomorrowioForecastDays;

    public ForecastDto() {
        setDailyData(new ArrayList<>());
        setTomorrowioForecastDays(new ArrayList<>());
    }
    public ArrayList<TomorrowioForecastDayDto> getTomorrowioForecastDays() {
        return tomorrowioForecastDays;
    }

    public void setTomorrowioForecastDays(ArrayList<TomorrowioForecastDayDto> tomorrowioForecastDays) {
        this.tomorrowioForecastDays = tomorrowioForecastDays;
    }


    public ArrayList<WeatherApiForecastDailyDto> getDailyData() {
        return dailyData;
    }

    public void setDailyData(ArrayList<WeatherApiForecastDailyDto> dailyData) {
        this.dailyData = dailyData;
    }
    public String date;
}
