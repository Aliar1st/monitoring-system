package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.AbstractModel;
import loc.aliar.monitoringsystem.domain.Patient;
import loc.aliar.monitoringsystem.model.PatientModel;
import loc.aliar.monitoringsystem.utils.ObjectUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PatientToModelConverter implements Converter<Patient, PatientModel> {
    @Override
    public PatientModel convert(Patient source) {
        return PatientModel.builder()
                .id(source.getId())
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
