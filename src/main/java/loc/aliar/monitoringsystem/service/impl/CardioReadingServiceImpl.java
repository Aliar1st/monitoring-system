package loc.aliar.monitoringsystem.service.impl;

import loc.aliar.monitoringsystem.config.Constants;
import loc.aliar.monitoringsystem.domain.CardioReading;
import loc.aliar.monitoringsystem.domain.projection.CardioCard;
import loc.aliar.monitoringsystem.domain.projection.CardioReadingLastParams;
import loc.aliar.monitoringsystem.model.CardioCardModel;
import loc.aliar.monitoringsystem.model.CardioReadingModel;
import loc.aliar.monitoringsystem.model.ChartDataResponse;
import loc.aliar.monitoringsystem.repository.CardioReadingRepository;
import loc.aliar.monitoringsystem.service.CardioReadingService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CardioReadingServiceImpl implements CardioReadingService {
    private final CardioReadingRepository cardioReadingRepository;
    private final ConversionService conversionService;

    @Override
    public List<CardioReadingModel> getByPatientId(Long patientId) {
        return convertToModelList(cardioReadingRepository.findAllByPatientIdOrderByCreatedDate(patientId));
    }

    @Override
    public Optional<CardioReadingModel> getLastByPatientId(Long patientId) {
        Optional<CardioReadingLastParams> reading = cardioReadingRepository.findLastReadingByPatientId(patientId);
        return reading.map(r -> conversionService.convert(r, CardioReadingModel.class));
    }

    @Override
    public Optional<CardioCardModel> getCardByPatientId(Long patientId) {
        Optional<CardioCard> reading = cardioReadingRepository.findLastReadingAndPatientByPatientId(patientId);
        return reading.map(r -> conversionService.convert(r, CardioCardModel.class));
    }

    @Override
    public ChartDataResponse chartData(Long patientId, Long loadTypeId, LocalDate start, LocalDate end) {
        List<CardioReading> cardioReadings = getCardioReadingsForChartData(patientId, loadTypeId, start, end);

        ChartDataResponse chartDataResponse = new ChartDataResponse(true);
        fillChartDataResponseWithReadings(cardioReadings, chartDataResponse);
        chartDataResponse.setRedLine(Collections.nCopies(cardioReadings.size(), (byte) 13));
        setChartType(cardioReadings.size(), chartDataResponse);

        return chartDataResponse;
    }

    private List<CardioReading> getCardioReadingsForChartData(
            Long patientId, Long loadTypeId, LocalDate start, LocalDate end
    ) {
        List<CardioReading> cardioReadings;
        if (loadTypeId != null) {
            cardioReadings = cardioReadingRepository.findAllByPatientIdAndLoadLoadTypeIdAndCreatedDateBetween(
                    patientId, loadTypeId, start.atStartOfDay(), end.atTime(LocalTime.MAX));
        } else {
            cardioReadings = cardioReadingRepository.findAllByPatientIdAndCreatedDateBetween(
                    patientId, start.atStartOfDay(), end.atTime(LocalTime.MAX));
        }
        return cardioReadings;
    }

    private void fillChartDataResponseWithReadings(
            List<CardioReading> cardioReadings, ChartDataResponse chartDataResponse
    ) {
        cardioReadings.forEach(reading -> {
            if (reading.getCreatedDate().isPresent()) {
                chartDataResponse.getLabels().add(reading.getCreatedDate().get().format(Constants.DATETIME_FORMAT));
            } else {
                chartDataResponse.getLabels().add("-");
            }
            chartDataResponse.getData().add(reading.getStatement().getBorgResult());
        });
    }

    private void setChartType(Integer amountOfReadings, ChartDataResponse chartDataResponse) {
        if (amountOfReadings > 5) {
            chartDataResponse.setType("line");
        } else {
            chartDataResponse.setType("bar");
        }
    }

    @Override
    public JpaRepository<CardioReading, Long> getRepository() {
        return cardioReadingRepository;
    }

    @Override
    public ConversionService getConversationService() {
        return conversionService;
    }

    @Override
    public Class<CardioReading> getEntityClass() {
        return CardioReading.class;
    }

    @Override
    public Class<CardioReadingModel> getModelClass() {
        return CardioReadingModel.class;
    }
}
