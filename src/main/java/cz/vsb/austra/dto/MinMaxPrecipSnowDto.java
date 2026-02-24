package cz.vsb.austra.dto;

/**
 * Output class for min, max, precipitation and snow data from WeatherAPi.com
 */
public class MinMaxPrecipSnowDto {
    private Double max_temperature;
    private Double min_temperature;
    private Double avg_temperature;
    private Double total_precip_mm;
    private Double total_snow_cm;


    public Double getMax_temperature() {
        return max_temperature;
    }

    public void setMax_temperature(Double max_temperature) {
        this.max_temperature = max_temperature;
    }

    public Double getMin_temperature() {
        return min_temperature;
    }

    public void setMin_temperature(Double min_temperature) {
        this.min_temperature = min_temperature;
    }

    public Double getAvg_temperature() {
        return avg_temperature;
    }

    public void setAvg_temperature(Double avg_temperature) {
        this.avg_temperature = avg_temperature;
    }

    public Double getTotal_precip_mm() {
        return total_precip_mm;
    }

    public void setTotal_precip_mm(Double total_precip_mm) {
        this.total_precip_mm = total_precip_mm;
    }

    public Double getTotal_snow_cm() {
        return total_snow_cm;
    }

    public void setTotal_snow_cm(Double total_snow_cm) {
        this.total_snow_cm = total_snow_cm;
    }


}
