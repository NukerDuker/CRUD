package com.example.userAPI.model;

import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String login;
    private String password;
    private String birth;
    private String phone;
    private String tg;
    private String email;

    public User() {}

    public User(String name, String login, String password, String birth, String phone) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.birth = birth;
        this.phone = phone;
    }

    public User(String name, String login, String password, String birth, String phone, String tg, String email) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.birth = birth;
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

    public String getBirth() {
        return birth;
    }

    public void setBirth(String date) {
        this.birth = date;
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
