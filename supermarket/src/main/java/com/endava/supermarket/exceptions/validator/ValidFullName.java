package com.endava.supermarket.exceptions.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = FullNameValidator.class)
@Documented
public @interface ValidFullName {
    String message() default "Invalid full name.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
