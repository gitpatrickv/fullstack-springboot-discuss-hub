package com.fullstack.discuss_hub.validator;

import com.fullstack.discuss_hub.validator.impl.PasswordLengthValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@Target({FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordLengthValidator.class)
public @interface PasswordLengthValid {
    String message() default "{password.required}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
