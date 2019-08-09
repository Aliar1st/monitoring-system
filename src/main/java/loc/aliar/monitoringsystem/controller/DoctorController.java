package loc.aliar.monitoringsystem.controller;

import loc.aliar.monitoringsystem.service.PatientService;
import loc.aliar.monitoringsystem.service.ReadingService;
import loc.aliar.monitoringsystem.service.SecurityService;
import loc.aliar.monitoringsystem.service.admin.AdminPatientService;
import loc.aliar.monitoringsystem.service.admin.CardioMedInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {
    private final SecurityService securityService;
    private final PatientService patientService;
    private final AdminPatientService adminPatientService;
    private final ReadingService readingService;
    private final CardioMedInfoService cardioMedInfoService;

    @GetMapping
    public String index(Model model) {
//        Long doctorId = securityService.getDoctor().getId();
//        model.addAttribute(patientService.getAllByDoctorId(doctorId));

        model
                .addAttribute(adminPatientService.getAll());

        return "doctor/index";
    }

    @GetMapping("/{id}")
    public String showPatient(@PathVariable Long id, Model model) {

        model
                .addAttribute(readingService.getLastByPatientId(1L))
                .addAttribute(adminPatientService.get(1L));

        return "";
    }
}
