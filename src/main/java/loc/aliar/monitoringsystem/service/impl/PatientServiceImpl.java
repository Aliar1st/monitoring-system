package loc.aliar.monitoringsystem.service.impl;

import loc.aliar.monitoringsystem.domain.Doctor;
import loc.aliar.monitoringsystem.domain.Patient;
import loc.aliar.monitoringsystem.model.PatientModel;
import loc.aliar.monitoringsystem.repository.DoctorRepository;
import loc.aliar.monitoringsystem.repository.PatientRepository;
import loc.aliar.monitoringsystem.service.PatientService;
import loc.aliar.monitoringsystem.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final SecurityService securityService;
    private final ConversionService conversionService;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Override
    public Object getMedicalInfo(Integer depId) {
        return null;
//        Department.Departments departments = Department.ID_DEPARTMENTS.get(depId);
//        Object medicalInfo = DepartmentToMedicalInfoMapping;
//        Class<?> medicalClass;
//        switch (departments) {
//            case CARDIO:
//                medicalInfo = securityService.getPatient().getCardioMedicalInfo();
//                medicalClass = CardioMedicalInfoModel.class;
//                break;
//            default:
//                throw new DepartmentException("Department with id " + depId + " does not exist");
//        }
//
//        if (medicalInfo == null) {
//            return null;
//        }
//
//        return conversionService.convert(medicalInfo, medicalClass);
    }

    @Override
    public boolean isRegisteredInDepartment(Integer depId) {
        return getMedicalInfo(depId) != null;
    }

    @Override
    public List<PatientModel> getAllByDoctorId(Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(
                () -> new EntityNotFoundException("Doctor with id " + doctorId + " not found"));
        return doctor.getPatients().stream()
                .map(p -> conversionService.convert(p, PatientModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public PatientModel getPatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(
                () -> new EntityNotFoundException("Patient with id " + patientId + " not found"));
        return conversionService.convert(patient, PatientModel.class);
    }


}
