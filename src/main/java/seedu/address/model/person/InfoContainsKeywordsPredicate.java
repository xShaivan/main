package seedu.address.model.person;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;
import seedu.address.model.medicalreport.MedicalReport;

/**
 * Tests that a {@code Person}'s {@code Medical Report Information} matches any of the keyword given.
 */

public class InfoContainsKeywordsPredicate implements Predicate<MedicalReport> {
    private final List<String> keywords;

    public InfoContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(MedicalReport medicalreport) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(medicalreport.getInformation().fullInformation,
                        keyword));
    }


    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof InfoContainsKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((InfoContainsKeywordsPredicate) other).keywords)); // state check
    }

}
