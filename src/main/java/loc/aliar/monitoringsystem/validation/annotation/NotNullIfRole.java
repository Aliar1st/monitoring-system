package loc.aliar.monitoringsystem.validation.annotation;

import loc.aliar.monitoringsystem.domain.Role;
import loc.aliar.monitoringsystem.validation.NotNullIfRoleValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NotNullIfRoleValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNullIfRole {
    Role.Roles value();

    String message() default "{loc.aliar.monitoringsystem.validation.annotation.NotNullIfRole.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
