package loc.aliar.monitoringsystem.controller;

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
    private final EducationRepository educationRepository;

    @GetMapping("")
    public String m() {


        return  "1";
    }
}
