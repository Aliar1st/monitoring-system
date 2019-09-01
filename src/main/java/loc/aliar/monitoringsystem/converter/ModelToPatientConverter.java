package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.Education;
import loc.aliar.monitoringsystem.domain.Patient;
import loc.aliar.monitoringsystem.model.PatientModel;
import loc.aliar.monitoringsystem.service.storage.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ModelToPatientConverter implements Converter<PatientModel, Patient> {
    private StorageService storageService;

    @Override
    public Patient convert(PatientModel source) {
        return Patient.builder()
                .id(source.getId())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .middleName(source.getMiddleName())
                .isWork(source.getIsWork())
                .isMale(source.getIsMale())
                .dateOfBirth(source.getDateOfBirth())
                .phone(source.getPhone())
                .email(source.getEmail())
                .education(new Education(source.getEducationId()))
                .build();
    }
}
