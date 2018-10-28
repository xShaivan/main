package seedu.address.ui;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;

import seedu.address.model.timetable.Appt;

public class ApptCard extends AnchorPane {
    private final Appt appt;

    @FXML
    private Label apptStart;
    @FXML
    private Label apptEnd;
    @FXML
    private Label apptVenue;
    @FXML
    private Label apptInfo;
    @FXML
    private Label apptDrName;

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
        apptStart.setText(appt.getStart().toString());
        apptEnd.setText(appt.getEnd().toString());
        apptVenue.setText(appt.getVenue().toString());
        apptInfo.setText(appt.getInfo().toString());
        apptDrName.setText(appt.getDrName().toString());
    }
}
