package cz.vsb.austra.dto.weathercom;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
public class StationObservationMetricElements {
    private Double temp;
    private Integer heatIndex;
    private Integer dewpt;
    private Integer windChill;
    private Integer windSpeed;
    private Integer windGust;
    private Double pressure;
    private Double precipRate;
    private Double precipTotal;
    private Integer elev;

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Integer getHeatIndex() {
        return heatIndex;
    }

    public void setHeatIndex(Integer heatIndex) {
        this.heatIndex = heatIndex;
    }

    public Integer getDewpt() {
        return dewpt;
    }

    public void setDewpt(Integer dewpt) {
        this.dewpt = dewpt;
    }

    public Integer getWindChill() {
        return windChill;
    }

    public void setWindChill(Integer windChill) {
        this.windChill = windChill;
    }

    public Integer getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Integer windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Integer getWindGust() {
        return windGust;
    }

    public void setWindGust(Integer windGust) {
        this.windGust = windGust;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getPrecipRate() {
        return precipRate;
    }

    public void setPrecipRate(Double precipRate) {
        this.precipRate = precipRate;
    }

    public Double getPrecipTotal() {
        return precipTotal;
    }

    public void setPrecipTotal(Double precipTotal) {
        this.precipTotal = precipTotal;
    }

    public Integer getElev() {
        return elev;
    }

    public void setElev(Integer elev) {
        this.elev = elev;
    }
}
