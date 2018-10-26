package seedu.address.model.person.addinfo;

import static java.util.Objects.requireNonNull;

import java.text.ParseException;
import java.time.LocalDate;

import seedu.address.model.util.DateTimeUtil;

/**
 * Represents ReportDate of Birth in Health Book
 */
public class DateOfBirth {
    public static final String DATE_OF_BIRTH_CONSTRAINTS = "Date of birth should be of the format dd-MM-yyyy";
    public static final String DATE_OF_BIRTH_VALUE_EXCEEDED = "Date values have exceeded. Please check again.";
    public static final String DATE_OF_BIRTH_VALIDATION_REGEX = "[0-9]{2}" + "[-]" + "[0-9]{2}" + "[-]" + "[0-9]{4}";

    public final LocalDate value;

    /**
     * Constructs a {@code DateOfBirth}
     * @param value a valid date
     * @throws ParseException if date format is invalid
     */
    //TODO: (DateOfBirth) to be an Optional type to support null values
    public DateOfBirth(String value) {
        requireNonNull(value);
        this.value = DateTimeUtil.parseDate(value);
    }

    public static boolean isValidDate(String test) {
        return test.matches(DATE_OF_BIRTH_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return DateTimeUtil.format(value);
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof DateOfBirth
                && value.equals(((DateOfBirth) other).value));
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
