package cz.vsb.austra.dto;

import java.util.ArrayList;

public class Forecastday {
    public String date;
    public int date_epoch;
    public Day day;
    public Astro astro;
    public ArrayList<Hour> hour;
}
