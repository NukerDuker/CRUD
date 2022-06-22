package com.example.userAPI.utils;

import java.util.HashMap;
import java.util.Map;

public class JsonResponse {
    private static Map<String, String> response = new HashMap<>();

    public static Map<String, String> getResponse(String code, String text) {
        response.put("code", code);
        response.put("text", text);
        return response;
    }
}
