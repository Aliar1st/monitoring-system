package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.Education;
import loc.aliar.monitoringsystem.domain.PatientGeneralInfo;
import loc.aliar.monitoringsystem.model.PatientModel;
import loc.aliar.monitoringsystem.service.storage.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PatientModelToGeneralInfoConverter implements Converter<PatientModel, PatientGeneralInfo> {
    private final StorageService storageService;

    @Override
    public PatientGeneralInfo convert(PatientModel source) {
        return PatientGeneralInfo.builder()
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .middleName(source.getMiddleName())
                .photo(storageService.store(source.getPhoto()))
                .isWork(source.getIsWork())
                .isMale(source.getIsMale())
                .dateOfBirth(source.getDateOfBirth())
                .phone(source.getPhone())
                .email(source.getEmail())
                .education(new Education(source.getEducationId()))
                .build();
    }
}
