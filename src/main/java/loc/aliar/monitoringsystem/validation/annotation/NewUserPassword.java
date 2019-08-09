package loc.aliar.monitoringsystem.validation.annotation;

import loc.aliar.monitoringsystem.validation.NewUserPasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {NewUserPasswordValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface NewUserPassword {
    String idFieldName() default "id";

    String passwordFieldName() default "password";

    String message() default "{loc.aliar.monitoringsystem.validation.annotation.NewUserPassword.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
