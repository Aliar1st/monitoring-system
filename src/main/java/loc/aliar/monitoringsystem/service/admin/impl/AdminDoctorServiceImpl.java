package loc.aliar.monitoringsystem.service.admin.impl;

import loc.aliar.monitoringsystem.domain.Department;
import loc.aliar.monitoringsystem.domain.Doctor;
import loc.aliar.monitoringsystem.domain.User;
import loc.aliar.monitoringsystem.model.DoctorModel;
import loc.aliar.monitoringsystem.repository.DoctorRepository;
import loc.aliar.monitoringsystem.repository.UserRepository;
import loc.aliar.monitoringsystem.service.SecurityService;
import loc.aliar.monitoringsystem.service.admin.AdminDoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminDoctorServiceImpl implements AdminDoctorService {
    private final UserRepository userRepository;
    private final DoctorRepository doctorRepository;
    private final ConversionService conversionService;
    private final SecurityService securityService;

    @Override
    public List<DoctorModel> getAllByDepartmentId(Long departmentId) {
        List<Doctor> doctors = doctorRepository.findAllByDepartmentId(departmentId);
        return convertEntitiesListToModels(doctors);
    }

    @Override
    public DoctorModel save(DoctorModel model) {
        User user = conversionService.convert(model, User.class);
        userRepository.save(user);

        Doctor doctor = conversionService.convert(model, Doctor.class);
        doctor.setUser(user);
        if (securityService.isAdmin()) {
            doctor.setDepartment(new Department(securityService.getDepartmentId()));
        }
        doctorRepository.save(doctor);

        return conversionService.convert(doctor, DoctorModel.class);
    }

    @Override
    public JpaRepository<Doctor, Long> getRepository() {
        return doctorRepository;
    }

    @Override
    public ConversionService getConversationService() {
        return conversionService;
    }

    @Override
    public Class<Doctor> getEntityClass() {
        return Doctor.class;
    }

    @Override
    public Class<DoctorModel> getModelClass() {
        return DoctorModel.class;
    }
}
