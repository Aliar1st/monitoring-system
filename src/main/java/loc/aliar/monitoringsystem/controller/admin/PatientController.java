package loc.aliar.monitoringsystem.controller.admin;

import loc.aliar.monitoringsystem.config.Constants;
import loc.aliar.monitoringsystem.domain.Patient;
import loc.aliar.monitoringsystem.model.AdminPatientModel;
import loc.aliar.monitoringsystem.service.CrudService;
import loc.aliar.monitoringsystem.service.admin.AdminDoctorService;
import loc.aliar.monitoringsystem.service.admin.AdminPatientService;
import loc.aliar.monitoringsystem.service.admin.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller("adminPatientController")
@RequestMapping("admin/patients")
@RequiredArgsConstructor
public class PatientController implements BaseAdminController<Patient, AdminPatientModel> {
    private final AdminPatientService service;
    private final EducationService educationService;
    private final AdminDoctorService adminDoctorService;

    @GetMapping
    public String index(Model model, HttpSession session) {
        Integer depId = (Integer) session.getAttribute(Constants.DEP_ATTR);
        model.addAttribute(service.getAllByDepartmentId(depId));
        return getHtmlFolder() + INDEX_TEMPLATE_NAME;
    }

    @GetMapping("add")
    public String create(Model model, HttpSession session) {
        return createDefault(model, session);
    }

    @PostMapping
    public String create(
            @Valid AdminPatientModel entityModel, BindingResult bindingResult,
            Model model, HttpSession session) {
        return createDefault(entityModel, bindingResult, model, session);
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model, HttpSession session) {
        return editDefault(id, model, session);
    }

    @PutMapping("{id}")
    public String edit(
            @PathVariable Long id, @Valid AdminPatientModel entityModel, BindingResult bindingResult,
            Model model, HttpSession session) {
        return editDefault(id, entityModel, bindingResult, model, session);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id) {
        return deleteDefault(id);
    }

    @Override
    public void setAdditionAttributes(Model model, HttpSession session) {
        Integer depId = (Integer) session.getAttribute(Constants.DEP_ATTR);
        model
                .addAttribute(adminDoctorService.getAllByDepartmentId(depId))
                .addAttribute(educationService.getAll());
    }

    @Override
    public Class<AdminPatientModel> getModelClass() {
        return AdminPatientModel.class;
    }

    @Override
    public CrudService<Patient, AdminPatientModel> getCrudService() {
        return service;
    }

    @Override
    public String getHtmlFolder() {
        return "admin/patients/";
    }

    @Override
    public String getRedirectToRootPath() {
        return "redirect:/admin/patients";
    }
}
