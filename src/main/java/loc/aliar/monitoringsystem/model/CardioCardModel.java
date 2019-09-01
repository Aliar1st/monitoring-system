package loc.aliar.monitoringsystem.model;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardioCardModel {
    private Long id;

    private LocalDateTime lastReadingDate;

    private String lastReadingBorg;

    private LocalDate dateOfBirth;

    private String fullName;

    private String photo;
}
