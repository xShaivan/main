package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.medhistory.MedHistory;
import seedu.address.model.medhistory.MedHistoryComparator;
import seedu.address.model.medicalreport.MedicalReport;
import seedu.address.model.medicalreport.ReportComparator;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.addinfo.BloodType;
import seedu.address.model.person.addinfo.DateOfBirth;
import seedu.address.model.person.addinfo.Gender;
import seedu.address.model.person.addinfo.Height;
import seedu.address.model.person.addinfo.MaritalStatus;
import seedu.address.model.person.addinfo.Nric;
import seedu.address.model.person.addinfo.Occupation;
import seedu.address.model.person.addinfo.Weight;
import seedu.address.model.tag.Tag;
import seedu.address.model.timetable.Appt;
import seedu.address.model.timetable.ApptComparator;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {

    public static final Nric EMPTY_NRIC = new Nric("");
    public static final DateOfBirth EMPTY_DATE_OF_BIRTH = new DateOfBirth("");
    public static final Height EMPTY_HEIGHT = new Height("");
    public static final Weight EMPTY_WEIGHT = new Weight("");
    public static final Gender EMPTY_GENDER = new Gender("");
    public static final BloodType EMPTY_BLOODTYPE = new BloodType("");
    public static final Occupation EMPTY_OCCUPATION = new Occupation("");
    public static final MaritalStatus EMPTY_MARITAL_STATUS = new MaritalStatus("");

    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                new Address("Blk 30 Geylang Street 29, #06-40"), getReportSet(),
                    getMedHistorySet(), getApptSet(), EMPTY_NRIC, EMPTY_DATE_OF_BIRTH, new Height("180"), EMPTY_WEIGHT,
                    EMPTY_GENDER, EMPTY_BLOODTYPE, EMPTY_OCCUPATION, EMPTY_MARITAL_STATUS,
                    getTagSet("asthma")),
            new Person(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"), getReportSet(),
                    getMedHistorySet(), getApptSet(), EMPTY_NRIC, EMPTY_DATE_OF_BIRTH, EMPTY_HEIGHT, EMPTY_WEIGHT,
                    EMPTY_GENDER, EMPTY_BLOODTYPE, EMPTY_OCCUPATION, EMPTY_MARITAL_STATUS,
                    getTagSet("asthma", "diabetes")),
            new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                new Address("Blk 11 Ang Mo Kio Street 74, #11-04"), getReportSet(),
                    getMedHistorySet(), getApptSet(), EMPTY_NRIC, EMPTY_DATE_OF_BIRTH, EMPTY_HEIGHT, EMPTY_WEIGHT,
                    EMPTY_GENDER, EMPTY_BLOODTYPE, EMPTY_OCCUPATION, EMPTY_MARITAL_STATUS,
                    getTagSet("cancer")),
            new Person(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                new Address("Blk 436 Serangoon Gardens Street 26, #16-43"), getReportSet(),
                    getMedHistorySet(), getApptSet(), EMPTY_NRIC, EMPTY_DATE_OF_BIRTH, EMPTY_HEIGHT, EMPTY_WEIGHT,
                    EMPTY_GENDER, EMPTY_BLOODTYPE, EMPTY_OCCUPATION, EMPTY_MARITAL_STATUS,
                    getTagSet("stroke")),
            new Person(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                new Address("Blk 47 Tampines Street 20, #17-35"), getReportSet(),
                    getMedHistorySet(), getApptSet(), EMPTY_NRIC, EMPTY_DATE_OF_BIRTH, EMPTY_HEIGHT, EMPTY_WEIGHT,
                    EMPTY_GENDER, EMPTY_BLOODTYPE, EMPTY_OCCUPATION, EMPTY_MARITAL_STATUS,
                    getTagSet("diabetes")),
            new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                new Address("Blk 45 Aljunied Street 85, #11-31"), getReportSet(),
                    getMedHistorySet(), getApptSet(), EMPTY_NRIC, EMPTY_DATE_OF_BIRTH, EMPTY_HEIGHT, EMPTY_WEIGHT,
                    EMPTY_GENDER, EMPTY_BLOODTYPE, EMPTY_OCCUPATION, EMPTY_MARITAL_STATUS,
                    getTagSet("malaria"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

    /**
     * Returns a medical history set containing the list of medical histories.
     */
    public static Set<MedHistory> getMedHistorySet(MedHistory... medHistories) {
        Set<MedHistory> medHistorySet = new TreeSet<>(new MedHistoryComparator());
        for (MedHistory medHistory : medHistories) {
            medHistorySet.add(medHistory);
        }
        return medHistorySet;
    }

    /**
     * Returns a report set containing the list of reports given.
     */
    // TODO: (MedicalReport) MIGHT CONVERT TO USE STREAM IN FUTURE
    public static Set<MedicalReport> getReportSet(MedicalReport ... reports) {
        Set<MedicalReport> reportSet = new TreeSet<>(new ReportComparator());
        for (MedicalReport report : reports) {
            reportSet.add(report);
        }
        return reportSet;
    }

    //@@author brandonccm1996
    /**
     * Returns an appt set containing the list of appts given.
     */
    // TODO: (Appt) MIGHT CONVERT TO USE STREAM IN FUTURE
    public static Set<Appt> getApptSet(Appt... appts) {
        Set<Appt> apptSet = new TreeSet<>(new ApptComparator());
        for (Appt appt : appts) {
            apptSet.add(appt);
        }
        return apptSet;
    }
}
