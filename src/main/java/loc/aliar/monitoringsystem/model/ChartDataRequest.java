package loc.aliar.monitoringsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter @Setter
public class ChartDataRequest {

    private Long patientId;

    private Long loadTypeId;

    @NotNull
    private LocalDateTime start;

    @NotNull
    private LocalDateTime end;
}
