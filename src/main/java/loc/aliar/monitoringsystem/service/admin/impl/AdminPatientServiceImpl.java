package loc.aliar.monitoringsystem.service.admin.impl;

import loc.aliar.monitoringsystem.domain.Patient;
import loc.aliar.monitoringsystem.domain.User;
import loc.aliar.monitoringsystem.model.PatientModel;
import loc.aliar.monitoringsystem.repository.PatientRepository;
import loc.aliar.monitoringsystem.repository.UserRepository;
import loc.aliar.monitoringsystem.service.admin.AdminPatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminPatientServiceImpl implements AdminPatientService {
    private final UserRepository userRepository;
    private final PatientRepository patientRepository;
    private final ConversionService conversionService;

    @Override
    public PatientModel save(PatientModel model) {
        User user = conversionService.convert(model, User.class);

        if (user.getId() == null && user.getPassword() == null) {

        }

        userRepository.save(user);

        Patient patient = conversionService.convert(model, Patient.class);
        patient.setUser(user);
        patientRepository.save(patient);

        return conversionService.convert(patient, PatientModel.class);
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
