package loc.aliar.monitoringsystem.service.admin;

import loc.aliar.monitoringsystem.domain.Doctor;
import loc.aliar.monitoringsystem.model.AdminDoctorModel;
import loc.aliar.monitoringsystem.service.CrudService;

import java.util.List;

public interface AdminDoctorService extends CrudService<Doctor, AdminDoctorModel> {
    List<AdminDoctorModel> getAllByDepartmentId(Integer departmentId);
}
