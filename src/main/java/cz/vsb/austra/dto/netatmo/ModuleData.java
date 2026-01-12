package cz.vsb.austra.dto.netatmo;

import java.util.List;
import java.util.Map;

public class ModuleData {
    private Map<String, List<Double>> res;
    private List<String> type;
    private Double rain_60min;
    private Double rain_24h;
    private Double rain_live;
    private Long rain_timeutc;
    private Double wind_strength;
    private Double wind_angle;
    private Double gust_strength;
    private Double gust_angle;
    private Long wind_timeutc;

    // Gettery a settery
    public Map<String, List<Double>> getRes() { return res; }
    public void setRes(Map<String, List<Double>> res) { this.res = res; }
    public List<String> getType() { return type; }
    public void setType(List<String> type) { this.type = type; }
    public Double getRain_60min() { return rain_60min; }
    public void setRain_60min(Double rain_60min) { this.rain_60min = rain_60min; }
    public Double getRain_24h() { return rain_24h; }
    public void setRain_24h(Double rain_24h) { this.rain_24h = rain_24h; }
    public Double getRain_live() { return rain_live; }
    public void setRain_live(Double rain_live) { this.rain_live = rain_live; }
    public Long getRain_timeutc() { return rain_timeutc; }
    public void setRain_timeutc(Long rain_timeutc) { this.rain_timeutc = rain_timeutc; }
    public Double getWind_strength() { return wind_strength; }
    public void setWind_strength(Double wind_strength) { this.wind_strength = wind_strength; }
    public Double getWind_angle() { return wind_angle; }
    public void setWind_angle(Double wind_angle) { this.wind_angle = wind_angle; }
    public Double getGust_strength() { return gust_strength; }
    public void setGust_strength(Double gust_strength) { this.gust_strength = gust_strength; }
    public Double getGust_angle() { return gust_angle; }
    public void setGust_angle(Double gust_angle) { this.gust_angle = gust_angle; }
    public Long getWind_timeutc() { return wind_timeutc; }
    public void setWind_timeutc(Long wind_timeutc) { this.wind_timeutc = wind_timeutc; }
}

