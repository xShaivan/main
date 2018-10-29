package seedu.address.model.person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;
import seedu.address.model.medhistory.MedHistory;
import seedu.address.model.medhistory.PrevCountry;

/**
 * Tests that a {@code Person}'s {@code Last Visited Country} matches any of the keyword given.
 */
public class CountryContainsKeywordsPredicate implements Predicate<Person> {
    private final List<String> keywords;

    public CountryContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Person person) {
        List<MedHistory> medHistory = new ArrayList<>(person.getMedHistory());
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(medHistory.get(0).getPrevCountry().value, keyword));
        }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof CountryContainsKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((CountryContainsKeywordsPredicate) other).keywords)); // state check
    }

}
