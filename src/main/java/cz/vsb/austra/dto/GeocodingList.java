package cz.vsb.austra.dto;

import java.util.ArrayList;

public class GeocodingList {
    private ArrayList<GeocodingDto> geocodingDtos = new ArrayList<>();

    public ArrayList<GeocodingDto> getGeocodingDtos() {
        return geocodingDtos;
    }

    public void setGeocodingDtos(ArrayList<GeocodingDto> geocodingDtos) {
        this.geocodingDtos = geocodingDtos;
    }
}
