package cz.vsb.austra.connector;

import com.fasterxml.jackson.databind.ObjectMapper;
import cz.vsb.austra.dto.WmoWeatherCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

@Component
public class WmoWeatherConditionsConnector {
    WmoWeatherCondition[] conditions;

//    @Autowired
//    public WmoWeatherConditionsConnector(WmoWeatherCondition[] conditions) {
//        conditions = getWeatherConditions();
//    }

    private WmoWeatherCondition[] getWeatherConditions() {
        File jsonFile = new File("src/main/java/cz/vsb/austra/dto/VMO_weather_conditions.json");

        ObjectMapper objectMapper = new ObjectMapper();

        WmoWeatherCondition[] weatherConditions = null;
        try {
            // Deserializace JSON souboru do objektu
            weatherConditions = objectMapper.readValue(jsonFile, WmoWeatherCondition[].class);

            // Vypíše hodnoty objektu
            Arrays.stream(weatherConditions).forEach(weatherCondition -> {
                System.out.println("Code: " + weatherCondition.getCode());
                System.out.println("Description: " + weatherCondition.getDescription());
            });
        } catch (IOException e) {
            e.printStackTrace();
            e.printStackTrace();
        }
        return weatherConditions;
    }

    public String getWeatherCondition(int code) {
        var condition = Arrays.stream(getWeatherConditions()).filter(cond -> cond.getCode() == code).findFirst().orElseThrow(IllegalArgumentException::new);
        return condition.getDescription();
    }
}
