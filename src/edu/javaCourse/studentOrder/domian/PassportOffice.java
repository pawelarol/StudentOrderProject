package edu.javaCourse.studentOrder.domian;

public class PassportOffice {
    private long pOfficeId;
    private String pOfficeAreaId;
    private String pOfficeName;

    public PassportOffice() {
    }

    public PassportOffice(long pOfficeId, String pOfficeAreaId, String pOfficeName) {
        this.pOfficeId = pOfficeId;
        this.pOfficeAreaId = pOfficeAreaId;
        this.pOfficeName = pOfficeName;
    }

    public long getpOfficeId() {
        return pOfficeId;
    }

    public void setpOfficeId(long pOfficeId) {
        this.pOfficeId = pOfficeId;
    }

    public String getpOfficeAreaId() {
        return pOfficeAreaId;
    }

    public void setpOfficeAreaId(String pOfficeAreaId) {
        this.pOfficeAreaId = pOfficeAreaId;
    }

    public String getpOfficeName() {
        return pOfficeName;
    }

    public void setpOfficeName(String pOfficeName) {
        this.pOfficeName = pOfficeName;
    }
}
