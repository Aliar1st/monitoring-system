package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.*;
import loc.aliar.monitoringsystem.model.AdminDoctorModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AdminDoctorModelToDoctorConverter implements Converter<AdminDoctorModel, Doctor> {
    @Override
    public Doctor convert(AdminDoctorModel source) {
        return Doctor.builder()
                .id(source.getId())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .middleName(source.getMiddleName())
                .phone(source.getPhone())
                .email(source.getEmail())
                .specialization(new Specialization(source.getSpecializationId()))
                .degree(new Degree(source.getDegreeId()))
                .position(new Position(source.getPositionId()))
                .department(new Department(source.getDepartmentId()))
                .build();
    }
}
