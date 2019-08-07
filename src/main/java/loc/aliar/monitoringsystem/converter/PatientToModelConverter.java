package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.Patient;
import loc.aliar.monitoringsystem.model.PatientModel;
import org.springframework.core.convert.converter.Converter;

public class PatientToModelConverter implements Converter<Patient, PatientModel> {
    @Override
    public PatientModel convert(Patient source) {
        return PatientModel.builder()
                .id(source.getId())
                .username(source.getUser().getUsername())
                .firstName(source.getPatientGeneralInfo().getFirstName())
                .lastName(source.getPatientGeneralInfo().getLastName())
                .middleName(source.getPatientGeneralInfo().getMiddleName())
                .photoUrl(source.getPatientGeneralInfo().getPhoto())
                .isWork(source.getPatientGeneralInfo().getIsWork())
                .isMale(source.getPatientGeneralInfo().getIsMale())
                .dateOfBirth(source.getPatientGeneralInfo().getDateOfBirth())
                .phone(source.getPatientGeneralInfo().getPhone())
                .email(source.getPatientGeneralInfo().getEmail())
                .educationId(source.getPatientGeneralInfo().getEducation().getId())
                .build();
    }
}
