package com.company.oop.agency.utils;

import com.company.oop.agency.exceptions.InvalidUserInputException;

import java.util.List;

public class ValidationHelper {

    public static final String INVALID_NUMBER_OF_ARGUMENTS = "Invalid number of arguments. Expected: %d, Received: %d";
    private static final int NEGATIVE_NUMBER = 0;
    private static final String NEGATIVE_INT_ERROR = "Value of '%s' must be a positive number. Actual value: %.2f.";

    public static void validateValueInRange(double value, double min, double max, String errorMessage) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void validateStringLength(String stringToValidate, int minLength, int maxLength, String errorMessage) {
        validateValueInRange(stringToValidate.length(), minLength, maxLength, errorMessage);
    }

    public static void validateArgumentsCount(List<String> list, int expectedArgumentsCount) {
        if (list.size() < expectedArgumentsCount || list.size() > expectedArgumentsCount) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_OF_ARGUMENTS, expectedArgumentsCount, list.size()));
        }
    }

    public static void validatePositiveDouble(double value, String type) {
        if (value < NEGATIVE_NUMBER) {
            throw new InvalidUserInputException(String.format(NEGATIVE_INT_ERROR, type, value));
        }
    }

}