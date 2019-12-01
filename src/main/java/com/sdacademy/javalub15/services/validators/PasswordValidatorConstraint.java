package com.sdacademy.javalub15.services.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidatorConstraint implements ConstraintValidator<PasswordValidator, String>{

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        // TODO: 01.12.2019 password (3, 10) and have digit
        return false;
    }
}
