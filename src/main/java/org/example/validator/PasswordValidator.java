package org.example.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.controller.dto.UserDTO;

public class PasswordValidator implements ConstraintValidator<PasswordValid, UserDTO> {

    @Override
    public boolean isValid(UserDTO user, ConstraintValidatorContext context) {
        return user.getPassword1().equals(user.getPassword2());
    }
}
