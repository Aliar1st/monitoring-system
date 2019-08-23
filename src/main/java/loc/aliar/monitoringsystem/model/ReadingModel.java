package loc.aliar.monitoringsystem.model;

import loc.aliar.monitoringsystem.repository.BodyPositionRepository;
import loc.aliar.monitoringsystem.repository.LoadRepository;
import loc.aliar.monitoringsystem.repository.StatementRepository;
import loc.aliar.monitoringsystem.validation.annotation.Exists;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReadingModel {
    private Long id;

    @NotNull
    private Short duration;

    @NotNull
    @Min(50)
    @Max(250)
    private Short growth;

    @NotNull
    @Min(30)
    @Max(200)
    private Short weight;

    private LocalDateTime date;

    private Byte borg;
    private String loadName;
    private String loadTypeName;
    private String recommendation;

    @Exists(LoadRepository.class)
    private Long loadId;

    @Exists(BodyPositionRepository.class)
    private Long bodyPositionId;

    @Exists(StatementRepository.class)
    private Long statementId;

    private Long patientId;

    public String getDateFormat() {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public String getTimeFormat() {
        return date.format(DateTimeFormatter.ofPattern("HH:mm"));
    }
}
