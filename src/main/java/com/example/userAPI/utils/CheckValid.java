package com.example.userAPI.utils;

import com.example.userAPI.validators.Validator;

public class CheckValid {


    public static boolean CheckValid(Validator validator, String forValidation) {
        return validator.validate(forValidation);
    }
}
