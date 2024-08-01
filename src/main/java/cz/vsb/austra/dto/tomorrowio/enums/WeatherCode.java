package cz.vsb.austra.dto.tomorrowio.enums;

public enum WeatherCode {
    UNKNOWN(0),
    CLEAR_AND_SUNNY(1000),
    MOSTLY_CLEAR(1100),
    PARTLY_CLOUDY(1101),
    MOSTLY_CLOUDY(1102),
    CLOUDY(1001),
    FOG(2000),
    LIGHT_FOG(2100),
    DRIZZLE(4000),
    RAIN(4001),
    LIGHT_RAIN(4200),
    HEAVY_RAIN(4201),
    SNOW(5000),
    FLURRIES(5001),
    LIGHT_SNOW(5100),
    HEAVY_SNOW(5101),
    FREEZING_DRIZZLE(6000),
    FREEZING_RAIN(6001),
    LIGHT_FREEZING_RAIN(6200),
    HEAVY_FREEZING_RAIN(6201),
    ICE_PELLETS(7000),
    LIGHT_ICE_PELLETS(7101),
    HEAVY_ICE_PELLETS(7102),
    THUNDERSTORM(8000)
    ;


    public final Integer weatherCode;

private WeatherCode(Integer weatherCode){
    this.weatherCode =weatherCode;
}
//    private WeatherCode(String weatherCode){
//    this.weatherCode =weatherCode;
//}

    public static WeatherCode valueOfLabel(Integer label) {
        for (WeatherCode weatherCode : values()) {
            if (weatherCode.weatherCode.equals(label)) {
                return weatherCode;
            }
        }
        return null;
    }
}
