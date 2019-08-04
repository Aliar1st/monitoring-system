package loc.aliar.monitoringsystem.validation;

import loc.aliar.monitoringsystem.validation.annotation.Exists;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.data.repository.CrudRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class ExistsValidatorForLong implements ConstraintValidator<Exists, Long> {
    private final ApplicationContext context;

    private CrudRepository<?, Long> repository;

    @Override
    public void initialize(Exists constraint) {
        //noinspection unchecked
        repository = (CrudRepository<?, Long>) context.getBean(constraint.value());
    }

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        if (id == null) {
            return true;
        }
        if (id <= 0) {
            return false;
        }
        return repository.existsById(id);
    }
}
