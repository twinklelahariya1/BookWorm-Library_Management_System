package com.finalassignment.bookworm.validater;
import java.util.regex.Pattern;


public class ValidationUtil {


    public static class Validations {


        public static Boolean isValidateEmail(String email) {
            Pattern pat =  Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
            if (email == null)
                return false;
            return pat.matcher(email).matches();
        }


        public static Boolean isValidateName(String name) {
            if(name.isEmpty()) {
                return false;
            }

            if(name.matches(("[0-9]+"))) {
                return false;
            }
            else {
                return true;
            }
        }


        public static Boolean isValidateMobileNumber(String mobileNumber) {
            if(mobileNumber.isEmpty()) {
                return false;
            }
            else if(mobileNumber.length() !=13) {
                return false;
            }
            else {
                return true;
            }

        }

        public static boolean isValidFormat(String Date) {
            if (Date.matches("([1-9]{1}|[0]{1}[1-9]{1}|[1]{1}[0-9]{1}|[2]{1}[0-9]{1}|[3]{1}[0-1]{1})" +
                    "([-]{1})" +
                    "([0]{1}[1-9]{1}|[1]{1}[0-2]{1}|[1-9]{1})" +
                    "([-]{1})" +
                    "([19]{2}[0-9]{2})"))
                return true;
            else
                return false;
        }
    }
}
