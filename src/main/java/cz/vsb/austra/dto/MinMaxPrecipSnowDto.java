package cz.vsb.austra.dto;

/**
 * Output class for min, max, precipitation and snow data from WeatherAPi.com
 */
public class MinMaxPrecipSnowDto {
    private double max_temperature;
    private double min_temperature;
    private double avg_temperature;
    private double total_precip_mm;
    private double total_snow_cm;
    private int chance_of_rain;
    private int chance_of_snow;

    public double getMax_temperature() {
        return max_temperature;
    }

    public void setMax_temperature(double max_temperature) {
        this.max_temperature = max_temperature;
    }

    public double getMin_temperature() {
        return min_temperature;
    }

    public void setMin_temperature(double min_temperature) {
        this.min_temperature = min_temperature;
    }

    public double getAvg_temperature() {
        return avg_temperature;
    }

    public void setAvg_temperature(double avg_temperature) {
        this.avg_temperature = avg_temperature;
    }

    public double getTotal_precip_mm() {
        return total_precip_mm;
    }

    public void setTotal_precip_mm(double total_precip_mm) {
        this.total_precip_mm = total_precip_mm;
    }

    public double getTotal_snow_cm() {
        return total_snow_cm;
    }

    public void setTotal_snow_cm(double total_snow_cm) {
        this.total_snow_cm = total_snow_cm;
    }

    public int getChance_of_rain() {
        return chance_of_rain;
    }

    public void setChance_of_rain(int chance_of_rain) {
        this.chance_of_rain = chance_of_rain;
    }

    public int getChance_of_snow() {
        return chance_of_snow;
    }

    public void setChance_of_snow(int chance_of_snow) {
        this.chance_of_snow = chance_of_snow;
    }
}
