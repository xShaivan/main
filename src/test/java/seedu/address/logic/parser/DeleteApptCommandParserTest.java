package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

import org.junit.Test;

import seedu.address.logic.commands.DeleteApptCommand;
import seedu.address.model.timetable.ApptDateTime;

public class DeleteApptCommandParserTest {
    private static final String INVALID_ARGUMENT = "a/";
    private static final String VALID_ARGUMENT = "s/";
    private static final String VALID_DATE_TIME = "16-09-2018 15:00";

    private DeleteApptCommandParser parser = new DeleteApptCommandParser();

    @Test
    public void parseInvalidArgumentThrowsParseException() {
        String input = "1 " + INVALID_ARGUMENT + VALID_DATE_TIME;

        assertParseFailure(parser, input, String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                DeleteApptCommand.MESSAGE_USAGE));
    }

    @Test
    public void parseValidArgumentReturnsDeleteApptCommand() {
        String input = "1 " + VALID_ARGUMENT + VALID_DATE_TIME;

        assertParseSuccess(parser, input, new DeleteApptCommand(INDEX_FIRST_PERSON, new ApptDateTime(VALID_DATE_TIME)));
    }

    @Test
    public void parseInvalidValueThrowsParseException() {
        String input = "0 " + VALID_ARGUMENT + VALID_DATE_TIME;

        assertParseFailure(parser, input, String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                DeleteApptCommand.MESSAGE_USAGE));
    }

}
