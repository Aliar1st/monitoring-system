package loc.aliar.monitoringsystem.repository;

public abstract class Queries {
    private Queries() {
    }

    static final String READ_MESSAGES =
            "UPDATE Message m " +
            "SET m.isRead = true " +
            "WHERE m.isRead = false " +
            "AND m.fromUser.id = ?1" +
            "AND m.toUser.id = ?2";
}
