package com.anand.model;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
public class UpdatePersonalRequest {
    @NotNull(message = "name cannot be null")
    private String name;

    @NotNull(message = "email cannot be null")
    private String email;

    @NotNull(message = "phone cannot be null")
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
