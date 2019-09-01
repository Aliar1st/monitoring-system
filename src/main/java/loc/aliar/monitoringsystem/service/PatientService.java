package loc.aliar.monitoringsystem.service;

import loc.aliar.monitoringsystem.domain.Patient;
import loc.aliar.monitoringsystem.model.CardioCardModel;
import loc.aliar.monitoringsystem.model.PatientModel;

import java.util.List;

public interface PatientService extends CrudService<Patient, PatientModel> {
    PatientModel getForCard(Long patientId);

    List<CardioCardModel> getCardsByDoctorId(Long doctorId, Integer departmentId);

    boolean isRegisteredInDepartment(Long patientId, Integer depId);

    List<PatientModel> getAllByDepartmentId(Integer departmentId);
}
