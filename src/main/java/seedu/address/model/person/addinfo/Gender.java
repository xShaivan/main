package seedu.address.model.person.addinfo;

import static java.util.Objects.requireNonNull;

public class Gender {
    public static final String GENDER_VALIDATION_REGEX = "[MF]";
    public static final String MESSAGE_GENDER_CONSTRAINTS = "Gender input can only be either M or F.";

    public final String value;

    public Gender(String gender) {
        requireNonNull(gender);
        gender.toUpperCase();
        value = gender;
    }

    public static boolean isValidGender(String test) {
        return test.matches(GENDER_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof Gender && value.equals(((Gender) other).value));
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
