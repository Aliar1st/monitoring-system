package loc.aliar.monitoringsystem.service.admin;

import loc.aliar.monitoringsystem.domain.Admin;
import loc.aliar.monitoringsystem.model.AdminModel;
import loc.aliar.monitoringsystem.service.CrudService;

import java.util.List;

public interface AdminService extends CrudService<Admin, AdminModel> {
    List<AdminModel> getAllByDepartmentId(Long departmentId);
}
