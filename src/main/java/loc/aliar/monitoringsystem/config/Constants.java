package loc.aliar.monitoringsystem.config;

import java.time.format.DateTimeFormatter;

public interface Constants {
    String DEP_ATTR = "DEP_ATTR";

    DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    DateTimeFormatter DATETIME_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    String FULL_NAME_FORMAT = "%s %s";
}
