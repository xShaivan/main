package seedu.address.model.medhistory;

import static java.util.Objects.requireNonNull;
//import static seedu.address.commons.util.AppUtil.checkArgument;

import java.time.LocalDate;

import seedu.address.model.util.DateTimeUtil;

/**
 * Represents the date of medical history.
 * Guarantees: immutable; is valid as declared in {@link #isValidDate(String)}
 */

public class MedHistDate {

    public static final String MESSAGE_MEDHISTDATE_CONSTRAINTS =
            "ReportDate needs to be in day-month-year (dd-mm-yyyy) format.";

    public static final String MEDHISTDATE_VALIDATION_REGEX = "[0-9]{2}" + "[-]" + "[0-9]{2}" + "[-]" + "[0-9]{4}";

    public final LocalDate value;

    /**
     * Constructs an {@code MedHistDate}.
     *
     * @param medHistDate A valid date.
     */
    public MedHistDate(String medHistDate) {
        requireNonNull(medHistDate);
        // isValidDate will is found in test file.
        //checkArgument(isValidDate(date), MESSAGE_DATE_CONSTRAINTS);
        value = DateTimeUtil.parseDate(medHistDate);
    }

    @Override
    public String toString() {
        return DateTimeUtil.format(value);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof MedHistDate // instanceof handles nulls
                && value.equals(((MedHistDate) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
