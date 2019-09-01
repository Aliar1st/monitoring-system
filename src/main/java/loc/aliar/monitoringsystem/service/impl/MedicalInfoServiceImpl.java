package loc.aliar.monitoringsystem.service.impl;

import loc.aliar.monitoringsystem.domain.Department;
import loc.aliar.monitoringsystem.exception.DepartmentNotFoundException;
import loc.aliar.monitoringsystem.model.CardioMedicalInfoModel;
import loc.aliar.monitoringsystem.service.MedicalInfoService;
import loc.aliar.monitoringsystem.service.admin.CardioMedInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicalInfoServiceImpl implements MedicalInfoService {
    private final ConversionService conversionService;
    private final CardioMedInfoService cardioMedInfoService;

    @Override
    public Object getByPatientIdAndDepartmentId(Long patientId, Integer departmentId) {
        Department.Departments departments = Department.ID_DEPARTMENTS.get(departmentId);
        Object medicalInfo;
        Class<?> medicalClass;
        switch (departments) {
            case CARDIO:
                medicalInfo = cardioMedInfoService.getByPatientId(patientId);
                medicalClass = CardioMedicalInfoModel.class;
                break;
            default:
                throw new DepartmentNotFoundException(departmentId);
        }

        return conversionService.convert(medicalInfo, medicalClass);
    }
}
