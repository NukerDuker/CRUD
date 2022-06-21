package com.example.userAPI.validators;

public class CheckValid {


    public static boolean CheckValid(Validator validator, String forValidation) {
        return validator.validate(forValidation);
    }
}
