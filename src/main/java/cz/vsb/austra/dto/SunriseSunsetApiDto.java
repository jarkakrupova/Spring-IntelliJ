package cz.vsb.austra.dto;
//pro data z SunriseSunsetApi.io
public class SunriseSunsetApiDto {
    private SunriseSunsetResults results;
    private String status;

    public SunriseSunsetResults getResults() {
        return results;
    }

    public void setResults(SunriseSunsetResults results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

