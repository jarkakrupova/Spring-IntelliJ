package cz.vsb.austra.dto.tomorrowio;

import cz.vsb.austra.dto.tomorrowio.forecast.Values;

public class Minutely{
    private String time;
    private Values values;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Values getValues() {
        return values;
    }

    public void setValues(Values values) {
        this.values = values;
    }
}
