package seedu.address.model.appt;

import static java.util.Objects.requireNonNull;

//@@author brandonccm1996
/**
 * Represents an appt venue in an appt in the address book.
 * Guarantees: immutable; is always valid
 */
public class ApptVenue {
    public static final String MESSAGE_NAME_CONSTRAINTS =
            "Appt venues can take any values, and it should not be blank.";

    public static final String VENUE_VALIDATION_REGEX = "[^\\s].*";
    public final String value;

    public ApptVenue(String apptVenue) {
        requireNonNull(apptVenue);
        value = apptVenue;
    }

    public static boolean isValidVenue(String test) {
        return test.matches(VENUE_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ApptVenue // instanceof handles nulls
                && value.equals(((ApptVenue) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
