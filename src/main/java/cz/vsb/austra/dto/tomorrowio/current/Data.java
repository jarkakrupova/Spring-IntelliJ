package cz.vsb.austra.dto.tomorrowio.current;

import java.time.LocalDateTime;

public class Data{
        private LocalDateTime time;
        private cz.vsb.austra.dto.tomorrowio.current.Values values;

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public cz.vsb.austra.dto.tomorrowio.current.Values getValues() {
        return values;
    }

    public void setValues(cz.vsb.austra.dto.tomorrowio.current.Values values) {
        this.values = values;
    }
}
