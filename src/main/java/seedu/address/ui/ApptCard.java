package seedu.address.ui;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;

import javafx.scene.layout.StackPane;
import seedu.address.model.timetable.Appt;

//@@author brandonccm1996
public class ApptCard extends StackPane {
    private final Appt appt;

    @FXML
    private Label apptDetails;
    @FXML
    private Label apptInfo;

    public ApptCard(Appt appt) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/view/ApptCard.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        this.appt = appt;
        apptDetails.setText(appt.getStart().toString() + " TO " + appt.getEnd().toString()
                + " @ " + appt.getVenue().toString() + " by " + appt.getDrName().toString());
        apptInfo.setText(appt.getInfo().toString());
    }
}
