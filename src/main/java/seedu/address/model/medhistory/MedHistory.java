package seedu.address.model.medhistory;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

/**
 * Model of medical history of a patient.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */

public class MedHistory {

    // Data fields
    private final Date date;
    private final Allergy allergy;
    private final PrevCountry prevCountry;

    public MedHistory(Date date, Allergy allergy, PrevCountry prevCountry) {
        requireAllNonNull(date, allergy, prevCountry);
        this.date = date;
        this.allergy = allergy;
        this.prevCountry = prevCountry;
    }

    public Date getDate() {
        return date;
    }
    public Allergy getAllergy() {
        return allergy;
    }
    public PrevCountry getPrevCountry() {
        return prevCountry;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof MedHistory)) {
            return false;
        }

        MedHistory otherPerson = (MedHistory) other;
        return otherPerson.getDate().equals(getDate())
                && otherPerson.getAllergy().equals(getAllergy())
                && otherPerson.getPrevCountry().equals(getPrevCountry());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(date, allergy, prevCountry);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getDate())
                .append(" Phone: ")
                .append(getAllergy())
                .append(" Email: ")
                .append(getPrevCountry());
        return builder.toString();
    }
}
