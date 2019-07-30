package loc.aliar.monitoringsystem.validation;

import loc.aliar.monitoringsystem.validation.annotation.Unique;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.ApplicationContext;
import org.springframework.data.repository.CrudRepository;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Method;

@RequiredArgsConstructor
public class UniqueValidator implements ConstraintValidator<Unique, Object> {
    private static final String EXISTS_METHOD_NAME_PREFIX ="existsBy";

    private final ApplicationContext context;

    private CrudRepository<?, Long> repository;
    private String fieldName;
    private Class<?> fieldClass;

    @Override
    public void initialize(Unique constraint) {
        repository = context.getBean(constraint.value());
        fieldName = constraint.fieldName();
        fieldName = StringUtils.capitalize(fieldName);
        fieldClass = constraint.fieldClass();
    }

    @Override
    @SneakyThrows
    public boolean isValid(Object fieldValue, ConstraintValidatorContext context) {
        Method existsMethod = repository.getClass().getMethod(EXISTS_METHOD_NAME_PREFIX + fieldName, fieldClass);
        return !Boolean.class.cast(existsMethod.invoke(repository, fieldValue));
    }
}
