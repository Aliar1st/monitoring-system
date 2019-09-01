package loc.aliar.monitoringsystem.service.impl;

import loc.aliar.monitoringsystem.domain.Department;
import loc.aliar.monitoringsystem.domain.Patient;
import loc.aliar.monitoringsystem.domain.projection.CardPatient;
import loc.aliar.monitoringsystem.domain.projection.CardioCard;
import loc.aliar.monitoringsystem.exception.DepartmentNotFoundException;
import loc.aliar.monitoringsystem.model.CardioCardModel;
import loc.aliar.monitoringsystem.model.PatientModel;
import loc.aliar.monitoringsystem.repository.PatientRepository;
import loc.aliar.monitoringsystem.service.MedicalInfoService;
import loc.aliar.monitoringsystem.service.PatientService;
import loc.aliar.monitoringsystem.utils.ConverterUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final MedicalInfoService medicalInfoService;
    private final ConversionService conversionService;
    private final PatientRepository patientRepository;

    @Override
    public PatientModel getForCard(Long patientId) {
        CardPatient patient = patientRepository.getById(patientId);
        return conversionService.convert(patient, PatientModel.class);
    }

    @Override
    public List<CardioCardModel> getCardsByDoctorId(Long doctorId, Integer departmentId) {
        List<CardioCard> cardioCards =
                patientRepository.findCardioCardsByDoctorIdAndDepartmentId(doctorId, departmentId);
        return ConverterUtils.convertList(cardioCards, CardioCardModel.class, conversionService);
    }

    @Override
    public boolean isRegisteredInDepartment(Long patientId, Integer depId) {
        return medicalInfoService.getByPatientIdAndDepartmentId(patientId, depId) != null;
    }

    @Override
    public List<PatientModel> getAllByDepartmentId(Integer departmentId) {
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
    public Class<PatientModel> getModelClass() {
        return PatientModel.class;
    }
}
