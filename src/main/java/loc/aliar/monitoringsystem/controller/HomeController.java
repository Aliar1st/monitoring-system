package loc.aliar.monitoringsystem.controller;

import loc.aliar.monitoringsystem.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static loc.aliar.monitoringsystem.domain.Role.*;

@RequiredArgsConstructor
@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(@AuthenticationPrincipal User user) {
        if (user == null) {
            return "redirect:/login";
        }

        switch (ID_ROLES.get(user.getRole().getId())){
            case SUPER_ADMIN:
                return "";
            case ADMIN:
                return "redirect:/admin";
            case DOCTOR:
                return "redirect:/doctor";
            case PATIENT:
                return "redirect:/patient";
        }

        throw new IllegalStateException("Unknown role");
    }
}
