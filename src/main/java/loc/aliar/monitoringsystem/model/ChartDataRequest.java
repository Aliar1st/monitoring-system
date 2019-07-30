package loc.aliar.monitoringsystem.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChartDataRequest {

    private Long patientId;

    private Long loadTypeId;

    private LocalDateTime start;

    private LocalDateTime end;
}
