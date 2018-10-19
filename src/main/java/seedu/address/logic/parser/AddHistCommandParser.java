package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_HISTORY_ALLERGY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_HISTORY_COUNTRY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_HISTORY_DATE;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.commands.AddHistCommand;
import seedu.address.model.medhistory.MedHistory;
import seedu.address.logic.parser.exceptions.ParseException;


/**
 * Parses input arguments and create a {@code AddHistCommand} object
 */

public class AddHistCommandParser implements Parser<AddHistCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the {@code AddHistCommand}
     * and returns a {@code AddHistCommand} object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */

    public AddHistCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_HISTORY_DATE, PREFIX_HISTORY_ALLERGY,
                PREFIX_HISTORY_COUNTRY);

        Index index;

        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (IllegalValueException ive) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddHistCommand.MESSAGE_USAGE), ive);
        }

        MedHistory medHistory = new MedHistory();
        if (argMultimap.getValue(PREFIX_HISTORY_DATE).isPresent()) {
            medHistory.setMedHistDate(ParserUtil
                    .parseMedHistDate(argMultimap.getValue(PREFIX_HISTORY_DATE).get()));
        }
        if (argMultimap.getValue(PREFIX_HISTORY_ALLERGY).isPresent()) {
            medHistory.setAllergy(ParserUtil
                    .parseAllergy(argMultimap.getValue(PREFIX_HISTORY_ALLERGY).get()));
        }
        if (argMultimap.getValue(PREFIX_HISTORY_COUNTRY).isPresent()) {
            medHistory.setPrevCountry(ParserUtil
                    .parsePrevCountry(argMultimap.getValue(PREFIX_HISTORY_COUNTRY).get()));
        }
        if (!medHistory.isAnyFieldEdited()) {
            throw new ParseException(AddHistCommand.MESSAGE_NOT_EDITED);
        }

        return new AddHistCommand(index, medHistory);
    }
}
