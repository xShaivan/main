package seedu.address.logic.commands;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static seedu.address.logic.commands.AddInfoCommand.MESSAGE_ARGUMENTS;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NRIC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NRIC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.Test;

import seedu.address.logic.CommandHistory;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

public class AddInfoCommandTest {

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute() {
        final String nric = "S8010517G";

        assertCommandFailure(new AddInfoCommand(INDEX_FIRST_PERSON, nric), model, new CommandHistory(),
                String.format(MESSAGE_ARGUMENTS, INDEX_FIRST_PERSON.getOneBased(), nric));

    }

    @Test
    public void equals() {
        final AddInfoCommand standardCommand = new AddInfoCommand(INDEX_FIRST_PERSON, VALID_NRIC_AMY);

        // same value -> returns true
        AddInfoCommand commandWithSameValues = new AddInfoCommand(INDEX_FIRST_PERSON, VALID_NRIC_AMY);
        assertTrue(standardCommand.equals(commandWithSameValues));

        // same object -> returns true
        assertTrue(standardCommand.equals(standardCommand));

        // null -> returns false
        assertFalse(standardCommand.equals(null));

        // different types -> returns false
        assertFalse(standardCommand.equals(new ClearCommand()));

        // different index -> returns false
        assertFalse(standardCommand.equals(new AddInfoCommand(INDEX_SECOND_PERSON, VALID_NRIC_AMY)));

        // different NRIC -> returns false
        assertFalse(standardCommand.equals(new AddInfoCommand(INDEX_FIRST_PERSON, VALID_NRIC_BOB)));
    }
}
