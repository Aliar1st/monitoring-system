package loc.aliar.monitoringsystem.service;

public interface MedicalInfoService {
    Object getByPatientIdAndDepartmentId(Long patientId, Integer departmentId);

}
