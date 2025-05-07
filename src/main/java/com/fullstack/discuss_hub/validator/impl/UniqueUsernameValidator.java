package com.fullstack.discuss_hub.validator.impl;

import com.fullstack.discuss_hub.feature.user.repository.UserRepository;
import com.fullstack.discuss_hub.validator.UniqueUsernameValid;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsernameValid, String> {

    private final UserRepository userRepository;

    @Override
    public void initialize(UniqueUsernameValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        return userRepository.findByUsername(username).isEmpty();
    }
}
