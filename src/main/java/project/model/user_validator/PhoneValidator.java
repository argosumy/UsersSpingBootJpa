package project.model.user_validator;

import org.springframework.beans.factory.annotation.Autowired;
import project.model.User;
import project.service.UsersServiceView;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidator implements ConstraintValidator<PhoneValid, String> {
    private String regPhone;
//    @Autowired
//    private UsersServiceView usersServiceView;

    @Override
    public void initialize(PhoneValid regPhoneConfig) {
        regPhone = regPhoneConfig.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        Pattern pattern = Pattern.compile(regPhone);
        Matcher matcher = pattern.matcher(value);
        boolean result = matcher.matches();
//        if(result){
//            List<User> users = usersServiceView.getUserByPhone(value);
//            if(users.size() > 0){
//                result = false;
//            }
//        }
        return result;
    }
}
