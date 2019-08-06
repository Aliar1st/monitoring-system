package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.Admin;
import loc.aliar.monitoringsystem.domain.Department;
import loc.aliar.monitoringsystem.model.AdminModel;
import org.springframework.core.convert.converter.Converter;

public class AdminModelToAdminConverter implements Converter<AdminModel, Admin> {
    @Override
    public Admin convert(AdminModel source) {
        return Admin.builder()
                .id(source.getId())
                .department(new Department(source.getDepartmentId()))
                .build();
    }
}
