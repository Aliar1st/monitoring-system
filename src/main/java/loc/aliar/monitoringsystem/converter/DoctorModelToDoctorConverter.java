package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.*;
import loc.aliar.monitoringsystem.model.DoctorModel;
import org.springframework.core.convert.converter.Converter;

public class DoctorModelToDoctorConverter implements Converter<DoctorModel, Doctor> {
    @Override
    public Doctor convert(DoctorModel source) {
        return Doctor.builder()
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
