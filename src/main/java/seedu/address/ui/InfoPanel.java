package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;

import seedu.address.model.person.Person;

/**
 * The Info Panel of the App.
 */
public class InfoPanel extends UiPart<Region> {
    private static final String FXML = "InfoPanel.fxml";
    private Person person;

    @FXML
    private ScrollPane infoScrollPane;
    @FXML
    private AnchorPane additionalInfo;
    @FXML
    private AnchorPane medHistory;
    @FXML
    private AnchorPane medAppts;
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

    public InfoPanel() {
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
        additionalInfo.setStyle("-fx-background-color: #FCFCFC");
        nricLabel.setText(person.getNric().value);
    }

    private void fillMedHistoriesPane() {
        medHistory.setStyle("-fx-background-color: #ECECEC");
        person.getMedHistory().forEach(medHistory ->
                medHistoriesFlowPane.getChildren().add(new Label(medHistory.toString())));
    }

    private void fillApptsPane() {
        medAppts.setStyle("-fx-background-color: #DCDCDC");
        person.getAppts().forEach(appt -> apptsFlowPane.getChildren().add(new ApptCard(appt)));
    }

    private void fillMedReportsPane() {
        medReports.setStyle("-fx-background-color: #CCCCCC");
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

    /**
     * Shows a message when there is no person card selected to tell the user to select a person
     */
    public void showEmptyMessage() {
        additionalInfo.setStyle("-fx-background-color: #FFFFFF");
        medHistory.setStyle("-fx-background-color: #FFFFFF");
        medAppts.setStyle("-fx-background-color: #FFFFFF");
        medReports.setStyle("-fx-background-color: #FFFFFF");
        nameLabel1.setText("You have not selected any person.\n"
                + "Please select a person to show more details\nfor him/her on this panel.");
        nameLabel2.setText("");
        nameLabel3.setText("");
        nameLabel4.setText("");
        nricLabel.setText("");
    }
}
