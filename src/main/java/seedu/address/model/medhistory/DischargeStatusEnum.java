package seedu.address.model.medhistory;

public enum DischargeStatusEnum {
    d("discharged"), a("admitted"), e("expired");

    private String code;

    DischargeStatusEnum(String enumCode) {
        this.code = enumCode;
    }

    public String getCode() {
        return this.code;
    }
}
