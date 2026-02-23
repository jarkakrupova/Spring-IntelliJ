package cz.vsb.austra.dto;

import java.time.LocalDate;
import java.util.ArrayList;

public class ForecastDto {
    private ArrayList<DailyDto> dailyData;

    public ForecastDto() {
        setDailyData(new ArrayList<>());
    }

    public ArrayList<DailyDto> getDailyData() {
        return dailyData;
    }

    public void setDailyData(ArrayList<DailyDto> dailyData) {
        this.dailyData = dailyData;
    }
    public String date;
}
