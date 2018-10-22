package seedu.address.ui;

import java.net.URL;
import java.util.logging.Logger;

import com.google.common.eventbus.Subscribe;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
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

    public BrowserPanel() {
        super(FXML);
    }

    public void setPerson(Person person) {
        this.person = person;

        initialiseNameLabels(person.getName().toString());
    }

    public void initialiseNameLabels(String name) {
        nameLabel1.setText("Additional Info for " + name + "\n" + "a" + "\n" + "a" + "\n" + "a" + "\n" + "a" + "\n" + "a" + "\n" + "a" + "\n" + "a");
        nameLabel2.setText("Medical History for " + name + "\n" + "a" + "\n" + "a" + "\n" + "a" + "\n" + "a" + "\n" + "a" + "\n" + "a" + "\n" + "a");
        nameLabel3.setText("Appt Timetable for " + name + "\n" + "a" + "\n" + "a" + "\n" + "a" + "\n" + "a" + "\n" + "a" + "\n" + "a" + "\n" + "a");
        nameLabel4.setText("Medical Reports for " + name + "\n" + "a" + "\n" + "a" + "\n" + "a" + "\n" + "a" + "\n" + "a" + "\n" + "a" + "\n" + "a");
    }

}
