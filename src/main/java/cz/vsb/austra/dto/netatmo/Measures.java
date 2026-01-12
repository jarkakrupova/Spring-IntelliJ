package cz.vsb.austra.dto.netatmo;
import java.util.Map;

public class Measures {
    private Map<String, ModuleData> modules;

    // Gettery a settery
    public Map<String, ModuleData> getModules() { return modules; }
    public void setModules(Map<String, ModuleData> modules) { this.modules = modules; }
}

