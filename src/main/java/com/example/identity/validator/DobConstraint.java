package com.example.identity.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
        validatedBy = {DobValidator.class}
)
public @interface DobConstraint {
    String message() default "Invalid Dob";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int min();
}
