package seedu.address.testutil;

import seedu.address.logic.commands.AddInfoCommand.AddInfoPersonDescriptor;
import seedu.address.model.person.Person;
import seedu.address.model.person.addinfo.BloodType;
import seedu.address.model.person.addinfo.DateOfBirth;
import seedu.address.model.person.addinfo.Gender;
import seedu.address.model.person.addinfo.Height;
import seedu.address.model.person.addinfo.MaritalStatus;
import seedu.address.model.person.addinfo.Nric;
import seedu.address.model.person.addinfo.Occupation;
import seedu.address.model.person.addinfo.Weight;

/**
 * A unity class to help with building AddInfoPersonDescriptor objects.
 */
public class AddInfoPersonDescriptorBuilder {
    private AddInfoPersonDescriptor descriptor;

    public AddInfoPersonDescriptorBuilder() {
        descriptor = new AddInfoPersonDescriptor();
    }

    public AddInfoPersonDescriptorBuilder(AddInfoPersonDescriptor descriptor) {
        this.descriptor = new AddInfoPersonDescriptor(descriptor);
    }

    /**
     * Returns an {@code AddInfoPersonDescriptor} with fields containing {@code person}'s details
     */
    public AddInfoPersonDescriptorBuilder(Person person) {
        descriptor = new AddInfoPersonDescriptor();
        descriptor.setDateOfBirth(person.getDateOfBirth());
        descriptor.setNric(person.getNric());
    }

    /**
     * Sets the {@code dateOfBirth} of the {@code AddInfoPersonDescriptor} that we are building.
     */
    public AddInfoPersonDescriptorBuilder withDateOfBirth(String dateOfBirth) {
        descriptor.setDateOfBirth(new DateOfBirth(dateOfBirth));
        return this;
    }

    /**
     * Sets the {@code nric} of the {@code AddInfoPersonDescriptor} that we are building.
     */
    public AddInfoPersonDescriptorBuilder withNric(String nric) {
        descriptor.setNric(new Nric(nric));
        return this;
    }

    public AddInfoPersonDescriptorBuilder withHeight(String height) {
        descriptor.setHeight(new Height(height));
        return this;
    }

    public AddInfoPersonDescriptorBuilder withWeight(String weight) {
        descriptor.setWeight(new Weight(weight));
        return this;
    }

    public AddInfoPersonDescriptorBuilder withGender(String gender) {
        descriptor.setGender(new Gender(gender));
        return this;
    }

    public AddInfoPersonDescriptorBuilder withBloodType(String bloodType) {
        descriptor.setBloodType(new BloodType(bloodType));
        return this;
    }

    public AddInfoPersonDescriptorBuilder withOccupation(String occupation) {
        descriptor.setOccupation(new Occupation(occupation));
        return this;
    }

    public AddInfoPersonDescriptorBuilder withMaritalStatus(String maritalStatus) {
        descriptor.setMaritalStatus(new MaritalStatus(maritalStatus));
        return this;
    }

    public AddInfoPersonDescriptor build() {
        return descriptor;
    }
}
