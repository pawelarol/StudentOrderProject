package edu.javaCourse.studentOrder.domian;

public class University {
    private Long universityId;
    private String universityName;

    public University() {
    }

    public University(long universityId, String studentID) {
        this.universityId = universityId;
        this.universityName = studentID;
    }

    public long getUniversityId() {
        return universityId;
    }

    public void setUniversityId(long universityId) {
        this.universityId = universityId;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
}
