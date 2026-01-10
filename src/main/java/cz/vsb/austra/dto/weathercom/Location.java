package cz.vsb.austra.dto.weathercom;

import java.util.ArrayList;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
public class Location{
    private ArrayList<String> stationName;
    private ArrayList<String> stationId;
    private ArrayList<Integer> qcStatus;
    private ArrayList<Integer> updateTimeUtc;
    private ArrayList<String> partnerId;
    private ArrayList<Double> latitude;
    private ArrayList<Double> longitude;
    private ArrayList<Double> distanceKm;
    private ArrayList<Double> distanceMi;

    public ArrayList<String> getStationName() {
        return stationName;
    }

    public void setStationName(ArrayList<String> stationName) {
        this.stationName = stationName;
    }

    public ArrayList<String> getStationId() {
        return stationId;
    }

    public void setStationId(ArrayList<String> stationId) {
        this.stationId = stationId;
    }

    public ArrayList<Integer> getQcStatus() {
        return qcStatus;
    }

    public void setQcStatus(ArrayList<Integer> qcStatus) {
        this.qcStatus = qcStatus;
    }

    public ArrayList<Integer> getUpdateTimeUtc() {
        return updateTimeUtc;
    }

    public void setUpdateTimeUtc(ArrayList<Integer> updateTimeUtc) {
        this.updateTimeUtc = updateTimeUtc;
    }

    public ArrayList<String> getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(ArrayList<String> partnerId) {
        this.partnerId = partnerId;
    }

    public ArrayList<Double> getLatitude() {
        return latitude;
    }

    public void setLatitude(ArrayList<Double> latitude) {
        this.latitude = latitude;
    }

    public ArrayList<Double> getLongitude() {
        return longitude;
    }

    public void setLongitude(ArrayList<Double> longitude) {
        this.longitude = longitude;
    }

    public ArrayList<Double> getDistanceKm() {
        return distanceKm;
    }

    public void setDistanceKm(ArrayList<Double> distanceKm) {
        this.distanceKm = distanceKm;
    }

    public ArrayList<Double> getDistanceMi() {
        return distanceMi;
    }

    public void setDistanceMi(ArrayList<Double> distanceMi) {
        this.distanceMi = distanceMi;
    }
}
