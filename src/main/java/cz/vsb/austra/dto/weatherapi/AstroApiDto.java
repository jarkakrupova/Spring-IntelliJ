package cz.vsb.austra.dto.weatherapi;

import cz.vsb.austra.dto.Astronomy;

public class AstroApiDto {
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Astronomy getAstronomy() {
        return astronomy;
    }

    public void setAstronomy(Astronomy astronomy) {
        this.astronomy = astronomy;
    }

    private Location location;
private Astronomy astronomy;
}
