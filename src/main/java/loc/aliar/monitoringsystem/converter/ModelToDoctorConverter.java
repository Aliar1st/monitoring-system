package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.Degree;
import loc.aliar.monitoringsystem.domain.Doctor;
import loc.aliar.monitoringsystem.domain.Position;
import loc.aliar.monitoringsystem.domain.Specialization;
import loc.aliar.monitoringsystem.model.DoctorModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ModelToDoctorConverter implements Converter<DoctorModel, Doctor> {
    @Override
    public Doctor convert(DoctorModel source) {
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
                .build();
    }
}
