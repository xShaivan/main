package seedu.address.testutil;

import seedu.address.model.medhistory.MedHistory;
import seedu.address.model.medhistory.MedHistDate;
import seedu.address.model.medhistory.Allergy;
import seedu.address.model.medhistory.PrevCountry;

/**
 * A utility class to help with building MedHistory objects.
 */
public class MedHistoryBuilder {
    public static final String DEFAULT_MEDHISTDATE = "12/12/2012";
    public static final String DEFAULT_ALLERGY = "nuts";
    public static final String DEFAULT_PREVCOUNTRY = "Mother Russia";

    private MedHistDate medHistDate;
    private Allergy allergy;
    private PrevCountry prevCountry;

    public MedHistoryBuilder() {
        medHistDate = new MedHistDate(DEFAULT_MEDHISTDATE);
        allergy = new Allergy(DEFAULT_ALLERGY);
        prevCountry = new PrevCountry(DEFAULT_PREVCOUNTRY);
    }
    /**
     * Initializes the ReportBuilder with the data of {@code medHistoryToCopy}.
     */
    public MedHistoryBuilder(MedHistory medHistoryToCopy) {
        medHistDate = medHistoryToCopy.getMedHistDate();
        allergy = medHistoryToCopy.getAllergy();
        prevCountry = medHistoryToCopy.getPrevCountry();
    }
    /**
     * Sets the {@code MedHistDate} of the {@code MedHistory} that we are building.
     */
    public MedHistoryBuilder withMedHistDate(String medHistDate) {
        this.medHistDate = new MedHistDate(medHistDate);
        return this;
    }
    /**
     * Sets the {@code Allergy} of the {@code MedHistory} that we are building.
     */
    public MedHistoryBuilder withAllergy(String allergy) {
        this.allergy = new Allergy(allergy);
        return this;
    }
    /**
     * Sets the {@code PrevCountry} of the {@code MedHistory} that we are building.
     */
    public MedHistoryBuilder withPrevCountry(String prevCountry) {
        this.prevCountry = new PrevCountry(prevCountry);
        return this;
    }

    public MedHistory build() {
        return new MedHistory(medHistDate, allergy, prevCountry);
    }
}
