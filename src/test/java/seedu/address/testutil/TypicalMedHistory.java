package seedu.address.testutil;
import seedu.address.model.medhistory.MedHistory;
/**
 * A utility class containing a list of {@code MedicalReport} objects to be used in tests.
 */
public class TypicalMedHistory {
    public static final MedHistory MEDHISTORY1 = new MedHistoryBuilder().withMedHistDate("12/12/2012")
            .withAllergy("nuts").withPrevCountry("Mother Russia").build();
    public static final MedHistory MEDHISTORY2 = new MedHistoryBuilder().withMedHistDate("11/11/2011")
            .withAllergy("alcohol").withPrevCountry("Poland").build();
    public static final MedHistory EMPTY_MEDHISTORY = new MedHistoryBuilder().withMedHistDate("").withAllergy("")
            .withPrevCountry("").build();
}
