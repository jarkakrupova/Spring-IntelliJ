package cz.vsb.austra.dto.tomorrowio;

import java.util.ArrayList;

public class Timelines{
    private ArrayList<Minutely> minutely;
    private ArrayList<TomorrowioHourlyDto> hourly;
    private ArrayList<Daily> daily;

    public ArrayList<Minutely> getMinutely() {
        return minutely;
    }

    public void setMinutely(ArrayList<Minutely> minutely) {
        this.minutely = minutely;
    }

    public ArrayList<TomorrowioHourlyDto> getHourly() {
        return hourly;
    }

    public void setHourly(ArrayList<TomorrowioHourlyDto> hourly) {
        this.hourly = hourly;
    }

    public ArrayList<Daily> getDaily() {
        return daily;
    }

    public void setDaily(ArrayList<Daily> daily) {
        this.daily = daily;
    }
}
