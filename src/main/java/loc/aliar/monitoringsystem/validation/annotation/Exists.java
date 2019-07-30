package loc.aliar.monitoringsystem.validation.annotation;

import loc.aliar.monitoringsystem.validation.ExistsValidator;
import org.springframework.data.repository.CrudRepository;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ExistsValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Exists {
    Class<? extends CrudRepository<?, Long>> value();

    String message() default "{loc.aliar.monitoringsystem.validation.annotation.Exists.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
