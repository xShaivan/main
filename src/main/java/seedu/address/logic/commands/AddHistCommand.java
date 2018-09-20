package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_HISTORY;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.CommandHistory;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Adds/Edits medical history of a patient in the Health Book.
 */

public class AddHistCommand extends Command {

    public static final String COMMAND_WORD = "addhist";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds/Edits medical history of a patient in the Health Book "
            + "by the index number used in the last person listing."
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_HISTORY + "Diabetes.";

    public static final String MESSAGE_ARGUMENTS = "Index: %1$d, MedHist: %2$s";
    private final Index index;
    private final String medhistory;
    /**
     * @param index of the patient in the filtered patient list to add medical history
     * @param medhistory of the person to be updated to
     */
    public AddHistCommand(Index index, String medhistory) {
        requireAllNonNull(index, medhistory);
        this.index = index;
        this.medhistory = medhistory;
    }

    @Override
    public CommandResult execute(Model model, CommandHistory history) throws CommandException {
        throw new CommandException(String.format(MESSAGE_ARGUMENTS, index.getOneBased(), medhistory));
    }
    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }
        // instanceof handles nulls
        if (!(other instanceof AddHistCommand)) {
            return false;
        }
        // state check
        AddHistCommand e = (AddHistCommand) other;
        return index.equals(e.index)
                && medhistory.equals(e.medhistory);
    }
}
