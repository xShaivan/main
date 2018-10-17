package seedu.address.testutil;

import seedu.address.logic.commands.AddInfoCommand.AddInfoPersonDescriptor;
import seedu.address.model.person.DateOfBirth;
import seedu.address.model.person.Nric;
import seedu.address.model.person.Person;

public class AddInfoPersonDescriptorBuilder {
    private AddInfoPersonDescriptor descriptor;

    public AddInfoPersonDescriptorBuilder() {
        descriptor = new AddInfoPersonDescriptor();
    }

    public AddInfoPersonDescriptorBuilder(AddInfoPersonDescriptor descriptor) {
        this.descriptor = new AddInfoPersonDescriptor(descriptor);
    }

    public AddInfoPersonDescriptorBuilder(Person person) {
        descriptor = new AddInfoPersonDescriptor();
        descriptor.setDateOfBirth(person.getDateOfBirth());
        descriptor.setNric(person.getNric());
    }

    public AddInfoPersonDescriptorBuilder withDateOfBirth(String dateOfBirth) {
        descriptor.setDateOfBirth(new DateOfBirth(dateOfBirth));
        return this;
    }

    public AddInfoPersonDescriptorBuilder withNric(String nric) {
        descriptor.setNric(new Nric(nric));
        return this;
    }

    public AddInfoPersonDescriptor build() {
        return descriptor;
    }
}
