package loc.aliar.monitoringsystem.service.impl;

import loc.aliar.monitoringsystem.domain.*;
import loc.aliar.monitoringsystem.exception.DepartmentException;
import loc.aliar.monitoringsystem.exception.UserNotAuthenticatedException;
import loc.aliar.monitoringsystem.model.AdminModel;
import loc.aliar.monitoringsystem.model.DoctorModel;
import loc.aliar.monitoringsystem.model.PatientModel;
import loc.aliar.monitoringsystem.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static loc.aliar.monitoringsystem.domain.Role.ID_ROLES;

@Service
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService {
    private final ConversionService conversionService;

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
    public Admin getAdmin() {
        return getUser().getAdmin();
    }

    @Override
    public Doctor getDoctor() {
        return getUser().getDoctor();
    }

    @Override
    public Patient getPatient() {
        return getUser().getPatient();
    }

    @Override
    public AdminModel getAdminModel() {
        return conversionService.convert(getUser().getAdmin(), AdminModel.class);
    }

    @Override
    public DoctorModel getDoctorModel() {
        return conversionService.convert(getUser().getDoctor(), DoctorModel.class);
    }

    @Override
    public PatientModel getPatientModel() {
        return conversionService.convert(getUser().getPatient(), PatientModel.class);
    }

    @Override
    public Integer getDepartmentId() {
        if (true) return 1;

        User user = getUser();
        Role.Roles role = ID_ROLES.get(user.getRole().getId());

        switch (role){
            case ADMIN:
                return user.getAdmin().getDepartment().getId();
            case DOCTOR:
                return user.getDoctor().getDepartment().getId();
        }

        throw new DepartmentException("User is neither admin or doctor, department can not be defined");
    }

    @Override
    public Role.Roles getRole() {
        return ID_ROLES.get(getUser().getRole().getId());
    }

    @Override
    public boolean isSuperAdmin() {
        if (true) return true;
        return Role.Roles.SUPER_ADMIN.equals(getRole());
    }

    @Override
    public boolean isAdmin() {
        if (true) return true;
        return Role.Roles.ADMIN.equals(getRole());
    }

    @Override
    public boolean isDoctor() {
        if (true) return true;
        return Role.Roles.DOCTOR.equals(getRole());
    }

    @Override
    public boolean isPatient() {
        if (true) return true;
        return Role.Roles.PATIENT.equals(getRole());
    }
}
