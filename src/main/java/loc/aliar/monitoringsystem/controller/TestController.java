package loc.aliar.monitoringsystem.controller;

import loc.aliar.monitoringsystem.domain.Admin;
import loc.aliar.monitoringsystem.domain.Department;
import loc.aliar.monitoringsystem.domain.User;
import loc.aliar.monitoringsystem.repository.AdminRepository;
import loc.aliar.monitoringsystem.repository.EducationRepository;
import loc.aliar.monitoringsystem.repository.RoleRepository;
import loc.aliar.monitoringsystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final AdminRepository adminRepository;
    private final EducationRepository educationRepository;

    @GetMapping("")
    public String m() {
        User u = User.builder()
                .username("11111111")
                .password("11111111")
                .role(roleRepository.getOne(1L))
                .build();
        userRepository.save(u);

        Admin a = Admin.builder()
                .department(new Department(1))
                .user(u)
                .build();
        adminRepository.save(a);

        System.out.println(u);
        System.out.println(a);

        return  "1";
    }
}
