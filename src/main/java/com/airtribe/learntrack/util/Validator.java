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

    public static boolean validateNumber(String durationInWeeks) {
        boolean isValid = false;
        try {
            Integer durationInWeek = Integer.parseInt(durationInWeeks);
            isValid = true;
        } catch (NumberFormatException e) {
            System.out.print("Please enter the valid number for duration in weeks.");
        }
        return isValid;
    }
}
