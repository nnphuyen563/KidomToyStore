package com.group4.kidomtoystore.Models;

import java.util.Date;

public class User {
    Integer avatar;
    String fullName;
    String phoneNumb;
    String email;
    Date dob;
    String gender;
    String password;

    public User(Integer avatar, String fullName, String phoneNumb, String email, Date dob, String gender, String password) {
        this.avatar = avatar;
        this.fullName = fullName;
        this.phoneNumb = phoneNumb;
        this.email = email;
        this.dob = dob;
        this.gender = gender;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAvatar() {
        return avatar;
    }

    public void setAvatar(Integer avatar) {
        this.avatar = avatar;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
