package com.airtribe.learntrack.util;

public class Validator {

    public static boolean validateString(String name) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            return false;
        }
        return true;
    }

    public static boolean validateEmail(String email) {
        boolean isValid = false;
        if (!Validator.validateString(email)) {
            return false;
        }
        if (email.contains("@") && email.contains(".")) {
            isValid = true;
        }
        return isValid;
    }
}
