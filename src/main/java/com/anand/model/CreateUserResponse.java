package com.anand.model;

public class CreateUserResponse {
    private String message;
    private Boolean isUserCreated;

    public CreateUserResponse(String message, Boolean isUserCreated) {
        this.message = message;
        this.isUserCreated = isUserCreated;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getUserCreated() {
        return isUserCreated;
    }

    public void setUserCreated(Boolean userCreated) {
        isUserCreated = userCreated;
    }
}
