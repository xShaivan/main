package seedu.address.storage;

import java.util.Objects;

import javax.xml.bind.annotation.XmlElement;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.medhistory.Allergy;
import seedu.address.model.medhistory.DischargeStatus;
import seedu.address.model.medhistory.MedHistDate;
import seedu.address.model.medhistory.MedHistory;
import seedu.address.model.medhistory.PrevCountry;


/**
 * JAXB-friendly version of the Medical History.
 */

public class XmlAdaptedMedHistory {
    public static final String MISSING_FIELD_MESSAGE_FORMAT = "MedHistory's %s field is missing!";

    @XmlElement
    private String medHistDate;
    @XmlElement
    private String allergy;
    @XmlElement
    private String prevCountry;
    @XmlElement
    private String dischargeStatus;

    /**
     * Constructs an XmlAdaptedMedHistory.
     * This is the no-arg constructor that is required by JAXB.
     */
    public XmlAdaptedMedHistory() {}

    /**
     * Constructs an {@code XmlAdaptedMedHistory} with the given medical history details.
     */
    public XmlAdaptedMedHistory(String medHistDate, String allergy, String prevCountry, String dischargeStatus) {
        this.medHistDate = medHistDate;
        this.allergy = allergy;
        this.prevCountry = prevCountry;
        this.dischargeStatus = dischargeStatus;
    }

    /**
     * Converts a given medical history into this class for JAXB use.
     *
     * @param source future changes to this will not affect the created XmlAdaptedMedHistory
     */

    public XmlAdaptedMedHistory(MedHistory source) {
        MedHistDate medHistDate = source.getMedHistDate().orElse(new MedHistDate(""));
        this.medHistDate = medHistDate.toString();

        Allergy allergy = source.getAllergy().orElse(new Allergy(""));
        this.allergy = allergy.toString();

        PrevCountry prevCountry = source.getPrevCountry().orElse(new PrevCountry(""));
        this.prevCountry = prevCountry.toString();

        DischargeStatus dischargeStatus = source.getDischargeStatus().orElse(new DischargeStatus(""));
        this.dischargeStatus = dischargeStatus.toString();
    }

    /**
     * Converts this jaxb-friendly adapted medical history object into the model's medical history object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted medical history
     */
    public MedHistory toModelType() throws IllegalValueException {
        if (medHistDate == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    MedHistDate.class.getSimpleName()));
        }
        final MedHistDate modelMedHistDate = new MedHistDate(medHistDate);
        if (allergy == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Allergy.class.getSimpleName()));
        }
        final Allergy modelAllergy = new Allergy(allergy);
        if (prevCountry == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    PrevCountry.class.getSimpleName()));
        }
        final PrevCountry modelPrevCountry = new PrevCountry(prevCountry);
        if (dischargeStatus == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    DischargeStatus.class.getSimpleName()));
        }
        final DischargeStatus modelDischargeStatus = new DischargeStatus(dischargeStatus);

        return new MedHistory(modelMedHistDate, modelAllergy, modelPrevCountry, modelDischargeStatus);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof XmlAdaptedMedHistory)) {
            return false;
        }

        XmlAdaptedMedHistory otherMedHistory = (XmlAdaptedMedHistory) other;
        return Objects.equals(medHistDate, otherMedHistory.medHistDate)
                && Objects.equals(allergy, otherMedHistory.allergy)
                && Objects.equals(prevCountry, otherMedHistory.prevCountry)
                && Objects.equals(dischargeStatus, otherMedHistory.dischargeStatus);
    }

}
