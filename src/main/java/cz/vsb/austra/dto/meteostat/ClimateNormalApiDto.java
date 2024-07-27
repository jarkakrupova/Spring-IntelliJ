package cz.vsb.austra.dto.meteostat;

import java.util.ArrayList;

public class ClimateNormalApiDto {
    private Meta meta;
    private ArrayList<Datum> data;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public ArrayList<Datum> getData() {
        return data;
    }

    public void setData(ArrayList<Datum> data) {
        this.data = data;
    }
}

