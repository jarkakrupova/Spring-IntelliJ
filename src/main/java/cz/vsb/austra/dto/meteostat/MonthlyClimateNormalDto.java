package cz.vsb.austra.dto.meteostat;

import java.util.ArrayList;

public class MonthlyClimateNormalDto {
    private ArrayList <MonthlyNormalDto> monthlyNormals = new ArrayList<>();

    public ArrayList<MonthlyNormalDto> getMonthlyNormals() {
        return monthlyNormals;
    }

    public void setMonthlyNormals(ArrayList<MonthlyNormalDto> monthlyNormals) {
        this.monthlyNormals = monthlyNormals;
    }
}
