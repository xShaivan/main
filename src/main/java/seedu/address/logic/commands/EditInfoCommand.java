package seedu.address.logic.commands;

import seedu.address.logic.CommandHistory;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Edits optional details of an existing patient in the address book.
 */

public class EditInfoCommand extends Command {
    public static final String COMMAND_WORD = "editinfo";


    @Override
    public CommandResult execute(Model model, CommandHistory history) throws CommandException {
        throw new CommandException("COMMAND NOT YET IMPLEMENTED");
    }
}
