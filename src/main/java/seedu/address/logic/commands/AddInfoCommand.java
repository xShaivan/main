package seedu.address.logic.commands;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.CommandHistory;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Edits optional details of an existing patient in the address book.
 */

public class AddInfoCommand extends Command {
    public static final String COMMAND_WORD = "addinfo";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Edits the additional information of the person identified "
            + "by the index number used in the last person listing. "
            + "Existing information will be overwritten by the input.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + "Example: " + COMMAND_WORD + " 1 ";

    public static final String MESSAGE_NOT_IMPLEMENTED_YET = "Command has not been implemented yet.";
    public static final String MESSAGE_ARGUMENTS = "Index: %1$d, NRIC: %2$s";

    private final Index index;
    private final String nric;


    /**
     *
     * @param index of the person in the filter person list to edit the additional info
     * @param nric of the person to be updated to
     */
    public AddInfoCommand(Index index, String nric) {
        requireAllNonNull(index, nric);

        this.index = index;
        this.nric = nric;
    }


    @Override
    public CommandResult execute(Model model, CommandHistory history) throws CommandException {
        throw new CommandException(String.format(MESSAGE_ARGUMENTS, index.getOneBased(), nric));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof AddInfoCommand)) {
            return false;
        }

        // state check
        AddInfoCommand e = (AddInfoCommand) other;
        return index.equals(e.index) && nric.equals(e.nric);
    }
}
