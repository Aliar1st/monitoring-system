package loc.aliar.monitoringsystem.domain.projection;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface CardioCard {
    Long getId();

    LocalDateTime getLastReadingDate();

    String getLastReadingBorg();

    LocalDate getDateOfBirth();

    @Value("#{T(java.lang.String).format(" +
            "T(loc.aliar.monitoringsystem.config.Constants).FULL_NAME_FORMAT," +
            "target.firstName," +
            "target.lastName)}")
    String getFullName();

    String getPhoto();
}
