package seedu.address.model.util;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import org.junit.Test;

import seedu.address.testutil.Assert;

public class DateTimeUtilTest {
    public static final String INCORRECT_DATE = "01-01-1899";
    public static final String INVALID_DATE = "01/30/1970";

    public static final String INCORRECT_DATE_TIME = "01-01-1899 00:00";
    public static final String INVALID_DATE_TIME = "01-01-1970: 80:20";


    @Test
    public void parseNullLocalDateReturnNull() {
        assertEquals(DateTimeUtil.format((LocalDate) null), null);
    }

    @Test
    public void parseNullLocalDateTimeReturnNull() {
        assertEquals(DateTimeUtil.format((LocalDateTime) null), null);
    }

    @Test
    public void parseIncorrectDateThrowsDateTimeParseException() {
        Assert.assertThrows(DateTimeParseException.class, () -> DateTimeUtil.isCorrectDate(INCORRECT_DATE) );
    }

    @Test
    public void parseIncorrectDareTimeThrowsDateTimeParseException() {
        Assert.assertThrows(DateTimeParseException.class, () -> DateTimeUtil.isCorrectDateTime(INCORRECT_DATE_TIME));
    }

    @Test
    public void parseInvalidDateThrowsDateTimeParseException() {
        Assert.assertThrows(DateTimeParseException.class, () -> DateTimeUtil.isCorrectDate(INVALID_DATE));
    }

    @Test
    public void parseInvalidDateTimeThrowsDateTimeParseException() {
        Assert.assertThrows(DateTimeParseException.class, () -> DateTimeUtil.isCorrectDateTime(INVALID_DATE_TIME));
    }

}