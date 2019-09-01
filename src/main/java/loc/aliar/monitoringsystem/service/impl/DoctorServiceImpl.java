package loc.aliar.monitoringsystem.service.impl;

import loc.aliar.monitoringsystem.domain.Doctor;
import loc.aliar.monitoringsystem.model.DoctorModel;
import loc.aliar.monitoringsystem.model.IdAble;
import loc.aliar.monitoringsystem.repository.DoctorRepository;
import loc.aliar.monitoringsystem.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;
    private final ConversionService conversionService;

    @Override
    public boolean isDoctorPatient(Long doctorId, Long patientId) {
        return doctorRepository.existsByDoctorIdAndPatientId(doctorId, patientId);
    }

    @Override
    public String[] getIgnoreCopyProperties() {
        return new String[]{IdAble.ID_COLUMN, "departmentId"};
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
