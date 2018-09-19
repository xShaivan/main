package seedu.address.logic.commands;

import seedu.address.logic.CommandHistory;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

import static seedu.address.logic.parser.CliSyntax.*;

/**
 * Adds an appointment to a person's timetable.
 */
public class AddApptCommand extends Command {

    public static final String COMMAND_WORD = "addappt";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds an appointment to a patient's timetable, the" +
            " patient will be identified by the index number used in the last person listing.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + PREFIX_APPT_START + "[START] "
            + PREFIX_APPT_END + "[END] "
            + PREFIX_APPT_VENUE + "[VENUE] "
            + PREFIX_APPT_INFO + "[INFO] "
            + PREFIX_APPT_DRNAME + "[DOCTOR'S NAME]\n"
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_APPT_START + "16/09/2018 1500 "
            + PREFIX_APPT_END + "16/09/2018 1530 "
            + PREFIX_APPT_VENUE + "Consultation Room 12 "
            + PREFIX_APPT_INFO + "Diabetes Checkup "
            + PREFIX_APPT_DRNAME + "Dr Tan";

    public static final String MESSAGE_NOT_IMPLEMENTED_YET = "Add appt command not implemented yet";

    @Override
    public CommandResult execute(Model model, CommandHistory history) throws CommandException {
        throw new CommandException(MESSAGE_NOT_IMPLEMENTED_YET);
    }
}
