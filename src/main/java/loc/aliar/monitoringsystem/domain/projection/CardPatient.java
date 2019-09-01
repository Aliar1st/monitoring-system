package loc.aliar.monitoringsystem.domain.projection;

import java.time.LocalDate;

public interface CardPatient {
    String getFirstName();

    String getLastName();

    String getPhoto();

    LocalDate getDateOfBirth();
}
