package cz.vsb.austra.dto.weathercom;

import java.time.LocalDate;

public class StationObservation {
    private String stationID;
    private LocalDate obsTimeUtc;
    private String obsTimeLocal;
    private String neighborhood;
    private String softwareType;
    private String country;
    private Double solarRadiation;
    private Double lon;
    private Integer realtimeFrequency;
    private Integer epoch;
    private Double lat;
    private Double uv;
    private Integer winddir;
    private Integer humidity;
    private Integer qcStatus;
    private StationObservationMetricElements metric;

    public String getStationID() {
        return stationID;
    }

    public void setStationID(String stationID) {
        this.stationID = stationID;
    }

    public LocalDate getObsTimeUtc() {
        return obsTimeUtc;
    }

    public void setObsTimeUtc(LocalDate obsTimeUtc) {
        this.obsTimeUtc = obsTimeUtc;
    }

    public String getObsTimeLocal() {
        return obsTimeLocal;
    }

    public void setObsTimeLocal(String obsTimeLocal) {
        this.obsTimeLocal = obsTimeLocal;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getSoftwareType() {
        return softwareType;
    }

    public void setSoftwareType(String softwareType) {
        this.softwareType = softwareType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getSolarRadiation() {
        return solarRadiation;
    }

    public void setSolarRadiation(Double solarRadiation) {
        this.solarRadiation = solarRadiation;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Integer getRealtimeFrequency() {
        return realtimeFrequency;
    }

    public void setRealtimeFrequency(Integer realtimeFrequency) {
        this.realtimeFrequency = realtimeFrequency;
    }

    public Integer getEpoch() {
        return epoch;
    }

    public void setEpoch(Integer epoch) {
        this.epoch = epoch;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getUv() {
        return uv;
    }

    public void setUv(Double uv) {
        this.uv = uv;
    }

    public Integer getWinddir() {
        return winddir;
    }

    public void setWinddir(Integer winddir) {
        this.winddir = winddir;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getQcStatus() {
        return qcStatus;
    }

    public void setQcStatus(Integer qcStatus) {
        this.qcStatus = qcStatus;
    }

    public StationObservationMetricElements getMetric() {
        return metric;
    }

    public void setMetric(StationObservationMetricElements metric) {
        this.metric = metric;
    }
}
