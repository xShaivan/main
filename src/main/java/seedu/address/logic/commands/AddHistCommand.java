package seedu.address.logic.commands;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_HISTORY_ALLERGY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_HISTORY_COUNTRY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_HISTORY_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_HISTORY_DISCHARGE_STATUS;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.CommandHistory;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.medhistory.MedHistory;
import seedu.address.model.medhistory.MedHistoryComparator;
import seedu.address.model.medicalreport.MedicalReport;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.addinfo.DateOfBirth;
import seedu.address.model.person.addinfo.Height;
import seedu.address.model.person.addinfo.Nric;
import seedu.address.model.person.addinfo.Weight;
import seedu.address.model.tag.Tag;
import seedu.address.model.timetable.Appt;

//@@author xShaivan
/**
 * Adds/Edits medical history of a patient in the Health Book.
 */

public class AddHistCommand extends Command {

    public static final String COMMAND_WORD = "addhist";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds/Edits medical history of a patient "
            + "by their index number."
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_HISTORY_DATE + " 24-08-1993 "
            + PREFIX_HISTORY_ALLERGY + " Alcohol "
            + PREFIX_HISTORY_COUNTRY + " Kuwait "
            + PREFIX_HISTORY_DISCHARGE_STATUS + " d";

    public static final String MESSAGE_ADD_MEDHISTORY_SUCCESS = "Added medical history to Person: %1$s";
    public static final String MESSAGE_NOT_EDITED = "At least one field to edit must be provided.";
    public static final String MESSAGE_DELETE_MEDHISTORY_SUCCESS = "Removed medical history from Person: %1$s";
    private final Index index;
    private final MedHistory medHistory;
    /**
     * @param index of the patient in the filtered patient list to add medical history
     * @param medHistory of the person to be updated to
     */
    public AddHistCommand(Index index, MedHistory medHistory) {
        requireAllNonNull(index, medHistory);
        this.index = index;
        this.medHistory = new MedHistory(medHistory);
    }

    @Override
    public CommandResult execute(Model model, CommandHistory history) throws CommandException {
        List<Person> lastShownList = model.getFilteredPersonList();
        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }
        Person personToEdit = lastShownList.get(index.getZeroBased());
        Set<MedHistory> fullMedHistories = personToEdit.getMedHistory();
        Set<MedHistory> newMedHistories = new TreeSet<>(new MedHistoryComparator());
        // for loop overwrites all existing history with itself
        for (MedHistory medHistory : fullMedHistories) {
            newMedHistories.add(medHistory);
        }
        // adds the new history from command
        newMedHistories.add(medHistory);
        Person editedPerson = createEditedPerson(personToEdit, newMedHistories);
        model.updatePerson(personToEdit, editedPerson);
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        model.commitAddressBook();
        return new CommandResult(String.format(MESSAGE_ADD_MEDHISTORY_SUCCESS, editedPerson));
    }

    /**
     * Creates and returns a {@code Person} with the details of {@code personToEdit}
     * edited with {@code medHistories}.
     */
    private static Person createEditedPerson(Person personToEdit, Set <MedHistory> newMedHistories) {
        assert personToEdit != null;

        Name name = personToEdit.getName();
        Phone phone = personToEdit.getPhone();
        Email email = personToEdit.getEmail();
        Address address = personToEdit.getAddress();
        Set<Appt> appts = personToEdit.getAppts();
        Set<MedicalReport> medicalReports = personToEdit.getMedicalReports();
        Set<MedHistory> medHistories = newMedHistories;
        Set<Tag> tags = personToEdit.getTags();

        Nric nric = personToEdit.getNric();
        DateOfBirth dateOfBirth = personToEdit.getDateOfBirth();
        Height height = personToEdit.getHeight();
        Weight weight = personToEdit.getWeight();

        return new Person(name, phone, email, address, medicalReports, medHistories, appts,
                nric, dateOfBirth, height, weight, tags);
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
                && medHistory.equals(e.medHistory);
    }
}
