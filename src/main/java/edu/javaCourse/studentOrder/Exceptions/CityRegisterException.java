package edu.javaCourse.studentOrder.Exceptions;

public class CityRegisterException extends Exception{

    private String errorCode;

    public CityRegisterException(String s){
    }

    public CityRegisterException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public CityRegisterException(String message, Throwable cause, String errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
