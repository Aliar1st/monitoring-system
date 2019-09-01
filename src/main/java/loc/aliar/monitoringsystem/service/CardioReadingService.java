package loc.aliar.monitoringsystem.service;

import loc.aliar.monitoringsystem.domain.CardioReading;
import loc.aliar.monitoringsystem.model.CardioCardModel;
import loc.aliar.monitoringsystem.model.CardioReadingModel;
import loc.aliar.monitoringsystem.model.ChartDataResponse;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CardioReadingService extends CrudService<CardioReading, CardioReadingModel> {
    List<CardioReadingModel> getByPatientId(Long patientId);

    Optional<CardioReadingModel> getLastByPatientId(Long patientId);

    Optional<CardioCardModel> getCardByPatientId(Long patientId);

    ChartDataResponse chartData(Long patientId, Long loadTypeId, LocalDate start, LocalDate end);
}
