package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.Doctor;
import loc.aliar.monitoringsystem.model.AdminDoctorModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AdminDoctorToModelConverter implements Converter<Doctor, AdminDoctorModel> {
    @Override
    public AdminDoctorModel convert(Doctor source) {
        return AdminDoctorModel.builder()
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
