package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Arrays;

import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.AddressContainsKeywordsPredicate;
//import seedu.address.model.person.AllergyContainsKeywordsPredicate;
//import seedu.address.model.person.BloodTypeContainsKeywordsPredicate;
//import seedu.address.model.person.CountryContainsKeywordsPredicate;
import seedu.address.model.person.EmailContainsKeywordsPredicate;
//import seedu.address.model.person.InfoContainsKeywordsPredicate;
import seedu.address.model.person.NameContainsKeywordsPredicate;
import seedu.address.model.person.NricContainsKeywordsPredicate;
import seedu.address.model.person.PhoneContainsKeywordsPredicate;
import seedu.address.model.person.TagContainsKeywordsPredicate;

/**
 * Parses input arguments and creates a new FindCommand object
 * Switch cases for static attributes
 */
public class FindCommandParser implements Parser<FindCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the FindCommand
     * and returns an FindCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public FindCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
        }


        String[] nameKeywords = trimmedArgs.split("\\s+");

        switch(nameKeywords[0]) {
        //Personal prefixes
        case "n/":
            //create NameContainsKeywordsPredicate
            /*
            String keywords = nameKeywords[1] + nameKeywords[2];
            return new FindCommand(new NameContainsKeywordsPredicate(Arrays.asList(keywords)));
            */
            return new FindCommand(new NameContainsKeywordsPredicate(Arrays.asList(nameKeywords[1])));

        case "p/":
            //create PhoneContainsKeywordsPredicate
            return new FindCommand(new PhoneContainsKeywordsPredicate(Arrays.asList(nameKeywords[1])));

        case "e/":
            //create EmailContainsKeywordsPredicate
            return new FindCommand(new EmailContainsKeywordsPredicate(Arrays.asList(nameKeywords[1])));

        case "a/":
            //create AddressContainsKeywordsPredicate
            return new FindCommand(new AddressContainsKeywordsPredicate(Arrays.asList(nameKeywords[1])));

        case "t/":
            //create TagContainsKeywordsPredicate
            return new FindCommand(new TagContainsKeywordsPredicate(Arrays.asList(nameKeywords[1])));

        case "ic/":
            //create NricContainsKeywordsPredicate
            return new FindCommand(new NricContainsKeywordsPredicate(Arrays.asList(nameKeywords[1])));

        //Medical Prefixes
        /*
        case "i/":
            //create InfoContainsKeywordsPredicate
            return new FindCommand(new InfoContainsKeywordsPredicate(Arrays.asList(nameKeywords[1])));

        case "hsb/":
            //create BloodTypeContainsKeywordsPredicate
            return new FindCommand(new BloodTypeContainsKeywordsPredicate(Arrays.asList(nameKeywords[1])));

        case "hsc/":
            //create CountryContainsKeywordsPredicate
            return new FindCommand(new CountryContainsKeywordsPredicate(Arrays.asList(nameKeywords[1])));

        case "hsa/":
            //create AllergyContainsKeywordsPredicate
            return new FindCommand(new AllergyContainsKeywordsPredicate(Arrays.asList(nameKeywords[1])));
        */
        default:
            throw new ParseException(MESSAGE_INVALID_COMMAND_FORMAT);
        }
    }

}
