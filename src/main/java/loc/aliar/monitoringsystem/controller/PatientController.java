package loc.aliar.monitoringsystem.controller;

import loc.aliar.monitoringsystem.config.Constants;
import loc.aliar.monitoringsystem.model.PatientModel;
import loc.aliar.monitoringsystem.service.MedicalInfoService;
import loc.aliar.monitoringsystem.service.PatientService;
import loc.aliar.monitoringsystem.service.SecurityService;
import loc.aliar.monitoringsystem.service.admin.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {
    private static final String HTML_FOLDER = "patient";

    private final SecurityService securityService;
    private final PatientService patientService;
    private final MedicalInfoService medicalInfoService;
    private final EducationService educationService;

    @GetMapping
    public String index(HttpSession session, Model model) {
        Integer depId = (Integer) session.getAttribute(Constants.DEP_ATTR);
        Long patientId = securityService.getId();
        if (!patientService.isRegisteredInDepartment(patientId, depId)) {
            return "redirect:/auth/choose-department";
        }
        setAdditionAttributes(model, depId);
        return HTML_FOLDER + "/index";
    }

    @PutMapping
    public String edit(
            @Valid PatientModel patientModel, BindingResult bindingResult, Model model, HttpSession session
    ) {
        Integer depId = (Integer) session.getAttribute(Constants.DEP_ATTR);

        if (bindingResult.hasErrors()) {
            setAdditionAttributes(model, depId);
            return HTML_FOLDER + "/index";
        }

        Long patientId = securityService.getId();
        patientService.save(patientId, patientModel);
        return "redirect:";
    }

    private void setAdditionAttributes(Model model, Integer departmentId) {
        PatientModel patientModel = securityService.getPatientModel();
        model
                .addAttribute(patientModel)
                .addAttribute(medicalInfoService.getByPatientIdAndDepartmentId(patientModel.getId(), departmentId))
                .addAttribute(educationService.getAll());
    }
}
