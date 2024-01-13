package edu.javaCourse.studentOrder.domian;

public class RegisterOffice {
    private long registerId;
    private String registerAreaId;
    private String registerName;


    public RegisterOffice() {
    }

    public RegisterOffice(long registerId, String registerAreaId, String registerName) {
        this.registerId = registerId;
        this.registerAreaId = registerAreaId;
        this.registerName = registerName;
    }

    public long getRegisterId() {
        return registerId;
    }

    public void setRegisterId(long registerId) {
        this.registerId = registerId;
    }

    public String getRegisterAreaId() {
        return registerAreaId;
    }

    public void setRegisterAreaId(String registerAreaId) {
        this.registerAreaId = registerAreaId;
    }

    public String getRegisterName() {
        return registerName;
    }

    public void setRegisterName(String registerName) {
        this.registerName = registerName;
    }
}
