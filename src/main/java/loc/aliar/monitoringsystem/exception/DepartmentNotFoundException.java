package loc.aliar.monitoringsystem.exception;

public class DepartmentNotFoundException extends RuntimeException {
    private static final String MSG = "Department with id %d not found";

    public DepartmentNotFoundException(Integer departmentId) {
        super(String.format(MSG, departmentId));
    }
}

