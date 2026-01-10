package cz.vsb.austra.dto.weathercom;

import java.util.ArrayList;

public class StationObservationDto {
    private ArrayList<StationObservation> observations;

    public ArrayList<StationObservation> getObservations() {
        return observations;
    }

    public void setObservations(ArrayList<StationObservation> observations) {
        this.observations = observations;
    }
}


