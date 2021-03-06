package com.example.userAPI.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;


public class User {

    private Integer id;

    private String name;

    private String login;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private Date birthDate;

    private String phone;

    private String tg;

    private String email;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(String name, String login, String password, String phone, Date birthDate) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.birthDate = birthDate;
        this.phone = phone;
    }

    public User(String name, String login, String password, String phone, Date birthDate, String tg, String email) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.birthDate = birthDate;
        this.phone = phone;
        this.tg = tg;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = Date.valueOf(birthDate);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTg() {
        return tg;
    }

    public void setTg(String tg) {
        this.tg = tg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
