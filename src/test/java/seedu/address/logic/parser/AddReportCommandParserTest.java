package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_DATE_WPREFIX;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_INFO_WPREFIX;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_TITLE_WPREFIX;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DATE1;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DATE_WPREFIX;
import static seedu.address.logic.commands.CommandTestUtil.VALID_INFO1;
import static seedu.address.logic.commands.CommandTestUtil.VALID_INFO_WPREFIX;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TITLE1;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TITLE_WPREFIX;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_INFO;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TITLE;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.model.medicalreport.Information.MESSAGE_INFORMATION_CONSTRAINTS;
import static seedu.address.model.medicalreport.Title.MESSAGE_TITLE_CONSTRAINTS;
import static seedu.address.model.util.DateTimeUtil.DATE_CONSTRAINTS;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

import org.junit.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.AddMedicalReportCommand;
import seedu.address.testutil.ReportBuilder;

//@@author chewkahmeng
public class AddReportCommandParserTest {

    private static final String MESSAGE_INVALID_FORMAT =
            String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddMedicalReportCommand.MESSAGE_USAGE);
    private AddMedicalReportCommandParser parser = new AddMedicalReportCommandParser();
    private Index targetIndex = INDEX_FIRST_PERSON;

    @Test
    public void parseIndexSpecifiedSuccess() {
        // have report
        Index targetIndex = INDEX_FIRST_PERSON;
        AddMedicalReportCommand expectedCommand =
                new AddMedicalReportCommand(INDEX_FIRST_PERSON, new ReportBuilder().build());
        assertParseSuccess(parser, targetIndex.getOneBased()
                + " " + PREFIX_TITLE + VALID_TITLE1
                + " " + PREFIX_DATE + VALID_DATE1
                + " " + PREFIX_INFO + VALID_INFO1, expectedCommand);
    }

    @Test
    public void parseMissingCompulsoryFieldFailure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddMedicalReportCommand.MESSAGE_USAGE);

        // no parameters
        assertParseFailure(parser, AddMedicalReportCommand.COMMAND_WORD, expectedMessage);

        // missing index
        assertParseFailure(parser, PREFIX_TITLE + VALID_TITLE1
                + " " + PREFIX_DATE + VALID_DATE1
                + " " + PREFIX_INFO + VALID_INFO1, expectedMessage);

        // missing title prefix
        assertParseFailure(parser, targetIndex.getOneBased() + VALID_TITLE1 + VALID_DATE_WPREFIX
                + VALID_INFO_WPREFIX, MESSAGE_INVALID_FORMAT);

        // missing date prefix
        assertParseFailure(parser, targetIndex.getOneBased() + VALID_TITLE_WPREFIX + VALID_DATE1
                        + VALID_INFO_WPREFIX, MESSAGE_INVALID_FORMAT);

        // missing information prefix
        assertParseFailure(parser, targetIndex.getOneBased() + VALID_TITLE_WPREFIX
                + VALID_DATE_WPREFIX + VALID_INFO1, MESSAGE_INVALID_FORMAT);
    }

    @Test
    public void parseInvalidValueFailure() {
        // invalid title
        assertParseFailure(parser, targetIndex.getOneBased() + INVALID_TITLE_WPREFIX
                + VALID_DATE_WPREFIX + VALID_INFO_WPREFIX, MESSAGE_TITLE_CONSTRAINTS);

        // invalid date
        assertParseFailure(parser, targetIndex.getOneBased() + VALID_TITLE_WPREFIX
                + INVALID_DATE_WPREFIX + VALID_INFO_WPREFIX, DATE_CONSTRAINTS);

        // invalid information
        assertParseFailure(parser, targetIndex.getOneBased() + VALID_TITLE_WPREFIX
                + VALID_DATE_WPREFIX + INVALID_INFO_WPREFIX, MESSAGE_INFORMATION_CONSTRAINTS);
    }

    @Test
    public void parseInvalidIndexFailure() {
        // negative index
        assertParseFailure(parser, "-2" + VALID_TITLE_WPREFIX
                + VALID_DATE_WPREFIX + VALID_INFO_WPREFIX, MESSAGE_INVALID_FORMAT);

        // zero index
        assertParseFailure(parser, "0" + VALID_TITLE_WPREFIX
                + VALID_DATE_WPREFIX + VALID_INFO_WPREFIX, MESSAGE_INVALID_FORMAT);
    }
}
