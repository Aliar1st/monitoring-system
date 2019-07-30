package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.Admin;
import loc.aliar.monitoringsystem.model.AdminModel;
import org.springframework.core.convert.converter.Converter;

public class AdminToModelConverter implements Converter<Admin, AdminModel> {
    @Override
    public AdminModel convert(Admin source) {
        return AdminModel.builder()
                .id(source.getId())
                .username(source.getUser().getUsername())
                .departmentId(source.getDepartment().getId())
                .build();
    }
}
