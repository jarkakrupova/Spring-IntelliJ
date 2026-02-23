package cz.vsb.austra.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class UnitConverterService {
    /**
     * Converts Unix timestamp to date and time formatted to standard Czech format (d.M.yyyy H:mm)
     * @param timestamp Unix timestamp
     * @return fomatted time
     */
    public static String convertTimestampToDate(long timestamp) {
        // Vytvoření objektu Instant z časového razítka
        Instant instant = Instant.ofEpochSecond(timestamp);

        // Konverze na LocalDateTime s použitím časové zóny
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

        // Formátování data
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy H:mm");
        return dateTime.format(formatter);
    }

    public static double convertKelvinToCelsius(double tempCelsius){
        return tempCelsius-273.15;
    }

    /**
     * Converts string ISO date (without timezone!) to Czech format (d.M.yyyy H:mm)
     * If there is a timezone indicator in the ISO date, you need to get substring (0,19).
     * @param isoDate string date in ISO format without timezone
     * @return date formatted for Czech standard
     */
    //iso format data:2026-02-22T15:30:00Z
    public static String convertIsoToCustomFormat(String isoDate) {
        // Vytvoření DateTimeFormatter pro ISO datum
        DateTimeFormatter isoFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        // Parsování ISO data na LocalDateTime
        LocalDateTime dateTime = LocalDateTime.parse(isoDate, isoFormatter);

        // Vytvoření DateTimeFormatter pro požadovaný formát
        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("d.M.yyyy H:mm");

        // Formátování data na požadovaný formát
        return dateTime.format(customFormatter);
    }

    public static String convertSecondsToTime(double seconds){
// Vytvoření objektu Instant z počtu sekund
        Instant instant = Instant.ofEpochSecond((long)seconds);

        // Konverze na LocalDateTime s použitím systémové časové zóny
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

        // Formátování data
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm:ss");
        return dateTime.format(formatter);
    }
}
