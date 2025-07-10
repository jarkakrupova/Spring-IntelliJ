package cz.vsb.austra.dto.openmeteo;

import cz.vsb.austra.dto.DailyDto;
import cz.vsb.austra.dto.GeocodingDto;

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
}
