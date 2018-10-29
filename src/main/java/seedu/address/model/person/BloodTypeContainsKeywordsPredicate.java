package seedu.address.model.person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;
import seedu.address.model.medhistory.Allergy;
import seedu.address.model.medhistory.MedHistory;

/**
 * Tests that a {@code Person}'s {@code BloodType} matches any of the keyword given.
 */
public class BloodTypeContainsKeywordsPredicate implements Predicate<Person> {
    private final List<String> keywords;

    public BloodTypeContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Person person) {
        List<MedHistory> medHistory = new ArrayList<>(person.getMedHistory());
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(medHistory.get(0).getAllergy().value, keyword));
        // BloodType not properly implemented yet, sticking to allergy first
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof BloodTypeContainsKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((BloodTypeContainsKeywordsPredicate) other).keywords)); // state check
    }

}
