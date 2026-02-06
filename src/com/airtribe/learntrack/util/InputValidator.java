package com.airtribe.learntrack.util;

public class InputValidator {

    // Check if string is not null or empty
    public static boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

    // Check if a number is positive
    public static boolean isPositive(int num) {
        return num > 0;
    }
    // Basic email validation
    public static boolean isValidEmail(String email) {
        if (email == null) return false;
        return email.contains("@") && email.contains(".");
    }

    // Validate menu choice range
    public static boolean isInRange(int choice, int min, int max) {
        return choice >= min && choice <= max;
    }

    // Convert String to int safely
    public static int parseIntSafe(String value) throws NumberFormatException {
        return Integer.parseInt(value.trim());
    }
}

