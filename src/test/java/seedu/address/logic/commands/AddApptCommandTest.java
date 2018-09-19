package seedu.address.logic.commands;

import org.junit.Test;
import seedu.address.logic.CommandHistory;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

import static seedu.address.logic.commands.AddApptCommand.MESSAGE_NOT_IMPLEMENTED_YET;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

/**
 * Contains integration tests (interaction with the Model) and unit tests for AddApptCommand.
 */
public class AddApptCommandTest {

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute() {
        assertCommandFailure(new AddApptCommand(), model, new CommandHistory(), MESSAGE_NOT_IMPLEMENTED_YET);
    }
}
