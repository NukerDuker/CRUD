package com.example.userAPI.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator implements Validator{
    private static final Pattern PATTERN = Pattern.compile("(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,}");

    @Override
    public boolean validate(String pass) {
        Matcher matcher = PATTERN.matcher(pass);
        return matcher.matches();
    }
}
