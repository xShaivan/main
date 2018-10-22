package seedu.address.model.medicalreport;

import static java.util.Objects.requireNonNull;

import java.time.LocalDate;
import seedu.address.model.util.DateTimeUtil;

/**
 * Represents a Medical Report's date in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidDate(String)}
 */
public class ReportDate {

    public static final String MESSAGE_DATE_CONSTRAINTS =
            "The full ReportDate should be of the format: DD-MM-YYYY";
    public static final String REPORT_DATE_VALIDATION_REGEX =
            "[0-9]{2}" + "[-]" + "[0-9]{2}" + "[-]" + "[0-9]{4}" + "[ ]" + "[0-9]{2}" + "[:]" + "[0-9]{2}";

    public final LocalDate fullDate;

    /**
     * Constructs a {@code ReportDate}.
     *
     * @param date A valid date.
     */
    public ReportDate(String date) {
        requireNonNull(date);
        fullDate = DateTimeUtil.parseDate(date);
    }

    /**
     * Returns true if a given string is a valid date.
     */
    public static boolean isValidDate(String test) {
        return test.matches(REPORT_DATE_VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return DateTimeUtil.format(fullDate);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ReportDate // instanceof handles nulls
                && fullDate.equals(((ReportDate) other).fullDate)); // state check
    }

    @Override
    public int hashCode() {
        return fullDate.hashCode();
    }
}
