package cz.vsb.austra.dto.tomorrowio.current;

import cz.vsb.austra.dto.tomorrowio.Location;

public class TomorrowCurrentWeatherApiDto {
        private Data data;
        private Location location;

        public Data getData() {
                return data;
        }

        public void setData(Data data) {
                this.data = data;
        }

        public Location getLocation() {
                return location;
        }

        public void setLocation(Location location) {
                this.location = location;
        }
}
