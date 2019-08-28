package com.finalassignment.bookworm.validater;

import com.finalassignment.bookworm.dto.AdminDto;
import com.finalassignment.bookworm.dto.UserDto;
import com.finalassignment.bookworm.exception.DataValidationException;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class ValidationHelper {


    private Boolean validateEmail(String email) {
        Pattern pat = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }


    private Boolean validateName(String name) {
        if (name.isEmpty()) {
            return false;
        }

        if (name.matches(("[0-9]+"))) {
            return false;
        } else {
            return true;
        }
    }


    private Boolean validateMobileNumber(String mobileNumber) {
        if (mobileNumber.isEmpty()) {
            return false;
        } else if (mobileNumber.length() != 13) {
            return false;
        } else {
            return true;
        }

    }

    private boolean validFormat(String Date) {
        if (Date.matches("([1-9]{1}|[0]{1}[1-9]{1}|[1]{1}[0-9]{1}|[2]{1}[0-9]{1}|[3]{1}[0-1]{1})" +
                "([-]{1})" +
                "([0]{1}[1-9]{1}|[1]{1}[0-2]{1}|[1-9]{1})" +
                "([-]{1})" +
                "([19]{2}[0-9]{2})"))
            return true;
        else
            return false;
    }

    public AdminDto adminValidator(AdminDto adminDto) {
        if (validateName(adminDto.getAdminName()) && validateEmail(adminDto.getAdminEmail()) && validateEmail(adminDto.getAdminEmail()))
            return adminDto;
        throw new DataValidationException("Data invalid for admin");

    }

    public UserDto userValidation(UserDto userDto) {
        if (validateName(userDto.getUserName()) && validateEmail(userDto.getUserEmail()))
            return userDto;

        throw new DataValidationException(("Data invalid for user"));

    }
}
