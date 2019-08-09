package loc.aliar.monitoringsystem.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class ChartDataRequest {

    private Long patientId;

    private Long loadTypeId;

    private LocalDateTime start;

    private LocalDateTime end;
}
