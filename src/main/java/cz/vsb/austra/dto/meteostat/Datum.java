package cz.vsb.austra.dto.meteostat;

public class Datum{
    private Integer month;
    private Double tavg;
    private Double tmin;
    private Double tmax;
    private Double prcp;
    private Double wspd;
    private Double pres;
    private Integer tsun;

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Double getTavg() {
        return tavg;
    }

    public void setTavg(Double tavg) {
        this.tavg = tavg;
    }

    public Double getTmin() {
        return tmin;
    }

    public void setTmin(Double tmin) {
        this.tmin = tmin;
    }

    public Double getTmax() {
        return tmax;
    }

    public void setTmax(Double tmax) {
        this.tmax = tmax;
    }

    public Double getPrcp() {
        return prcp;
    }

    public void setPrcp(Double prcp) {
        this.prcp = prcp;
    }

    public Double getWspd() {
        return wspd;
    }

    public void setWspd(Double wspd) {
        this.wspd = wspd;
    }

    public Double getPres() {
        return pres;
    }

    public void setPres(Double pres) {
        this.pres = pres;
    }

    public Integer getTsun() {
        return tsun;
    }

    public void setTsun(Integer tsun) {
        this.tsun = tsun;
    }
}
