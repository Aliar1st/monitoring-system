package loc.aliar.monitoringsystem.service.impl;

import loc.aliar.monitoringsystem.domain.Role;
import loc.aliar.monitoringsystem.domain.User;
import loc.aliar.monitoringsystem.exception.UserNotAuthenticatedException;
import loc.aliar.monitoringsystem.model.AdminModel;
import loc.aliar.monitoringsystem.model.DoctorModel;
import loc.aliar.monitoringsystem.model.PatientModel;
import loc.aliar.monitoringsystem.service.SecurityService;
import loc.aliar.monitoringsystem.service.admin.AdminDoctorService;
import loc.aliar.monitoringsystem.service.admin.AdminPatientService;
import loc.aliar.monitoringsystem.service.admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static loc.aliar.monitoringsystem.domain.Role.ID_ROLES;

@Service
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService {
    private final AdminPatientService adminPatientService;
    private final AdminDoctorService adminDoctorService;
    private final AdminService adminService;

    @Override
    public User getUser() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        Optional<Object> user = Optional.ofNullable(authentication.getPrincipal());

        return user
                .filter(User.class::isInstance)
                .map(User.class::cast)
                .orElseThrow(() -> new UserNotAuthenticatedException("User is not authenticated"));
    }

    @Override
    public AdminModel getAdminModel() {
        return adminService.get(getUser().getId());
    }

    @Override
    public DoctorModel getDoctorModel() {
        return adminDoctorService.get(getUser().getId());
    }

    @Override
    public PatientModel getPatientModel() {
        return adminPatientService.get(getUser().getId());
    }

    @Override
    public Role.Roles getRole() {
        return ID_ROLES.get(getUser().getRole().getId());
    }

    @Override
    public boolean isSuperAdmin() {
        return Role.Roles.SUPER_ADMIN.equals(getRole());
    }

    @Override
    public boolean isAdmin() {
        return Role.Roles.ADMIN.equals(getRole());
    }

    @Override
    public boolean isDoctor() {
        return Role.Roles.DOCTOR.equals(getRole());
    }

    @Override
    public boolean isPatient() {
        return Role.Roles.PATIENT.equals(getRole());
    }
}
