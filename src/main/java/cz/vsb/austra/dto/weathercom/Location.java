package cz.vsb.austra.dto.weathercom;

import java.util.ArrayList;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
public class Location{
    public ArrayList<String> stationName;
    public ArrayList<String> stationId;
    public ArrayList<Integer> qcStatus;
    public ArrayList<Integer> updateTimeUtc;
    public ArrayList<String> partnerId;
    public ArrayList<Double> latitude;
    public ArrayList<Double> longitude;
    public ArrayList<Double> distanceKm;
    public ArrayList<Double> distanceMi;
}
