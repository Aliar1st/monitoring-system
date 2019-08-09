package loc.aliar.monitoringsystem.service.admin.impl;

import loc.aliar.monitoringsystem.domain.Admin;
import loc.aliar.monitoringsystem.domain.User;
import loc.aliar.monitoringsystem.model.AdminModel;
import loc.aliar.monitoringsystem.repository.AdminRepository;
import loc.aliar.monitoringsystem.repository.UserRepository;
import loc.aliar.monitoringsystem.service.admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final UserRepository userRepository;
    private final AdminRepository adminRepository;
    private final ConversionService conversionService;
//    private final SecurityService securityService;

    @Override
    public List<AdminModel> getAllByDepartmentId(Long departmentId) {
        List<Admin> admins = adminRepository.findAllByDepartmentId(departmentId);
        return convertEntitiesListToModels(admins);
    }

    @Override
    public AdminModel save(AdminModel model) {
        User user = conversionService.convert(model, User.class);
        userRepository.save(user);

        Admin admin = conversionService.convert(model, Admin.class);
        admin.setUser(user);
//        if (securityService.isAdmin()) {
//            admin.setDepartment(new Department(securityService.getDepartmentId()));
//        }
        adminRepository.save(admin);

        return conversionService.convert(admin, AdminModel.class);
    }

    public JpaRepository<Admin, Long> getRepository() {
        return adminRepository;
    }

    @Override
    public ConversionService getConversationService() {
        return conversionService;
    }

    @Override
    public Class<Admin> getEntityClass() {
        return Admin.class;
    }

    @Override
    public Class<AdminModel> getModelClass() {
        return AdminModel.class;
    }
}
