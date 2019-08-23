package loc.aliar.monitoringsystem.validation;

import loc.aliar.monitoringsystem.domain.Role;
import loc.aliar.monitoringsystem.service.SecurityService;
import loc.aliar.monitoringsystem.validation.annotation.NotNullIfRole;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class NotNullIfRoleValidator implements ConstraintValidator<NotNullIfRole, Long> {
    private final SecurityService securityService;

    private Role.Roles role;

    @Override
    public void initialize(NotNullIfRole constraint) {
        role = constraint.value();
    }

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        return securityService.getRole() != role || id != null;
    }
}
