package cz.vsb.austra.dto;

public class WeatherApiMinMaxPrecipSnowDto extends MinMaxPrecipSnowDto {
    private Integer chance_of_rain;
    private int chance_of_snow;
    public Integer getChance_of_rain() {
        return chance_of_rain;
    }

    public void setChance_of_rain(Integer chance_of_rain) {
        this.chance_of_rain = chance_of_rain;
    }

    public Integer getChance_of_snow() {
        return chance_of_snow;
    }

    public void setChance_of_snow(int chance_of_snow) {
        this.chance_of_snow = chance_of_snow;
    }
}
