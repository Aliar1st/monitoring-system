package loc.aliar.monitoringsystem.service.admin.impl;

import loc.aliar.monitoringsystem.domain.Doctor;
import loc.aliar.monitoringsystem.domain.User;
import loc.aliar.monitoringsystem.model.AdminDoctorModel;
import loc.aliar.monitoringsystem.repository.DoctorRepository;
import loc.aliar.monitoringsystem.repository.UserRepository;
import loc.aliar.monitoringsystem.service.admin.AdminDoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminDoctorServiceImpl implements AdminDoctorService {
    private final UserRepository userRepository;
    private final DoctorRepository doctorRepository;
    private final ConversionService conversionService;

    @Override
    public List<AdminDoctorModel> getAllByDepartmentId(Integer departmentId) {
        List<Doctor> doctors = doctorRepository.findAllByDepartmentId(departmentId);
        return convertToModelList(doctors);
    }

    @Override
    public AdminDoctorModel save(AdminDoctorModel model) {
        User user = conversionService.convert(model, User.class);
        userRepository.save(user);

        Doctor doctor = conversionService.convert(model, Doctor.class);
        doctor.setUser(user);
        doctorRepository.save(doctor);

        return conversionService.convert(doctor, AdminDoctorModel.class);
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
    public Class<AdminDoctorModel> getModelClass() {
        return AdminDoctorModel.class;
    }
}
