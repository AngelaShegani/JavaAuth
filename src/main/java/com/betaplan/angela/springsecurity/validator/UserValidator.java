package com.betaplan.angela.springsecurity.validator;


import com.betaplan.angela.springsecurity.models.User;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        // Validation logic here

        // Example validation using ValidationUtils
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty", "Empty email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty", "Empty password");

        // Custom password confirmation validation
        String confirm = user.getConfirm();
        if (confirm != null && !confirm.equals(user.getPassword())) {
            errors.rejectValue("confirm", "Match", "Passwords do not match");
        }
    }

}