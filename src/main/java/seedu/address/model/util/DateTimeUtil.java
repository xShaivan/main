package seedu.address.model.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Helper functions for LocalDate and LocalDateTime conversion to and from String
 */
public class DateTimeUtil {
    private static final String DATE_PATTERN = "dd-MM-yyyy";
    private static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);
    private static final String DATETIME_PATTERN = "dd-MM-yyyy HH:mm";
    private static DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern(DATETIME_PATTERN);

    // convert LocalDate to String
    public static String format(LocalDate date) {
        if (date == null) {
            return null;
        }
        return DATE_FORMATTER.format(date);
    }

    // convert LocalDateTime to String
    public static String format(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return DATETIME_FORMATTER.format(dateTime);
    }

    // convert String to LocalDate
    public static LocalDate parseDate(String dateString) {
        return LocalDate.parse(dateString, DATE_FORMATTER);
    }

    // convert String to LocalDateTime
    public static LocalDateTime parseDateTime(String dateTimeString) {
        return LocalDateTime.parse(dateTimeString, DATETIME_FORMATTER);
    }
}
