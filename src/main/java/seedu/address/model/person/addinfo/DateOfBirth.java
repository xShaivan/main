package seedu.address.model.person.addinfo;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.util.DateTimeUtil.DATE_VALIDATION_REGEX;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Optional;

import seedu.address.model.util.DateTimeUtil;

/**
 * Represents ReportDate of Birth in Health Book
 */
public class DateOfBirth {
    public final Optional<LocalDate> value;

    private final String emptyString = "";

    /**
     * Constructs a {@code DateOfBirth}
     * @param value a valid date
     * @throws ParseException if date format is invalid
     */
    //TODO: (DateOfBirth) to be an Optional type to support null values
    public DateOfBirth(String value) {
        requireNonNull(value);
        this.value = (value.isEmpty()) ? Optional.empty() : Optional.of(DateTimeUtil.parseDate(value));
    }

    public static boolean isValidDate(String test) {
        return test.matches(DATE_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value.isPresent() ? DateTimeUtil.format(value.get()) : emptyString;
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
