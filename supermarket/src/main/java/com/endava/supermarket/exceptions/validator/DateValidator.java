package com.endava.supermarket.exceptions.validator;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateValidator implements ConstraintValidator<ValidDate, String> {

    private static final String DATE_PATTERN = "yyyy-MM-dd";

    @Override
    public boolean isValid(String customDateField, ConstraintValidatorContext context) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
        sdf.setLenient(false);
        try {
            LocalDate.parse(customDateField);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }
}
