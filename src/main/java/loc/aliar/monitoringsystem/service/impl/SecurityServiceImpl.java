package loc.aliar.monitoringsystem.service.impl;

import loc.aliar.monitoringsystem.domain.Role;
import loc.aliar.monitoringsystem.domain.User;
import loc.aliar.monitoringsystem.exception.UserNotAuthenticatedException;
import loc.aliar.monitoringsystem.model.AdminModel;
import loc.aliar.monitoringsystem.model.DoctorModel;
import loc.aliar.monitoringsystem.model.PatientModel;
import loc.aliar.monitoringsystem.service.DoctorService;
import loc.aliar.monitoringsystem.service.PatientService;
import loc.aliar.monitoringsystem.service.SecurityService;
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
    private final PatientService patientService;
    private final DoctorService doctorService;
    private final AdminService adminService;

    @Override
    public User getUser() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        Optional<Object> user = Optional.ofNullable(authentication.getPrincipal());

        return user
                .filter(User.class::isInstance)
                .map(User.class::cast)
                .orElseThrow(UserNotAuthenticatedException::new);
    }

    @Override
    public Long getId() {
        return getUser().getId();
    }

    @Override
    public AdminModel getAdminModel() {
        return adminService.get(getId());
    }

    @Override
    public DoctorModel getDoctorModel() {
        return doctorService.get(getId());
    }

    @Override
    public PatientModel getPatientModel() {
        return patientService.get(getId());
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
