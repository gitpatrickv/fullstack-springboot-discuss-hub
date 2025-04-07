package com.fullstack.discuss_hub.validator;

import com.fullstack.discuss_hub.validator.impl.UniqueCommunityValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@Target({FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueCommunityValidator.class)
public @interface UniqueCommunityValid {

    String message() default "{community.exist}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
