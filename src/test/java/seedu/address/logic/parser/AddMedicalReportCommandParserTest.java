package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MEDICAL_REPORT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import org.junit.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.AddMedicalReportCommand;
import seedu.address.model.medicalreport.MedicalReport;

public class AddMedicalReportCommandParserTest {

    private AddMedicalReportCommandParser parser = new AddMedicalReportCommandParser();
    private final String nonEmptyMedicalReport = "Some remark.";
    @Test
    public void parseIndexSpecifiedSuccess() {
        // have remark
        Index targetIndex = INDEX_FIRST_PERSON;
        String userInput = targetIndex.getOneBased() + " " + PREFIX_MEDICAL_REPORT + nonEmptyMedicalReport;
        AddMedicalReportCommand expectedCommand = new AddMedicalReportCommand(INDEX_FIRST_PERSON, new MedicalReport(nonEmptyMedicalReport));
        assertParseSuccess(parser, userInput, expectedCommand);
        // no remark
        userInput = targetIndex.getOneBased() + " " + PREFIX_MEDICAL_REPORT;
        expectedCommand = new AddMedicalReportCommand(INDEX_FIRST_PERSON, new MedicalReport(""));
        assertParseSuccess(parser, userInput, expectedCommand);
    }
    @Test
    public void parseMissingCompulsoryFieldFailure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddMedicalReportCommand.MESSAGE_USAGE);
        // no parameters
        assertParseFailure(parser, AddMedicalReportCommand.COMMAND_WORD, expectedMessage);
        // no index
        assertParseFailure(parser, AddMedicalReportCommand.COMMAND_WORD + " " + nonEmptyMedicalReport, expectedMessage);
    }
}
