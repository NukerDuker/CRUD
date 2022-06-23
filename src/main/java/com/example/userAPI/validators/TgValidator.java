package com.example.userAPI.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TgValidator implements Validator{

    private static final Pattern PATTERN = Pattern.compile("^@[A-Z0-9]{5,32}", Pattern.CASE_INSENSITIVE);

    @Override
    public boolean validate(String tg) {
        Matcher matcher = PATTERN.matcher(tg);
        return matcher.matches();
    }
}
