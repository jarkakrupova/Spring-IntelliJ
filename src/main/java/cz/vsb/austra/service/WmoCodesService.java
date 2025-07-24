package cz.vsb.austra.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import cz.vsb.austra.connector.WmoWeatherConditionsConnector;
import cz.vsb.austra.dto.WmoWeatherCondition;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@Service
public class WmoCodesService {
    WmoWeatherConditionsConnector connector;
    public WmoCodesService(WmoWeatherConditionsConnector connector) {
        this.connector = connector;
    }

    public String getWeatherCondition(int code){
        return connector.getWeatherCondition(code);
    }
}
