package cz.vsb.austra.dto.meteostat;

import java.util.ArrayList;

public class Meta{
    private String generated;
    private ArrayList<String> stations;

    public String getGenerated() {
        return generated;
    }

    public void setGenerated(String generated) {
        this.generated = generated;
    }

    public ArrayList<String> getStations() {
        return stations;
    }

    public void setStations(ArrayList<String> stations) {
        this.stations = stations;
    }
}
