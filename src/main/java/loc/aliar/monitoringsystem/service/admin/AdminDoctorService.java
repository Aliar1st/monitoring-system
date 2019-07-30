package loc.aliar.monitoringsystem.service.admin;

import loc.aliar.monitoringsystem.domain.Doctor;
import loc.aliar.monitoringsystem.model.DoctorModel;

import java.util.List;

public interface AdminDoctorService extends CrudService<Doctor, DoctorModel> {
    List<DoctorModel> getAllByDepartmentId(Long departmentId);
}
