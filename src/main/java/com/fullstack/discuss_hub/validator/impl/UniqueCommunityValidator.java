package com.fullstack.discuss_hub.validator.impl;

import com.fullstack.discuss_hub.feature.community.repository.CommunityRepository;
import com.fullstack.discuss_hub.validator.UniqueCommunityValid;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UniqueCommunityValidator implements ConstraintValidator<UniqueCommunityValid, String> {

    private final CommunityRepository communityRepository;

    @Override
    public void initialize(UniqueCommunityValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        return communityRepository.findByCommunityName(name).isEmpty();
    }
}
