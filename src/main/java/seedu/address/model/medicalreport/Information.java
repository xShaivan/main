package seedu.address.model.medicalreport;

import static java.util.Objects.requireNonNull;

//@@author chewkahmeng
/**
 * Represents a Medical Report's information in the address book.
 */
public class Information {
    public static final String MESSAGE_INFORMATION_CONSTRAINTS =
            "Information in medical report can take any values, and it should not be blank";

    public static final String INFORMATION_VALIDATION_REGEX = "[^\\s+].*";

    public final String fullInformation;

    /**
     * Constructs a {@code MedicalReportInformation}.
     *
     * @param information A valid information.
     */
    public Information(String information) {
        requireNonNull(information);
        fullInformation = information;
    }

    /**
     * Returns true if a given string contains valid information.
     */
    public static boolean isValidInformation(String test) {
        return test.matches(INFORMATION_VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return fullInformation;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Information // instanceof handles nulls
                && fullInformation.equals(((Information) other).fullInformation)); // state check
    }

    @Override
    public int hashCode() {
        return fullInformation.hashCode();
    }

    public boolean isFull() {
        return true;
    }
}
