package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_DRNAME_APPT_WPREFIX;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_END_APPT_WPREFIX;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_INFO_APPT_WPREFIX;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_START_APPT_WPREFIX;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_VENUE_APPT_WPREFIX;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DRNAME_APPT1;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DRNAME_APPT_WPREFIX;
import static seedu.address.logic.commands.CommandTestUtil.VALID_END_APPT1;
import static seedu.address.logic.commands.CommandTestUtil.VALID_END_APPT_WPREFIX;
import static seedu.address.logic.commands.CommandTestUtil.VALID_INFO_APPT1;
import static seedu.address.logic.commands.CommandTestUtil.VALID_INFO_APPT_WPREFIX;
import static seedu.address.logic.commands.CommandTestUtil.VALID_START_APPT1;
import static seedu.address.logic.commands.CommandTestUtil.VALID_START_APPT_WPREFIX;
import static seedu.address.logic.commands.CommandTestUtil.VALID_VENUE_APPT1;
import static seedu.address.logic.commands.CommandTestUtil.VALID_VENUE_APPT_WPREFIX;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.model.util.DateTimeUtil.DATE_TIME_CONSTRAINTS;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

import org.junit.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.AddApptCommand;
import seedu.address.model.timetable.ApptDrName;
import seedu.address.model.timetable.ApptInfo;
import seedu.address.model.timetable.ApptVenue;
import seedu.address.testutil.ApptBuilder;

//@@author brandonccm1996
public class AddApptCommandParserTest {

    private static final String MESSAGE_INVALID_FORMAT =
            String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddApptCommand.MESSAGE_USAGE);
    private AddApptCommandParser parser = new AddApptCommandParser();
    private Index targetIndex = INDEX_FIRST_PERSON;

    @Test
    public void parseIndexSpecifiedWithAllCompulsoryFieldsSuccess() {
        // have appt
        AddApptCommand expectedCommand = new AddApptCommand(INDEX_FIRST_PERSON, new ApptBuilder().build());
        assertParseSuccess(parser, targetIndex.getOneBased() + VALID_START_APPT_WPREFIX
                + VALID_END_APPT_WPREFIX + VALID_VENUE_APPT_WPREFIX + VALID_INFO_APPT_WPREFIX
                + VALID_DRNAME_APPT_WPREFIX, expectedCommand);
    }

    @Test
    public void parseMissingCompulsoryFieldFailure() {
        // no parameters
        assertParseFailure(parser, AddApptCommand.COMMAND_WORD, MESSAGE_INVALID_FORMAT);

        // missing index
        assertParseFailure(parser, VALID_START_APPT_WPREFIX + VALID_END_APPT_WPREFIX
                        + VALID_VENUE_APPT_WPREFIX + VALID_INFO_APPT_WPREFIX + VALID_DRNAME_APPT_WPREFIX,
                MESSAGE_INVALID_FORMAT);

        // missing appt start prefix
        assertParseFailure(parser, targetIndex.getOneBased() + VALID_START_APPT1 + VALID_END_APPT_WPREFIX
                        + VALID_VENUE_APPT_WPREFIX + VALID_INFO_APPT_WPREFIX + VALID_DRNAME_APPT_WPREFIX,
                MESSAGE_INVALID_FORMAT);

        // missing appt end prefix
        assertParseFailure(parser, targetIndex.getOneBased() + VALID_START_APPT_WPREFIX + VALID_END_APPT1
                        + VALID_VENUE_APPT_WPREFIX + VALID_INFO_APPT_WPREFIX + VALID_DRNAME_APPT_WPREFIX,
                MESSAGE_INVALID_FORMAT);

        // missing appt venue prefix
        assertParseFailure(parser, targetIndex.getOneBased() + VALID_START_APPT_WPREFIX
                        + VALID_END_APPT_WPREFIX + VALID_VENUE_APPT1 + VALID_INFO_APPT_WPREFIX
                        + VALID_DRNAME_APPT_WPREFIX, MESSAGE_INVALID_FORMAT);

        // missing appt info prefix
        assertParseFailure(parser, targetIndex.getOneBased() + VALID_START_APPT_WPREFIX
                        + VALID_END_APPT_WPREFIX + VALID_VENUE_APPT_WPREFIX + VALID_INFO_APPT1
                        + VALID_DRNAME_APPT_WPREFIX, MESSAGE_INVALID_FORMAT);

        // missing appt dr name prefix
        assertParseFailure(parser, targetIndex.getOneBased() + VALID_START_APPT_WPREFIX
                        + VALID_END_APPT_WPREFIX + VALID_VENUE_APPT_WPREFIX + VALID_INFO_APPT_WPREFIX
                        + VALID_DRNAME_APPT1, MESSAGE_INVALID_FORMAT);
    }

    @Test
    public void parseInvalidValueFailure() {
        // invalid appt start
        assertParseFailure(parser, targetIndex.getOneBased() + INVALID_START_APPT_WPREFIX
                + VALID_END_APPT_WPREFIX + VALID_VENUE_APPT_WPREFIX + VALID_INFO_APPT_WPREFIX
                + VALID_DRNAME_APPT_WPREFIX, DATE_TIME_CONSTRAINTS);

        // invalid appt end
        assertParseFailure(parser, targetIndex.getOneBased() + VALID_START_APPT_WPREFIX
                + INVALID_END_APPT_WPREFIX + VALID_VENUE_APPT_WPREFIX + VALID_INFO_APPT_WPREFIX
                + VALID_DRNAME_APPT_WPREFIX, DATE_TIME_CONSTRAINTS);

        // invalid appt venue
        assertParseFailure(parser, targetIndex.getOneBased() + VALID_START_APPT_WPREFIX
                + VALID_END_APPT_WPREFIX + INVALID_VENUE_APPT_WPREFIX + VALID_INFO_APPT_WPREFIX
                + VALID_DRNAME_APPT_WPREFIX, ApptVenue.MESSAGE_NAME_CONSTRAINTS);

        // invalid appt info
        assertParseFailure(parser, targetIndex.getOneBased() + VALID_START_APPT_WPREFIX
                + VALID_END_APPT_WPREFIX + VALID_VENUE_APPT_WPREFIX + INVALID_INFO_APPT_WPREFIX
                + VALID_DRNAME_APPT_WPREFIX, ApptInfo.MESSAGE_NAME_CONSTRAINTS);

        // invalid appt dr name
        assertParseFailure(parser, targetIndex.getOneBased() + VALID_START_APPT_WPREFIX
                + VALID_END_APPT_WPREFIX + VALID_VENUE_APPT_WPREFIX + VALID_INFO_APPT_WPREFIX
                + INVALID_DRNAME_APPT_WPREFIX, ApptDrName.MESSAGE_NAME_CONSTRAINTS);
    }

    @Test
    public void parseInvalidIndexFailure() {
        // negative index
        assertParseFailure(parser, "-2" + VALID_START_APPT_WPREFIX
                + VALID_END_APPT_WPREFIX + VALID_VENUE_APPT_WPREFIX + VALID_INFO_APPT_WPREFIX
                + VALID_DRNAME_APPT_WPREFIX, MESSAGE_INVALID_FORMAT);

        // zero index
        assertParseFailure(parser, "0" + VALID_START_APPT_WPREFIX
                + VALID_END_APPT_WPREFIX + VALID_VENUE_APPT_WPREFIX + VALID_INFO_APPT_WPREFIX
                + VALID_DRNAME_APPT_WPREFIX, MESSAGE_INVALID_FORMAT);
    }
}
