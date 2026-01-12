package cz.vsb.austra.dto.netatmo;

import cz.vsb.austra.dto.netatmo.WeatherStation;

import java.util.List;

public class ApiResponse {
    private String status;
    private long time_server;
    private List<WeatherStation> body;

    // Gettery a settery
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public long getTime_server() { return time_server; }
    public void setTime_server(long time_server) { this.time_server = time_server; }
    public List<WeatherStation> getBody() { return body; }
    public void setBody(List<WeatherStation> body) { this.body = body; }
}
