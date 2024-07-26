package cz.vsb.austra.dto;
//pro data z SunriseSunsetApi.io
public class SunriseSunsetApiDto {
    private Results results;
    private String status;

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

