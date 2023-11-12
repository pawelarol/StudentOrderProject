package edu.javaCourse.studentOrder.intermediares;

public class CityRegisterIntermediaries {
   private boolean exists;
   private Boolean statusResident;

    public boolean isExists() {
        return exists;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }

    public Boolean getStatusResident() {
        return statusResident;
    }

    public void setStatusResident(Boolean statusResident) {
        this.statusResident = statusResident;
    }

    @Override
    public String toString() {
        return "CityRegisterIntermediaries{" +
                "exists=" + exists +
                ", statusResident=" + statusResident +
                '}';
    }
}
