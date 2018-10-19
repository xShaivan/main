package seedu.address.model.medhistory;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;
import java.util.Optional;

import seedu.address.commons.util.CollectionUtil;

/**
 * Model of medical history of a patient.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */


public class MedHistory {
    private MedHistDate medHistDate;
    private Allergy allergy;
    private PrevCountry prevCountry;

    public MedHistory() {}

    public MedHistory(MedHistDate medHistDate, Allergy allergy, PrevCountry prevCountry) {
        requireAllNonNull(medHistDate, allergy, prevCountry);
        this.medHistDate = medHistDate;
        this.allergy = allergy;
        this.prevCountry = prevCountry;
    }

    /**
     * Copy constructor.
     * A defensive copy of {@code tags} is used internally.
     */
    public MedHistory(MedHistory toCopy) {
        setMedHistDate(toCopy.medHistDate);
        setAllergy(toCopy.allergy);
        setPrevCountry(toCopy.prevCountry);
    }

    /**
     * Returns true if at least one field is edited.
     */
    public boolean isAnyFieldEdited() {
        return CollectionUtil.isAnyNonNull(medHistDate, allergy, prevCountry);
    }

    public void setMedHistDate(MedHistDate medHistDate) {
        this.medHistDate = medHistDate;
    }

    public Optional<MedHistDate> getMedHistDate() {
        return Optional.ofNullable(medHistDate);
    }

    public void setAllergy(Allergy allergy) {
        this.allergy = allergy;
    }

    public Optional<Allergy> getAllergy() {
        return Optional.ofNullable(allergy);
    }

    public void setPrevCountry(PrevCountry prevCountry) {
        this.prevCountry = prevCountry;
    }

    public Optional<PrevCountry> getPrevCountry() {
        return Optional.ofNullable(prevCountry);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof MedHistory)) {
            return false;
        }

        // state check
        MedHistory e = (MedHistory) other;

        return getMedHistDate().equals(e.getMedHistDate())
                && getAllergy().equals(e.getAllergy())
                && getPrevCountry().equals(e.getPrevCountry());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(medHistDate, allergy, prevCountry);
    }

    @Override
    public String toString() {
        return medHistDate.toString() + " \n" + allergy.toString() + " \n" + prevCountry.toString();
    }
}