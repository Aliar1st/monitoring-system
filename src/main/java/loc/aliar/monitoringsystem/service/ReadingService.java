package loc.aliar.monitoringsystem.service;

import loc.aliar.monitoringsystem.model.ChartDataResponse;
import loc.aliar.monitoringsystem.model.ReadingModel;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ReadingService {
    List<ReadingModel> getByPatientId(Long patientId);

    Optional<ReadingModel> getLastByPatientId(Long patientId);

    ChartDataResponse chartData(Long patientId, Long loadTypeId, LocalDate start, LocalDate end);

    ReadingModel get(Long id);

    Long save(ReadingModel readingModel);

    void delete(Long id);
}
