package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;

import seedu.address.model.person.Person;

/**
 * The Browser Panel of the App.
 */
public class BrowserPanel extends UiPart<Region> {

    private static final String FXML = "BrowserPanel.fxml";
    private Person person;

    @FXML
    private ScrollPane browser;
    @FXML
    private AnchorPane additionalInfo;
    @FXML
    private AnchorPane medHistory;
    @FXML
    private AnchorPane appts;
    @FXML
    private AnchorPane medReports;

    @FXML
    private Label nameLabel1;
    @FXML
    private Label nameLabel2;
    @FXML
    private Label nameLabel3;
    @FXML
    private Label nameLabel4;

    @FXML
    private Label nricLabel;
    @FXML
    private FlowPane medHistoriesFlowPane;
    @FXML
    private FlowPane apptsFlowPane;
    @FXML
    private FlowPane medReportsFlowPane;

    public BrowserPanel() {
        super(FXML);
    }

    public void setPerson(Person person) {
        this.person = person;

        initialiseNameLabels();
        fillAdditionalInfoPane();
        fillMedHistoriesPane();
        fillApptsPane();
        fillMedReportsPane();
    }

    /**
     * Initialises the name labels in all anchor panes
     */
    private void initialiseNameLabels() {
        nameLabel1.setText("Additional Info for " + person.getName());
        nameLabel2.setText("Medical History for " + person.getName());
        nameLabel3.setText("Appt Timetable for " + person.getName());
        nameLabel4.setText("Medical Reports for " + person.getName());
    }

    private void fillAdditionalInfoPane() {
        nricLabel.setText(person.getNric().value);
    }

    private void fillMedHistoriesPane() {
        person.getMedHistory().forEach(medHistory ->
                medHistoriesFlowPane.getChildren().add(new Label(medHistory.toString())));
    }

    private void fillApptsPane() {
        person.getAppts().forEach(appt -> apptsFlowPane.getChildren().add(new Label(appt.toString())));
    }

    private void fillMedReportsPane() {
        person.getMedicalReports().forEach(report ->
                medReportsFlowPane.getChildren().add(new Label(report.toString())));
    }

    /**
     * Empties flowpanes in all anchorpanes
     */
    public void clearFlowPanes() {
        medHistoriesFlowPane.getChildren().clear();
        medReportsFlowPane.getChildren().clear();
        apptsFlowPane.getChildren().clear();
    }
}
