package loc.aliar.monitoringsystem.service;

import loc.aliar.monitoringsystem.model.ChartDataResponse;
import loc.aliar.monitoringsystem.model.ReadingModel;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ReadingService {
    Optional<ReadingModel> getLastByPatientId(Long patientId);

    ChartDataResponse chartData(Long patientId, Long loadTypeId, LocalDateTime start, LocalDateTime end);

    ReadingModel get(Long id);

    void save(ReadingModel readingModel);

    void delete(Long id);
}
