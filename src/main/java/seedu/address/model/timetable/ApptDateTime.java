package seedu.address.model.timetable;

import static java.util.Objects.requireNonNull;

import java.time.LocalDateTime;

import seedu.address.model.util.DateTimeUtil;

//@@author brandonccm1996
/**
 * Represents an appt date and time in an appt in the address book.
 * Guarantees: immutable; is always valid
 */
public class ApptDateTime {
    public static final String MESSAGE_NAME_CONSTRAINTS =
            "The start and end Appt Date and Time should be of the format: " + "DD-MM-YYYY HH:MM";
    public static final String APPT_DATETIME_VALIDATION_REGEX =
            "[0-9]{2}" + "[-]" + "[0-9]{2}" + "[-]" + "[0-9]{4}" + "[ ]" + "[0-9]{2}" + "[:]" + "[0-9]{2}";

    public final LocalDateTime value;

    public ApptDateTime(String apptDateTime) {
        requireNonNull(apptDateTime);
        value = DateTimeUtil.parseDateTime(apptDateTime);
    }

    public static boolean isValidDateTime(String test) {
        return test.matches(APPT_DATETIME_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return DateTimeUtil.format(value);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ApptDateTime // instanceof handles nulls
                && value.equals(((ApptDateTime) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
