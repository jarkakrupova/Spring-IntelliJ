package cz.vsb.austra.dto;

public class HourlyDto extends WeatherDto {
    //    private int chance_of_snow;
//    private int chance_of_rain;
    private double pressure_mb;
    private double snow_cm;
    private int cloud;
    private double feelslike_c;
    private String icon;

    public double getPressure_mb() {
        return pressure_mb;
    }

    public void setPressure_mb(double pressure_mb) {
        this.pressure_mb = pressure_mb;
    }

    public double getSnow_cm() {
        return snow_cm;
    }

    public void setSnow_cm(double snow_cm) {
        this.snow_cm = snow_cm;
    }

    public int getCloud() {
        return cloud;
    }

    public void setCloud(int cloud) {
        this.cloud = cloud;
    }

    public double getFeelslike_c() {
        return feelslike_c;
    }

    public void setFeelslike_c(double feelslike_c) {
        this.feelslike_c = feelslike_c;
    }
    public double getPrecip_mm() {
        return precip_mm;
    }

    public void setPrecip_mm(double precip_mm) {
        this.precip_mm = precip_mm;
    }

    private double precip_mm;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
