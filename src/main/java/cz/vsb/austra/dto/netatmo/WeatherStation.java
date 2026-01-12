package cz.vsb.austra.dto.netatmo;

import java.util.List;
import java.util.Map;

public class WeatherStation {
    private String _id;
    private Place place;
    private int mark;
    private Measures measures;
    private List<String> modules;
    private Map<String, String> module_types;

    // Gettery a settery
    public String get_id() { return _id; }
    public void set_id(String _id) { this._id = _id; }
    public Place getPlace() { return place; }
    public void setPlace(Place place) { this.place = place; }
    public int getMark() { return mark; }
    public void setMark(int mark) { this.mark = mark; }
    public Measures getMeasures() { return measures; }
    public void setMeasures(Measures measures) { this.measures = measures; }
    public List<String> getModules() { return modules; }
    public void setModules(List<String> modules) { this.modules = modules; }
    public Map<String, String> getModule_types() { return module_types; }
    public void setModule_types(Map<String, String> module_types) { this.module_types = module_types; }
}

