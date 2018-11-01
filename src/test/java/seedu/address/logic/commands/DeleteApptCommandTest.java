package seedu.address.logic.commands;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_START_APPT1;
import static seedu.address.logic.commands.CommandTestUtil.VALID_START_APPT2;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.Test;

import seedu.address.logic.CommandHistory;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.timetable.ApptDateTime;

//@@author brandonccm1996
public class DeleteApptCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    private CommandHistory commandHistory = new CommandHistory();

    @Test
    public void equals() {
        DeleteApptCommand command1 = new DeleteApptCommand(INDEX_FIRST_PERSON, new ApptDateTime(VALID_START_APPT1));

        // same object -> returns true
        assertTrue(command1.equals(command1));

        // different types -> returns false
        assertFalse(command1.equals(1));

        // null -> returns false
        assertFalse(command1.equals(null));

        // different index -> returns false
        assertFalse(command1.equals(new DeleteApptCommand(INDEX_SECOND_PERSON, new ApptDateTime(VALID_START_APPT1))));

        // different apptdatetime -> returns false
        assertFalse(command1.equals(new DeleteApptCommand(INDEX_FIRST_PERSON, new ApptDateTime(VALID_START_APPT2))));
    }
}
