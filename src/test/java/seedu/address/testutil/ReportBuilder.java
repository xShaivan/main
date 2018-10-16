package seedu.address.testutil;

import seedu.address.model.medicalreport.ReportDate;
import seedu.address.model.medicalreport.Information;
import seedu.address.model.medicalreport.MedicalReport;
import seedu.address.model.medicalreport.Title;

/**
 * A utility class to help with building Report objects.
 */
public class ReportBuilder {
    public static final String DEFAULT_TITLE = "Asthma";
    public static final String DEFAULT_DATE = "01/01/2018";
    public static final String DEFAULT_INFO = "Prescribed XXX medicine, next appointment on 02022018";

    private Title title;
    private ReportDate reportDate;
    private Information information;

    public ReportBuilder() {
        title = new Title(DEFAULT_TITLE);
        reportDate = new ReportDate(DEFAULT_DATE);
        information = new Information(DEFAULT_INFO);
    }
    /**
     * Initializes the ReportBuilder with the data of {@code reportToCopy}.
     */
    public ReportBuilder(MedicalReport reportToCopy) {
        title = reportToCopy.getTitle();
        reportDate = reportToCopy.getReportDate();
        information = reportToCopy.getInformation();
    }
    /**
     * Sets the {@code Title} of the {@code MedicalReport} that we are building.
     */
    public ReportBuilder withTitle(String title) {
        this.title = new Title(title);
        return this;
    }
    /**
     * Sets the {@code ReportDate} of the {@code MedicalReport} that we are building.
     */
    public ReportBuilder withDate(String date) {
        this.reportDate = new ReportDate(date);
        return this;
    }
    /**
     * Sets the {@code Information} of the {@code MedicalReport} that we are building.
     */
    public ReportBuilder withInformation(String information) {
        this.information = new Information(information);
        return this;
    }

    public MedicalReport build() {
        return new MedicalReport(title, reportDate, information);
    }
}
