package seedu.address.ui;

import java.net.URL;
import java.util.logging.Logger;

import com.google.common.eventbus.Subscribe;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;
import javafx.scene.web.WebView;
import seedu.address.MainApp;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.events.ui.PersonPanelSelectionChangedEvent;
import seedu.address.model.person.Person;

/**
 * The Browser Panel of the App.
 */
public class BrowserPanel extends UiPart<Region> {

    private static final String FXML = "BrowserPanel.fxml";
    private Person person;

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

        initialiseNameLabels(person.getName().toString());
        fillAnchorPanes(person);
    }

    private void initialiseNameLabels(String name) {
        nameLabel1.setText("Additional Info for " + name);
        nameLabel2.setText("Medical History for " + name);
        nameLabel3.setText("Appt Timetable for " + name);
        nameLabel4.setText("Medical Reports for " + name);
    }

    private void fillAnchorPanes(Person person) {
        nricLabel.setText(person.getNric().value);
        person.getMedHistory().forEach(medHistory -> medHistoriesFlowPane.getChildren().add(new Label(medHistory.toString())));
        person.getMedicalReports().forEach(report -> medReportsFlowPane.getChildren().add(new Label(report.toString())));
        person.getAppts().forEach(appt -> apptsFlowPane.getChildren().add(new Label(appt.toString())));
    }

    public void clearFlowPanes() {
        medHistoriesFlowPane.getChildren().clear();
        medReportsFlowPane.getChildren().clear();
        apptsFlowPane.getChildren().clear();
    }
}
