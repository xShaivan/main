package seedu.address.model.medhistory;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents the date of medical history.
 * Guarantees: immutable; is valid as declared in {@link #isValidDate(String)}
 */

public class Date {

    public static final String MESSAGE_DATE_CONSTRAINTS =
            "Date needs to be in day/month/year (dd/mm/yyyy) format.";

    public static final String DATE_VALIDATION_REGEX = "[^\\s].*";

    public final String value;

    /**
     * Constructs an {@code Date}.
     *
     * @param date A valid date.
     */
    public Date(String date) {
        requireNonNull(date);
        // isValidDate will is found in test file.
        checkArgument(isValidDate(date), MESSAGE_DATE_CONSTRAINTS);
        value = date;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Date // instanceof handles nulls
                && value.equals(((Date) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
