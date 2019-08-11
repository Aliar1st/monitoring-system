package loc.aliar.monitoringsystem.service.impl;

import loc.aliar.monitoringsystem.domain.Reading;
import loc.aliar.monitoringsystem.model.ChartDataResponse;
import loc.aliar.monitoringsystem.model.ReadingModel;
import loc.aliar.monitoringsystem.repository.ReadingRepository;
import loc.aliar.monitoringsystem.service.ReadingService;
import loc.aliar.monitoringsystem.utils.ConverterUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ReadingServiceImpl implements ReadingService {
    private final ReadingRepository readingRepository;
    private final ConversionService conversionService;
    private final EntityManager entityManager;

    @Override
    public List<ReadingModel> getByPatientId(Long patientId) {
        return ConverterUtils.convertList(readingRepository.findAllByPatientIdOrderByCreatedDate(patientId),
                ReadingModel.class, conversionService);
    }

    @Override
    public Optional<ReadingModel> getLastByPatientId(Long patientId) {
        Optional<Reading> reading = readingRepository.findFirstByPatientIdOrderByCreatedDateDesc(patientId);
        return reading.map(r -> conversionService.convert(r, ReadingModel.class));
    }

    @Override
    public ChartDataResponse chartData(Long patientId, Long loadTypeId, LocalDate start, LocalDate end) {
        List<Reading> readings;

        if (loadTypeId != null) {
            readings = readingRepository.findAllByPatientIdAndLoadLoadTypeIdAndCreatedDateBetween(
                    patientId, loadTypeId, start.atStartOfDay(), end.atTime(LocalTime.MAX));
        } else {
            readings = readingRepository.findAllByPatientIdAndCreatedDateBetween(
                    patientId, start.atStartOfDay(), end.atTime(LocalTime.MAX));
        }

        ChartDataResponse chartDataResponse = new ChartDataResponse(true);

        readings.forEach(reading -> {
            if (reading.getCreatedDate().isPresent()) {
                chartDataResponse.getLabels().add(reading.getCreatedDate().get().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
            } else {
                chartDataResponse.getLabels().add("-");
            }
            chartDataResponse.getData().add(reading.getStatement().getBorgResult());
        });

        chartDataResponse.setRedLine(Collections.nCopies(readings.size(), (byte) 13));

        if (readings.size() > 5) {
            chartDataResponse.setType("line");
        } else {
            chartDataResponse.setType("bar");
        }

        return chartDataResponse;
    }

    @Override
    public ReadingModel get(Long id) {
        return conversionService.convert(readingRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Reading with id " + id + " not found")
        ), ReadingModel.class);
    }

    @Override
    public Long save(ReadingModel readingModel) {
        Reading reading = conversionService.convert(readingModel, Reading.class);
        readingRepository.save(reading);
        return reading.getId();
    }

    @Override
    public void delete(Long id) {
        readingRepository.deleteById(id);
    }
}
