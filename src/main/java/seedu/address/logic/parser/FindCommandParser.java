package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_PREFIX;

import java.util.Arrays;

import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.NameContainsKeywordsPredicate;

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

        case "n/":
            return new FindCommand(new NameContainsKeywordsPredicate(Arrays.asList(nameKeywords[1])));

        case "p/":
            //create PhoneContainsKeywordsPredicate
            return new FindCommand(new NameContainsKeywordsPredicate(Arrays.asList(nameKeywords[1])));

        case "e/":
            //create EmailContainsKeywordsPredicate
            return new FindCommand(new NameContainsKeywordsPredicate(Arrays.asList(nameKeywords[1])));

        case "a/":
            //create AddressContainsKeywordsPredicate
            return new FindCommand(new NameContainsKeywordsPredicate(Arrays.asList(nameKeywords[1])));

        case "t/":
            //create TagContainsKeywordsPredicate
            return new FindCommand(new NameContainsKeywordsPredicate(Arrays.asList(nameKeywords[1])));

        default:
            throw new ParseException(MESSAGE_UNKNOWN_PREFIX);
        }
    }

}
