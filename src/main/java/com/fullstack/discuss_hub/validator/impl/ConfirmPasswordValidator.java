package com.fullstack.discuss_hub.validator.impl;

import com.fullstack.discuss_hub.feature.user.model.UserModel;
import com.fullstack.discuss_hub.validator.ConfirmPasswordValid;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ConfirmPasswordValidator implements ConstraintValidator<ConfirmPasswordValid, UserModel> {
    @Override
    public void initialize(ConfirmPasswordValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserModel userModel, ConstraintValidatorContext constraintValidatorContext) {
        if(userModel == null || userModel.getPassword() == null || userModel.getConfirmPassword() == null){
            return false;
        }

        return userModel.getPassword().equals(userModel.getConfirmPassword());
    }
}