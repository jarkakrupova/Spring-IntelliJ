package cz.vsb.austra.dto;

public class WmoWeatherCondition {

    private int code;
    private String description;

    // Gettery a settery
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
