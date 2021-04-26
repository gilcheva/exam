package com.endava.supermarket.exceptions.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FullNameValidator implements ConstraintValidator<ValidFullName, String> {

    private static final String LATIN_ALPHABET = "^[a-zA-Z -]*+";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value != null) {
            if (value.length() < 3) {
                return provideCustomMessageForConstraint(context, "The name is too short");
            }

            if (!value.matches(LATIN_ALPHABET)) {
                return provideCustomMessageForConstraint(context, "Only latin characters and '-' are accepted.");
            }

            String[] names = value.split(" ");
            if (names.length == 1) {
                return provideCustomMessageForConstraint(context, "Mononymous names are not accepted.");
            }

            if (!Character.isUpperCase(names[0].charAt(0)) || !Character.isUpperCase((names[1].charAt(0)))) {
                return provideCustomMessageForConstraint(context, "The names should be with capital first letters.");
            }
        }
        return true;
    }

    private boolean provideCustomMessageForConstraint(ConstraintValidatorContext context, String message) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation();
        return false;
    }
}
