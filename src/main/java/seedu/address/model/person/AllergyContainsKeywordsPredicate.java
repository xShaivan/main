package seedu.address.model.person;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;
import seedu.address.model.medhistory.MedHistory;

/**
 * Tests that a {@code Person}'s {@code BloodType} matches any of the keyword given.
 */
public class AllergyContainsKeywordsPredicate implements Predicate<MedHistory> {
    private final List<String> keywords;

    public AllergyContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(MedHistory medHistory) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(medHistory.getAllergy().value, keyword));
    }


    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AllergyContainsKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((AllergyContainsKeywordsPredicate) other).keywords)); // state check
    }

}
