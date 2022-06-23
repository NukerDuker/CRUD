package com.example.userAPI.utils;

import com.example.userAPI.model.User;
import com.example.userAPI.validators.*;
import com.google.gson.Gson;

public class CheckValid {
    private String json;
    private Gson gson = new Gson();
    private User user;

    public CheckValid(User user) {
        this.user = user;
    }

    public String getJson() {
        return json;
    }

    private boolean isInValid(Validator validator, String forValidation) {
        return !validator.validate(forValidation);
    }

    public boolean fullCheck() {
        if (user.getPhone() != null && !user.getPhone().isBlank()) {
            if (isInValid(new PhoneValidator(), user.getPhone())) {
                json = gson.toJson(JsonResponse.getResponse("N7", "Введен некорректный номер телефона."));
                return false;
            }
        }
        if (user.getEmail() != null && !user.getEmail().isBlank()) {
            if (isInValid(new EmailValidator(), user.getEmail())) {
                json = gson.toJson(JsonResponse.getResponse("N6", "Введена некорректная почта."));
                return false;
            }
        }
        if (user.getPassword() != null && !user.getPassword().isBlank()) {
            if (isInValid(new PasswordValidator(), user.getPassword())) {
                json = gson.toJson(JsonResponse.getResponse("N5", "Пароль должен содержать хотя бы одно число, специсмвол, латинскую букву в верхнем и нижнем регистре и быть не короче 6 символов."));
                return false;
            }
        }
        if (user.getTg() != null && !user.getTg().isBlank()) {
            if (isInValid(new TgValidator(), user.getTg())) {
                json = gson.toJson(JsonResponse.getResponse("N4", "tg Должен начинаться с символа @." + user.getTg()));
                return false;
            }
        }
        return true;
    }

}
