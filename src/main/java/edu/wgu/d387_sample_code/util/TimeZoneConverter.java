package edu.wgu.d387_sample_code.util;


import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public class TimeZoneConverter {
    private final ZoneId zoneIdEST = ZoneId.of("America/New_York");
    private final ZoneId zoneIdMT = ZoneId.of("America/Denver");
    private final ZoneId zoneIdUTC = ZoneId.of("Etc/GMT");
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm");


    public String getEST(LocalDateTime utcDateTime) {
        ZonedDateTime zonedDateTime = utcDateTime.atZone(zoneIdUTC);
        ZonedDateTime zonedDateTimeEST = zonedDateTime.withZoneSameInstant(zoneIdEST);
        LocalDateTime dateTimeEST = zonedDateTimeEST.toLocalDateTime();
        return "ET: " + dateTimeEST.format(formatter);
    }

    public String getMT(LocalDateTime utcDateTime) {
        ZonedDateTime zonedDateTime = utcDateTime.atZone(zoneIdUTC);
        ZonedDateTime zonedDateTimeMT = zonedDateTime.withZoneSameInstant(zoneIdMT);
        LocalDateTime dateTimeMT = zonedDateTimeMT.toLocalDateTime();
        return "MT: " + dateTimeMT.format(formatter);
    }

    public String getUTC(LocalDateTime utcDateTime) {
        return "UTC: " + utcDateTime.format(formatter);

    }

}
