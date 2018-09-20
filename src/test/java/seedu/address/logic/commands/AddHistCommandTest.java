package seedu.address.logic.commands;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static seedu.address.logic.commands.CommandTestUtil.VALID_HISTORY_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_HISTORY_BOB;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.AddHistCommand.MESSAGE_ARGUMENTS;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.Test;

import seedu.address.logic.CommandHistory;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

/**
 * Contains integration tests (interaction with the Model) and unit tests for RemarkCommand.
 */

public class AddHistCommandTest {

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute() {
        final String medhist = "Some medical history";

        assertCommandFailure(new AddHistCommand(INDEX_FIRST_PERSON, medhist), model, new CommandHistory(),
                String.format(MESSAGE_ARGUMENTS, INDEX_FIRST_PERSON.getOneBased(), medhist));
    }

    @Test
    public void equals() {
        final AddHistCommand standardCommand = new AddHistCommand(INDEX_FIRST_PERSON, VALID_HISTORY_AMY);
        // same values -> returns true
        AddHistCommand commandWithSameValues = new AddHistCommand(INDEX_FIRST_PERSON, VALID_HISTORY_AMY);
        assertTrue(standardCommand.equals(commandWithSameValues));
        // same object -> returns true
        assertTrue(standardCommand.equals(standardCommand));
        // null -> returns false
        assertFalse(standardCommand.equals(null));
        // different types -> returns false
        assertFalse(standardCommand.equals(new ClearCommand()));
        // different index -> returns false
        assertFalse(standardCommand.equals(new AddHistCommand(INDEX_SECOND_PERSON, VALID_HISTORY_AMY)));
        // different remark -> returns false
        assertFalse(standardCommand.equals(new AddHistCommand(INDEX_FIRST_PERSON, VALID_HISTORY_BOB)));
    }
}
