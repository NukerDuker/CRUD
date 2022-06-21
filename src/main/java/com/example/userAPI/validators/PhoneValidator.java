package com.example.userAPI.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidator implements Validator {

    private static final Pattern PATTERN = Pattern.compile("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");


    @Override
    public boolean validate(String phone) {
        Matcher matcher = PATTERN.matcher(phone);
        return matcher.matches();
    }
}
