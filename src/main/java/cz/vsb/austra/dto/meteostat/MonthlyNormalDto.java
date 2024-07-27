package cz.vsb.austra.dto.meteostat;

import java.time.Month;

public class MonthlyNormalDto {
    private Integer month;
    private Double averageDailyTemperature;
    private Double averageMinimalDailyTemperature;
    private Double averageMaximumDailyTemperature;
    private Double monthlyPrecipitationTotalInMm;
    private Double averageWindSpeedKmH;
    private Double averageAirPressureSeaLevelHpa;
    private Integer averageSunshineMinutes;
    private String monthInWords;

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Double getAverageDailyTemperature() {
        return averageDailyTemperature;
    }

    public void setAverageDailyTemperature(Double averageDailyTemperature) {
        this.averageDailyTemperature = averageDailyTemperature;
    }

    public Double getAverageMinimalDailyTemperature() {
        return averageMinimalDailyTemperature;
    }

    public void setAverageMinimalDailyTemperature(Double averageMinimalDailyTemperature) {
        this.averageMinimalDailyTemperature = averageMinimalDailyTemperature;
    }

    public Double getAverageMaximumDailyTemperature() {
        return averageMaximumDailyTemperature;
    }

    public void setAverageMaximumDailyTemperature(Double averageMaximumDailyTemperature) {
        this.averageMaximumDailyTemperature = averageMaximumDailyTemperature;
    }

    public Double getMonthlyPrecipitationTotalInMm() {
        return monthlyPrecipitationTotalInMm;
    }

    public void setMonthlyPrecipitationTotalInMm(Double monthlyPrecipitationTotalInMm) {
        this.monthlyPrecipitationTotalInMm = monthlyPrecipitationTotalInMm;
    }

    public Double getAverageWindSpeedKmH() {
        return averageWindSpeedKmH;
    }

    public void setAverageWindSpeedKmH(Double averageWindSpeedKmH) {
        this.averageWindSpeedKmH = averageWindSpeedKmH;
    }

    public Double getAverageAirPressureSeaLevelHpa() {
        return averageAirPressureSeaLevelHpa;
    }

    public void setAverageAirPressureSeaLevelHpa(Double averageAirPressureSeaLevelHpa) {
        this.averageAirPressureSeaLevelHpa = averageAirPressureSeaLevelHpa;
    }

    public Integer getAverageSunshineMinutes() {
        return averageSunshineMinutes;
    }

    public void setAverageSunshineMinutes(Integer averageSunshineMinutes) {
        this.averageSunshineMinutes = averageSunshineMinutes;
    }

    public String getMonthInWords() {
        return monthInWords;
    }

    public void setMonthInWords(String monthInWords) {
        this.monthInWords = Month.of(month).toString();
    }
}
