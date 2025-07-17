package cz.vsb.austra.dto.openweathermap;

import com.fasterxml.jackson.annotation.JsonProperty;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
public class Clouds{
    @JsonProperty("all")
    public int getAll() {
        return this.all; }
    public void setAll(int all) {
        this.all = all; }
    int all;
}
