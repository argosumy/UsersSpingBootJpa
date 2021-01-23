package project.model.user_validator;



import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;


@Target({FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneValidator.class)
@Documented
public @interface PhoneValid {
    public String value() default "^[0-9]+$";
    public String message() default "phone must have only number (example:380994869938)";

    public Class<?>[] groups() default {};
    public Class<? extends Payload> [] payload() default {};

}
