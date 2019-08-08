package loc.aliar.monitoringsystem.controller;

import loc.aliar.monitoringsystem.controller.admin.BaseAdminController;
import loc.aliar.monitoringsystem.domain.Department;
import loc.aliar.monitoringsystem.domain.Patient;
import loc.aliar.monitoringsystem.model.PatientModel;
import loc.aliar.monitoringsystem.service.PatientService;
import loc.aliar.monitoringsystem.service.SecurityService;
import loc.aliar.monitoringsystem.service.admin.AdminPatientService;
import loc.aliar.monitoringsystem.service.admin.CrudService;
import loc.aliar.monitoringsystem.service.admin.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static loc.aliar.monitoringsystem.domain.Department.ID_DEPARTMENTS;

@Controller
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController implements BaseAdminController {
    private final AdminPatientService service;
    private final PatientService patientService;
    private final EducationService educationService;
    private final SecurityService securityService;

    @GetMapping
    public String index(Model model) {
        model
//                .addAttribute("patient", securityService.getPatient())
                .addAttribute("educations", educationService.getAll());
//                .addAttribute(getCrudService().getAll());
        //return "patient/index";
        return indexDefault(model);
    }

    @GetMapping("/{depId}")
    public String depIndex(@PathVariable Integer depId, Model model) {
        model
                .addAttribute("medicalInfo", patientService.getMedicalInfo(depId));
        return "";
    }

    @Override
    public Class<PatientModel> getModelClass() {
        return PatientModel.class;
    }

    @Override
    public CrudService<Patient, PatientModel> getCrudService() {
        return service;
    }

    @Override
    public String getHtmlFolder() {
        return "patient/";
    }

    @Override
    public String getRedirectToRootPath() {
        return "redirect:/patient";
    }
}
