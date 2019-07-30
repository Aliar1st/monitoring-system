package loc.aliar.monitoringsystem.validation.annotation;

import loc.aliar.monitoringsystem.validation.UniqueValidator;
import org.springframework.data.repository.CrudRepository;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {UniqueValidator.class})
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Unique {
    Class<? extends CrudRepository<?, Long>> value();

    String fieldName() default "name";

    Class<?> fieldClass() default String.class;

    String message() default "{loc.aliar.monitoringsystem.validation.annotation.Unique.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
