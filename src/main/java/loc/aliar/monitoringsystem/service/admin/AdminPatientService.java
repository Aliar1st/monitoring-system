package loc.aliar.monitoringsystem.service.admin;

import loc.aliar.monitoringsystem.domain.Patient;
import loc.aliar.monitoringsystem.model.AdminPatientModel;
import loc.aliar.monitoringsystem.service.CrudService;

import java.util.List;

public interface AdminPatientService extends CrudService<Patient, AdminPatientModel> {
    List<AdminPatientModel> getAllByDepartmentId(Integer departmentId);
}
