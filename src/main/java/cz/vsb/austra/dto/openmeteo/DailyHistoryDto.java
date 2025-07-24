package cz.vsb.austra.dto.openmeteo;

import java.util.ArrayList;

public class DailyHistoryDto extends Daily {
    private ArrayList<String> daylight_time;
    private ArrayList<String> sunshine_time;

    public ArrayList<String> getSunshine_time() {
        return sunshine_time;
    }

    public void setSunshine_time(ArrayList<String> sunshine_time) {
        this.sunshine_time = sunshine_time;
    }

    public ArrayList<String> getDaylight_time() {
        return daylight_time;
    }

    public void setDaylight_time(ArrayList<String> daylight_time) {
        this.daylight_time = daylight_time;
    }
}
