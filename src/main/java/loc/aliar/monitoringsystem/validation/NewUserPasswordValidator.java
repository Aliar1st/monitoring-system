package loc.aliar.monitoringsystem.validation;

import loc.aliar.monitoringsystem.utils.ReflectionUtils;
import loc.aliar.monitoringsystem.validation.annotation.NewUserPassword;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class NewUserPasswordValidator implements ConstraintValidator<NewUserPassword, Object> {

    private String idFieldName;
    private String passwordFieldName;

    @Override
    public void initialize(NewUserPassword constraintAnnotation) {
        this.idFieldName = constraintAnnotation.idFieldName();
        this.passwordFieldName = constraintAnnotation.passwordFieldName();
    }

    @Override
    @SneakyThrows
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return ReflectionUtils.getFieldValue(value, idFieldName) != null
                || ReflectionUtils.getFieldValue(value, passwordFieldName) != null;
    }
}
