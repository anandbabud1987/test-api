package com.anand.model;

public class UpdatePersonalInfoResponse {
    private String message;
    private Boolean isUserUpdated;

    public UpdatePersonalInfoResponse(String message, Boolean isUserUpdated) {
        this.message = message;
        this.isUserUpdated = isUserUpdated;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getUserCreated() {
        return isUserUpdated;
    }

    public void setUserCreated(Boolean userCreated) {
        isUserUpdated = userCreated;
    }
}
