package loc.aliar.monitoringsystem.validation;

import loc.aliar.monitoringsystem.validation.annotation.Exists;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.data.repository.CrudRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class ExistsValidatorForInteger implements ConstraintValidator<Exists, Integer> {
    private final ApplicationContext context;

    private CrudRepository<?, Integer> repository;

    @Override
    public void initialize(Exists constraint) {
        //noinspection unchecked
        repository = (CrudRepository<?, Integer>) context.getBean(constraint.value());
    }

    @Override
    public boolean isValid(Integer id, ConstraintValidatorContext context) {
        if (id == null) {
            return true;
        }
        if (id <= 0) {
            return false;
        }
        return repository.existsById(id);
    }
}
