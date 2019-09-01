package loc.aliar.monitoringsystem.exception;

public class UserNotAuthenticatedException extends RuntimeException {
    private static final String MSG = "User is not authenticated";

    public UserNotAuthenticatedException() {
        super(MSG);
    }
}

