package cz.vsb.austra.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class UnitConverterService {
    public static String convertTimestampToDate(long timestamp) {
        // Vytvoření objektu Instant z časového razítka
        Instant instant = Instant.ofEpochSecond(timestamp);

        // Konverze na LocalDateTime s použitím časové zóny
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

        // Formátování data
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTime.format(formatter);
    }

    public static double convertKelvinToCelsius(double tempCelsius){
        return tempCelsius-273.15;
    }
}
