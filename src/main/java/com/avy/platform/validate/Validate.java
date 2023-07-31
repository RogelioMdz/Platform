package com.avy.platform.validate;

import com.avy.platform.entity.User;
import com.avy.platform.exception.ConstraintViolationExceptionCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@Component
public class Validate {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void validateRegExUser(User user) {
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationExceptionCustom("La informacion no satisface los requerimientos");
        }
        if (user.getRole() == null) {
            user.setRole(User.Role.USER);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }
}
