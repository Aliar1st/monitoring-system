package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.AbstractModel;
import loc.aliar.monitoringsystem.domain.Patient;
import loc.aliar.monitoringsystem.model.AdminPatientModel;
import loc.aliar.monitoringsystem.utils.ObjectUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PatientToAdminModelConverter implements Converter<Patient, AdminPatientModel> {
    @Override
    public AdminPatientModel convert(Patient source) {
        return AdminPatientModel.builder()
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
                .educationId(ObjectUtils.nullSafe(source.getEducation(), AbstractModel::getId))
                .build();
    }
}
