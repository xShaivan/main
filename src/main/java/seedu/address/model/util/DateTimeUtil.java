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
            .withResolverStyle(ResolverStyle.STRICT);

    public static final String DATE_CONSTRAINTS = "Dates should be of the format DD-MM-YYYY";
    public static final String DATE_VALUE_EXCEEDED = "Only dates falling on the year 1900 or later are allowed.\n"
            + "Please also check that your date is a valid date.";
    public static final String DATE_VALIDATION_REGEX = "[0-9]{2}" + "[-]" + "[0-9]{2}" + "[-]" + "[0-9]{4}";

    public static final String DATE_TIME_CONSTRAINTS =
            "Date and Time should be of the format: " + "DD-MM-YYYY HH:MM";
    public static final String DATE_TIME_VALUE_EXCEEDED = "Only dates falling on the year 1900 or later are allowed.\n"
            + "Please also check that your date is a valid date and that your time is a valid time.";
    public static final String DATE_TIME_VALIDATION_REGEX =
            "[0-9]{2}" + "[-]" + "[0-9]{2}" + "[-]" + "[0-9]{4}" + "[ ]" + "[0-9]{2}" + "[:]" + "[0-9]{2}";

    public static LocalDate earliestDateAllowed = parseDate("01-01-1900");

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
