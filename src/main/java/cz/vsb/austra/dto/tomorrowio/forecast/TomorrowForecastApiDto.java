package cz.vsb.austra.dto.tomorrowio.forecast;

import cz.vsb.austra.dto.tomorrowio.Location;
import cz.vsb.austra.dto.tomorrowio.Timelines;

/**
 * Input class for forecast data from Tomorrow.io
 */

public class TomorrowForecastApiDto {
    private Timelines timelines;
    private Location location;

    public Timelines getTimelines() {
        return timelines;
    }

    public void setTimelines(Timelines timelines) {
        this.timelines = timelines;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}