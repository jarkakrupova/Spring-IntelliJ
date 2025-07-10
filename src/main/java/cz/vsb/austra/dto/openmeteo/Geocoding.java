package cz.vsb.austra.dto.openmeteo;

import java.util.ArrayList;

public class Geocoding {
    private ArrayList<Result> results;

    public ArrayList<Result> getResults() {
        return results;
    }

    public void setResults(ArrayList<Result> results) {
        this.results = results;
    }
}

