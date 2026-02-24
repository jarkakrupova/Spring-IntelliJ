package cz.vsb.austra.dto;

public class TomorrowioMinMaxPrecipSnowDto extends MinMaxPrecipSnowDto {
    private Integer precipitationProbability;

    public Integer getPrecipitationProbability() {
        return precipitationProbability;
    }

    public void setPrecipitationProbability(Integer precipitationProbability) {
        this.precipitationProbability = precipitationProbability;
    }
}
