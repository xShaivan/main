package seedu.address.model.medicalreport;

import static java.util.Objects.requireNonNull;

public class MedicalReport {

    public final String value;

    public MedicalReport(String report) {
        requireNonNull(report);
        value = report;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof MedicalReport // instanceof handles nulls
                && value.equals(((MedicalReport) other).value)); // state check
    }
    @Override
    public int hashCode() {
        return value.hashCode();
    }

    /**
    //Data fields
    public final Title title;
    public final Date date;
    public final MedicalReportInformation information;

    public MedicalReport(Title title, Date date, MedicalReportInformation information) {
        requireAllNonNull(title, date, information);
        this.title = title;
        this.date = date;
        this.information = information;
    }

    public Title getTitle(){ return title; }

    public Date getDate() {
        return date;
    }

    public MedicalReportInformation getInformation() {
        return information;
    }

    /**
     * Returns true if both medical reports have at least one other data field that is the same.
     * This defines a weaker notion of equality between two medical reports

    public boolean isSameMedicalReport(MedicalReport otherMedicalReport) {
        if (otherMedicalReport == this) {
            return true;
        }

        return otherMedicalReport != null
                && otherMedicalReport.getTitle().equals(getTitle())
                && (otherMedicalReport.getDate().equals(getDate()) || otherMedicalReport.getInformation().equals(getInformation()));
    }

    /**
     * Returns true if both medical reports have the same data fields.
     * This defines a stronger notion of equality between two medical reports.

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof MedicalReport)) {
            return false;
        }

        MedicalReport otherMedicalReport = (MedicalReport) other;
        return otherMedicalReport.getTitle().equals(getTitle())
                && otherMedicalReport.getDate().equals(getDate())
                && otherMedicalReport.getInformation().equals(getInformation());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(title, date, information);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getTitle())
                .append(" Title: ")
                .append(getDate())
                .append(" Date: ")
                .append(getInformation())
                .append(" Information: ");
        return builder.toString();
    }
    */
}
