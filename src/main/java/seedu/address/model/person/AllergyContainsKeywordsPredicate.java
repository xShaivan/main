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
public class AllergyContainsKeywordsPredicate implements Predicate<Person> {
    private final List<String> keywords;

    public AllergyContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Person person) {
        List<MedHistory> medHistory = new ArrayList<>(person.getMedHistory());
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(medHistory.get(0).getAllergy().toString(),
                        keyword));
    }


    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AllergyContainsKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((AllergyContainsKeywordsPredicate) other).keywords)); // state check
    }

}
