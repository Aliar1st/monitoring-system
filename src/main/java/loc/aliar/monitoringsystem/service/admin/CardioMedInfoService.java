package loc.aliar.monitoringsystem.service.admin;

import loc.aliar.monitoringsystem.domain.CardioMedicalInfo;
import loc.aliar.monitoringsystem.model.CardioMedicalInfoModel;
import loc.aliar.monitoringsystem.service.CrudService;

public interface CardioMedInfoService extends CrudService<CardioMedicalInfo, CardioMedicalInfoModel> {
    CardioMedicalInfoModel getByPatientId(Long patientId);
}
