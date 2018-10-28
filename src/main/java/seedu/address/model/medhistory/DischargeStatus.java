package seedu.address.model.medhistory;

import static java.util.Objects.requireNonNull;

/**
 * Represents the discharge status of medical history.
 * Guarantees: immutable; is valid as declared in {@link #isValidDischargeStatus(String)}
 */
public class DischargeStatus {

    public static final String MESSAGE_DISCHARGE_STATUS_CONSTRAINTS =
            "Discharge status must not be left blank.";

    public static final String DISCHARGE_STATUS_VALIDATION_REGEX = "[^\\s].*";

    public String value;
    public DischargeStatusEnum dischargeStatusEnum;

    /**
     * Constructs an {@code DischargeStatus}.
     *
     * @param dischargeStatus A valid discharge status.
     */
    public DischargeStatus(String dischargeStatus) {
        requireNonNull(dischargeStatus);
        value = dischargeStatus;
    }

    public DischargeStatus(DischargeStatusEnum dischargeStatusEnum) {
        requireNonNull(dischargeStatusEnum);
        this.dischargeStatusEnum = dischargeStatusEnum;
    }

    public void DischargeStatusSwitch() {
        switch (dischargeStatusEnum) {
            case discharged:
                value = "Discharged to home";
                break;
            case admitted:
                value = "Admitted as an inpatient to this hospital";
                break;
            case expired:
                value = "Patient has expired.";
                break;
                default:
                    value = "";
        }
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DischargeStatus // instanceof handles nulls
                && value.equals(((DischargeStatus) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
