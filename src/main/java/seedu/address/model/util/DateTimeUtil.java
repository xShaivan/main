package seedu.address.model.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

/**
 * Helper functions for LocalDate and LocalDateTime conversion to and from String
 */
public class DateTimeUtil {
    private static final String DATE_PATTERN = "dd-MM-uuuu";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN)
            .withResolverStyle(ResolverStyle.STRICT);
    private static final String DATETIME_PATTERN = "dd-MM-uuuu HH:mm";
    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern(DATETIME_PATTERN)
            .withResolverStyle(ResolverStyle.STRICT);;

    /**
     * convert LocalDate to String
     */
    public static String format(LocalDate date) {
        if (date == null) {
            return null;
        }
        return DATE_FORMATTER.format(date);
    }

    /**
     * convert LocalDateTime to String
     */
    public static String format(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return DATETIME_FORMATTER.format(dateTime);
    }

    /**
     * convert String to LocalDate
     *
     * @param dateString String to be converted
     * @return parsed local-date, not null
     * @throws DateTimeParseException if String cannot be parsed
     */
    public static LocalDate parseDate(String dateString) throws DateTimeParseException {
        return LocalDate.parse(dateString, DATE_FORMATTER);
    }

    /**
     * convert String to LocalDateTime
     *
     * @param dateTimeString String to be converted
     * @return parsed local-date-time, not null
     * @throws DateTimeParseException if String cannot be parsed
     */
    public static LocalDateTime parseDateTime(String dateTimeString) throws DateTimeParseException {
        return LocalDateTime.parse(dateTimeString, DATETIME_FORMATTER);
    }
}
