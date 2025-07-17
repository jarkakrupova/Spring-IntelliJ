package cz.vsb.austra.dto.openweathermap;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class OpenWeatherMapApiCurrentDto {

    @JsonProperty("coord")
    public Coord getCoord() {
        return this.coord; }
    public void setCoord(Coord coord) {
        this.coord = coord; }
    Coord coord;
    @JsonProperty("weather")
    public ArrayList<Weather> getWeather() {
        return this.weather; }
    public void setWeather(ArrayList<Weather> weather) {
        this.weather = weather; }
    ArrayList<Weather> weather;
    @JsonProperty("base")
    public String getBase() {
        return this.base; }
    public void setBase(String base) {
        this.base = base; }
    String base;
    @JsonProperty("main")
    public Main getMain() {
        return this.main; }
    public void setMain(Main main) {
        this.main = main; }
    Main main;
    @JsonProperty("visibility")
    public int getVisibility() {
        return this.visibility; }
    public void setVisibility(int visibility) {
        this.visibility = visibility; }
    int visibility;
    @JsonProperty("wind")
    public Wind getWind() {
        return this.wind; }
    public void setWind(Wind wind) {
        this.wind = wind; }
    Wind wind;
    //zakomentovano, protoze to v datech z OpenWeatherMap neni, i kdyz vzorovy JSON rika, ze by to tam melo byt
//    @JsonProperty("rain")
//    public Rain getRain() {
//        return this.rain; }
//    public void setRain(Rain rain) {
//        this.rain = rain; }
//    Rain rain;
    @JsonProperty("clouds")
    public Clouds getClouds() {
        return this.clouds; }
    public void setClouds(Clouds clouds) {
        this.clouds = clouds; }
    Clouds clouds;
    @JsonProperty("dt")
    public Integer getDt() {
        return this.dt; }
    public void setDt(Integer dt) {
        this.dt = dt; }
    Integer dt;
    @JsonProperty("sys")
    public Sys getSys() {
        return this.sys; }
    public void setSys(Sys sys) {
        this.sys = sys; }
    Sys sys;
    @JsonProperty("timezone")
    public Integer getTimezone() {
        return this.timezone; }
    public void setTimezone(Integer timezone) {
        this.timezone = timezone; }
    Integer timezone;
    //moc nepouzivat, automaticke geokodovani je deprecated
    @JsonProperty("id")
    public Integer getId() {
        return this.id; }
    public void setId(Integer id) {
        this.id = id; }
    Integer id;
    //moc nepouzivat, automaticke geokodovani je deprecated
    @JsonProperty("name")
    public String getName() {
        return this.name; }
    public void setName(String name) {
        this.name = name; }
    String name;
    //interni parametr
    @JsonProperty("cod")
    public Integer getCod() {
        return this.cod; }
    public void setCod(Integer cod) {
        this.cod = cod; }
    Integer cod;
}

