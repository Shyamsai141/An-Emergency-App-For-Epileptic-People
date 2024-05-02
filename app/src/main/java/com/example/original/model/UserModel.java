package com.example.original.model;

public class UserModel {
    private String email;
    private String name;
    private String dob;
    private String mobile;

    public UserModel() {
    }

    public UserModel(String email, String name, String dob, String mobile) {
        this.email = email;
        this.name = name;
        this.dob = dob;
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
