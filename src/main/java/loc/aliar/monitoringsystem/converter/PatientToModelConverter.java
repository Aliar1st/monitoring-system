package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.Patient;
import loc.aliar.monitoringsystem.model.PatientModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PatientToModelConverter implements Converter<Patient, PatientModel> {
    @Override
    public PatientModel convert(Patient source) {
        return PatientModel.builder()
                .id(source.getId())
                .username(source.getUser().getUsername())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .middleName(source.getMiddleName())
                .photoUrl(source.getPhoto())
                .isWork(source.getIsWork())
                .isMale(source.getIsMale())
                .dateOfBirth(source.getDateOfBirth())
                .phone(source.getPhone())
                .email(source.getEmail())
                .educationId(source.getEducation() != null ? source.getEducation().getId() : null)
                .build();
    }
}
