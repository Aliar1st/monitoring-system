package loc.aliar.monitoringsystem.service.admin.impl;

import loc.aliar.monitoringsystem.domain.Department;
import loc.aliar.monitoringsystem.domain.Patient;
import loc.aliar.monitoringsystem.domain.User;
import loc.aliar.monitoringsystem.exception.DepartmentNotFoundException;
import loc.aliar.monitoringsystem.model.AdminPatientModel;
import loc.aliar.monitoringsystem.repository.PatientRepository;
import loc.aliar.monitoringsystem.repository.UserRepository;
import loc.aliar.monitoringsystem.service.admin.AdminPatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminPatientServiceImpl implements AdminPatientService {
    private final UserRepository userRepository;
    private final PatientRepository patientRepository;
    private final ConversionService conversionService;

    @Override
    public AdminPatientModel save(AdminPatientModel model) {
        User user = conversionService.convert(model, User.class);
        userRepository.save(user);

        Patient patient = conversionService.convert(model, Patient.class);
        patient.setUser(user);
        patientRepository.save(patient);

        return conversionService.convert(patient, AdminPatientModel.class);
    }

    @Override
    public List<AdminPatientModel> getAllByDepartmentId(Integer departmentId) {
        Department.Departments departments = Department.ID_DEPARTMENTS.get(departmentId);
        List<Patient> patients;
        switch (departments) {
            case CARDIO:
                patients = patientRepository.findAllInCardioDepartment();
                break;
            default:
                throw new DepartmentNotFoundException(departmentId);
        }

        return convertToModelList(patients);
    }

    @Override
    public JpaRepository<Patient, Long> getRepository() {
        return patientRepository;
    }

    @Override
    public ConversionService getConversationService() {
        return conversionService;
    }

    @Override
    public Class<Patient> getEntityClass() {
        return Patient.class;
    }

    @Override
    public Class<AdminPatientModel> getModelClass() {
        return AdminPatientModel.class;
    }
}
