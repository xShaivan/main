package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_ORDER;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_PREFIX;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADD_INFO_NRIC;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;

import seedu.address.logic.commands.SortCommand;
import seedu.address.logic.parser.exceptions.ParseException;

//@@author chokxy
/**
 * Parses input arguments and creates a new SortCommand object
 * Switch cases for static attributes
 */
public class SortCommandParser implements Parser<SortCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the SortCommand
     * and returns an SortCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public SortCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty() ||trimmedArgs.length()< 4) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, SortCommand.MESSAGE_USAGE));
        }

        String[] nameKeywords = trimmedArgs.split("\\s+");
        String prefix = nameKeywords[0];
        int order = Integer.parseInt(nameKeywords[1]);

        if (order != 1 && order != 2)
            throw new ParseException(MESSAGE_INVALID_ORDER);

        if (!(prefix.equals(PREFIX_NAME) || prefix.equals(PREFIX_PHONE) || prefix.equals(PREFIX_EMAIL) || prefix.equals(PREFIX_ADD_INFO_NRIC)))
            throw new ParseException(MESSAGE_INVALID_PREFIX);

        return new SortCommand(prefix, order);
    }
}
