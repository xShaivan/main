package guitests.guihandles;

import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableMultiset;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import seedu.address.model.person.Person;

/**
 * Provides a handle to a person card in the person list panel.
 */
public class PersonCardHandle extends NodeHandle<Node> {
    private static final String ID_FIELD_ID = "#id";
    private static final String NAME_FIELD_ID = "#name";
    private static final String ADDRESS_FIELD_ID = "#address";
    private static final String PHONE_FIELD_ID = "#phone";
    private static final String EMAIL_FIELD_ID = "#email";
    private static final String NRIC_FIELD_ID = "#nric";
    private static final String MEDICAL_REPORT_FIELD_ID = "#medicalreport";
    private static final String MEDHISTORY_FIELD_ID = "#medHistories";
    private static final String APPT_FIELD_ID = "#appt";
    private static final String TAGS_FIELD_ID = "#tags";

    private final Label idLabel;
    private final Label nameLabel;
    private final Label addressLabel;
    private final Label phoneLabel;
    private final Label emailLabel;
    private final Label nricLabel;
    private final Label medicalReportLabel;
    private final List<Label> medHistoryLabel;
    private final Label apptLabel;
    private final List<Label> tagLabels;

    public PersonCardHandle(Node cardNode) {
        super(cardNode);

        idLabel = getChildNode(ID_FIELD_ID);
        nameLabel = getChildNode(NAME_FIELD_ID);
        addressLabel = getChildNode(ADDRESS_FIELD_ID);
        phoneLabel = getChildNode(PHONE_FIELD_ID);
        emailLabel = getChildNode(EMAIL_FIELD_ID);
        nricLabel = getChildNode(NRIC_FIELD_ID);
        medicalReportLabel = getChildNode(MEDICAL_REPORT_FIELD_ID);

        Region medHistoriesContainer = getChildNode(MEDHISTORY_FIELD_ID);
        medHistoryLabel = medHistoriesContainer.getChildrenUnmodifiable().stream()
                .map(Label.class::cast).collect(Collectors.toList());

        apptLabel = getChildNode(APPT_FIELD_ID);

        Region tagsContainer = getChildNode(TAGS_FIELD_ID);
        tagLabels = tagsContainer
                .getChildrenUnmodifiable()
                .stream()
                .map(Label.class::cast)
                .collect(Collectors.toList());
    }

    public String getId() {
        return idLabel.getText();
    }

    public String getName() {
        return nameLabel.getText();
    }

    public String getAddress() {
        return addressLabel.getText();
    }

    public String getPhone() {
        return phoneLabel.getText();
    }

    public String getEmail() {
        return emailLabel.getText();
    }

    public String getNric() {
        return nricLabel.getText();
    }

    public String getMedicalReport() {
        return medicalReportLabel.getText();
    }

    public List<String> getMedHistory() {
        return medHistoryLabel.stream().map(Label::getText).collect(Collectors.toList());
    }

    public String getAppt() {
        return apptLabel.getText();
    }

    public List<String> getTags() {
        return tagLabels
                .stream()
                .map(Label::getText)
                .collect(Collectors.toList());
    }

    /**
     * Returns true if this handle contains {@code person}.
     */
    public boolean equals(Person person) {
        return getName().equals(person.getName().fullName)
                && getAddress().equals(person.getAddress().value)
                && getPhone().equals(person.getPhone().value)
                && getEmail().equals(person.getEmail().value)
                && ImmutableMultiset.copyOf(getTags()).equals(ImmutableMultiset.copyOf(person.getTags().stream()
                        .map(tag -> tag.tagName)
                        .collect(Collectors.toList())))
                && ImmutableMultiset.copyOf(getMedHistory()
                .equals(ImmutableMultiset.copyOf(person.getMedHistory().stream()
                        .map(medHistory -> medHistory.toString()).collect(Collectors.toList()))));
    }
}
