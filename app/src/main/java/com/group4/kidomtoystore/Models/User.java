package com.group4.kidomtoystore.Models;

import java.util.Date;

public class User {
    String phoneNumb;
    String email;
    String dob;
    String gender;

    public User(String phoneNumb, String email, String dob, String gender) {
        this.phoneNumb = phoneNumb;
        this.email = email;
        this.dob = dob;
        this.gender = gender;
    }

    public String getPhoneNumb() {
        return phoneNumb;
    }

    public void setPhoneNumb(String phoneNumb) {
        this.phoneNumb = phoneNumb;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
