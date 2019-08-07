package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.Doctor;
import loc.aliar.monitoringsystem.model.DoctorModel;
import org.springframework.core.convert.converter.Converter;

public class DoctorToModelConverter implements Converter<Doctor, DoctorModel> {
    @Override
    public DoctorModel convert(Doctor source) {
        return DoctorModel.builder()
                .id(source.getId())
                .username(source.getUser().getUsername())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .middleName(source.getMiddleName())
                .phone(source.getPhone())
                .email(source.getEmail())
                .specializationId(source.getSpecialization().getId())
                .degreeId(source.getDegree().getId())
                .positionId(source.getPosition().getId())
                .departmentId(source.getDepartment().getId())
                .build();
    }
}
