package loc.aliar.monitoringsystem.controller;

import loc.aliar.monitoringsystem.config.Constants;
import loc.aliar.monitoringsystem.model.CardioMedicalInfoModel;
import loc.aliar.monitoringsystem.model.ChartDataRequest;
import loc.aliar.monitoringsystem.model.DoctorModel;
import loc.aliar.monitoringsystem.service.*;
import loc.aliar.monitoringsystem.service.admin.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {
    private static final String HTML_FOLDER = "doctor";

    private final SecurityService securityService;
    private final PatientService patientService;
    private final CardioReadingService cardioReadingService;
    private final CardioMedInfoService cardioMedInfoService;
    private final MedicalInfoService medicalInfoService;
    private final LoadTypeService loadTypeService;

    private final DoctorService doctorService;
    private final PositionService positionService;
    private final DegreeService degreeService;
    private final SpecializationService specializationService;

    @GetMapping
    public String index(Model model, HttpSession session) {
        Integer depId = (Integer) session.getAttribute(Constants.DEP_ATTR);
        Long doctorId = securityService.getId();
        model.addAttribute(patientService.getCardsByDoctorId(doctorId, depId));
        return HTML_FOLDER + "/index";
    }

    @GetMapping("/{patientId}")
    public String showPatient(@PathVariable Long patientId, Model model, HttpSession session) {
        Long doctorId = securityService.getId();
        if (!doctorService.isDoctorPatient(doctorId, patientId)) {
            return "redirect:";
        }
        Integer depId = (Integer) session.getAttribute(Constants.DEP_ATTR);
        setAdditionAttributesForPatient(model, patientId, depId);
        return HTML_FOLDER + "/patient";
    }

    private void setAdditionAttributesForPatient(Model model, Long patientId, Integer depId) {
        model
                .addAttribute(cardioReadingService.getByPatientId(patientId))
                .addAttribute(medicalInfoService.getByPatientIdAndDepartmentId(patientId, depId))
                .addAttribute(patientService.get(patientId))
                .addAttribute(loadTypeService.getAll())
                .addAttribute(new ChartDataRequest());
    }

    @PutMapping("/{patientId}")
    public String editPatient(
            @PathVariable Long patientId,
            @Valid CardioMedicalInfoModel cardioMedicalInfoModel,
            BindingResult bindingResult,
            Model model,
            HttpSession session
    ) {
        Long doctorId = securityService.getId();
        if (!doctorService.isDoctorPatient(doctorId, patientId)) {
            return "redirect:";
        }
        Integer depId = (Integer) session.getAttribute(Constants.DEP_ATTR);

        if (bindingResult.hasErrors()) {
            setAdditionAttributesForPatient(model, patientId, depId);
            return HTML_FOLDER + "/patient";
        }

        cardioMedInfoService.save(patientId, cardioMedicalInfoModel);
        return "redirect:" + patientId;
    }

    @GetMapping("/personal")
    public String showPersonal(Model model) {
        Long doctorId = securityService.getId();
        setAdditionalAttributesForDoctor(model);
        model.addAttribute(doctorService.get(doctorId));
        return HTML_FOLDER + "/personal";
    }

    private void setAdditionalAttributesForDoctor(Model model) {
        model
                .addAttribute(positionService.getAll())
                .addAttribute(degreeService.getAll())
                .addAttribute(specializationService.getAll());
    }

    @PutMapping("/personal")
    public String editPersonal(@Valid DoctorModel doctorModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            setAdditionalAttributesForDoctor(model);
            return HTML_FOLDER + "/personal";
        }
        Long doctorId = securityService.getId();
        doctorService.save(doctorId, doctorModel);
        return "redirect:personal";
    }
}
