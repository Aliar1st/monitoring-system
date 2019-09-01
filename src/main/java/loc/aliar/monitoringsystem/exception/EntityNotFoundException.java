package loc.aliar.monitoringsystem.exception;

public class EntityNotFoundException extends RuntimeException {
    private static final String MSG = "%s with id %s not found";

    public EntityNotFoundException(String name, Number id) {
        super(String.format(MSG, name, id));
    }
}
