package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import seedu.address.model.medhistory.MedHistory;
import seedu.address.model.medhistory.MedHistoryComparator;
import seedu.address.model.medicalreport.MedicalReport;
import seedu.address.model.person.addinfo.DateOfBirth;
import seedu.address.model.person.addinfo.Height;
import seedu.address.model.person.addinfo.Nric;
import seedu.address.model.person.addinfo.Weight;
import seedu.address.model.tag.Tag;
import seedu.address.model.timetable.Appt;
import seedu.address.model.timetable.ApptComparator;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Person {

    // Identity fields
    private final Name name;
    private final Phone phone;
    private final Email email;

    // Data fields
    private final Address address;
    private final Set<MedHistory> medHistories = new TreeSet<>(new MedHistoryComparator());
    private final Set<Appt> appts = new TreeSet<>(new ApptComparator());
    private final Set<Tag> tags = new HashSet<>();
    private final Set<MedicalReport> reports = new HashSet<>();

    // Additional information fields
    private final Nric nric;
    private final DateOfBirth dateOfBirth;
    private final Height height;
    private final Weight weight;
    //private final Gender gender;

    /**
     * Every field must be present and not null.
     */
    public Person(Name name, Phone phone, Email email, Address address, Set<MedicalReport> reports,
                  Set<MedHistory> medHistories, Set<Appt> appts, Nric nric, DateOfBirth dateOfBirth, Height height,
                  Weight weight, Set<Tag> tags) {
        requireAllNonNull(name, phone, email, address, tags);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.nric = nric;
        this.dateOfBirth = dateOfBirth;
        this.height = height;
        this.weight = weight;
        this.reports.addAll(reports);
        this.medHistories.addAll(medHistories);
        this.appts.addAll(appts);
        this.tags.addAll(tags);
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    //@@author chewkahmeng
    public Set<MedicalReport> getMedicalReports() {
        return Collections.unmodifiableSet(reports);
    }

    //@@author xShaivan
    public Set<MedHistory> getMedHistory() {
        return Collections.unmodifiableSet(medHistories);
    }

    //@@author
    public Nric getNric() {
        return nric;
    }

    public DateOfBirth getDateOfBirth() {
        return dateOfBirth;
    }

    public Height getHeight() {
        return height;
    }

    public Weight getWeight() {
        return weight;
    }

    //@@author brandonccm1996
    public Set<Appt> getAppts() {
        return Collections.unmodifiableSet(appts);
    }

    //@@author
    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns true if both persons of the same name have at least one other identity field that is the same.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Person otherPerson) {
        if (otherPerson == this) {
            return true;
        }

        return otherPerson != null
                && otherPerson.getName().equals(getName())
                && (otherPerson.getPhone().equals(getPhone()) || otherPerson.getEmail().equals(getEmail()));
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Person)) {
            return false;
        }

        Person otherPerson = (Person) other;
        return otherPerson.getName().equals(getName())
                && otherPerson.getPhone().equals(getPhone())
                && otherPerson.getEmail().equals(getEmail())
                && otherPerson.getAddress().equals(getAddress())
                //&& otherPerson.getNric().equals(getNric())
                //&& otherPerson.getDateOfBirth().equals(getDateOfBirth())
                //&& otherPerson.getHeight().equals(getHeight())
                //&& otherPerson.getWeight().equals(getWeight())
                && otherPerson.getMedHistory().equals(getMedHistory())
                && otherPerson.getAppts().equals(getAppts())
                && otherPerson.getMedicalReports().equals(getMedicalReports())
                && otherPerson.getTags().equals(getTags());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, phone, email, address, tags);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append(" Phone: ")
                .append(getPhone())
                .append(" Email: ")
                .append(getEmail())
                .append(" Address: ")
                .append(getAddress())
                .append(" Tags: ");
        getTags().forEach(builder::append);
        return builder.toString();
    }

}
