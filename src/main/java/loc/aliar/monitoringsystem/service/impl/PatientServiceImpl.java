package loc.aliar.monitoringsystem.service.impl;

import loc.aliar.monitoringsystem.domain.Department;
import loc.aliar.monitoringsystem.exception.DepartmentException;
import loc.aliar.monitoringsystem.model.CardioMedicalInfoModel;
import loc.aliar.monitoringsystem.repository.CardioMedicalInfoRepository;
import loc.aliar.monitoringsystem.service.PatientService;
import loc.aliar.monitoringsystem.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final SecurityService securityService;
    private final ConversionService conversionService;

    @Override
    public Object getMedicalInfo(Integer depId) {
        switch (Department.ID_DEPARTMENTS.get(depId)) {
            case CARDIO:
                return conversionService.convert(
                        securityService.getPatient().getCardioMedicalInfo(),
                        CardioMedicalInfoModel.class);
        }

        throw new DepartmentException("Department with id " + depId + " does not exist");
    }
}
