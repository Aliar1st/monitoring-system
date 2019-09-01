package loc.aliar.monitoringsystem.controller;

import loc.aliar.monitoringsystem.config.Constants;
import loc.aliar.monitoringsystem.domain.Department;
import loc.aliar.monitoringsystem.domain.User;
import loc.aliar.monitoringsystem.exception.DepartmentNotFoundException;
import loc.aliar.monitoringsystem.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

import static loc.aliar.monitoringsystem.domain.Role.ID_ROLES;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final SecurityService securityService;

    @GetMapping("/")
    public String index(@AuthenticationPrincipal User user, HttpSession session) {
        switch (ID_ROLES.get(user.getRole().getId())) {
            case SUPER_ADMIN:
            case PATIENT:
                return "redirect:/auth/choose-department";
            case ADMIN:
                session.setAttribute(Constants.DEP_ATTR, securityService.getAdminModel().getDepartmentId());
                return "redirect:/admin/patients";
            case DOCTOR:
                session.setAttribute(Constants.DEP_ATTR, securityService.getDoctorModel().getDepartmentId());
                return "redirect:/doctor";
            default:
                throw new IllegalStateException("Unknown role");
        }
    }

    @GetMapping("/auth/choose-department")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN', 'PATIENT')")
    public String chooseDep() {
        return "auth/choose_department";
    }

    @PostMapping("/auth/choose-department")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN', 'PATIENT')")
    public String chooseDep(@AuthenticationPrincipal User user, HttpSession session, Integer departmentId) {
        if (!Department.ID_DEPARTMENTS.containsKey(departmentId)) {
            throw new DepartmentNotFoundException(departmentId);
        }
        session.setAttribute(Constants.DEP_ATTR, departmentId);
        switch (ID_ROLES.get(user.getRole().getId())) {
            case SUPER_ADMIN:
                return "redirect:/admin/admins";
            case PATIENT:
                return "redirect:/patient";
            default:
                throw new IllegalStateException("Unknown role");
        }
    }
}
