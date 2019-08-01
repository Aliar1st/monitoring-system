package loc.aliar.monitoringsystem.controller.admin;

import loc.aliar.monitoringsystem.domain.Patient;
import loc.aliar.monitoringsystem.model.DoctorModel;
import loc.aliar.monitoringsystem.model.PatientModel;
import loc.aliar.monitoringsystem.service.SecurityService;
import loc.aliar.monitoringsystem.service.admin.AdminDoctorService;
import loc.aliar.monitoringsystem.service.admin.AdminPatientService;
import loc.aliar.monitoringsystem.service.admin.CrudService;
import loc.aliar.monitoringsystem.service.admin.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController("adminPatientController")
@RequestMapping("admin/patients")
@RequiredArgsConstructor
public class PatientController implements BaseAdminController<Patient, PatientModel> {
    private final AdminPatientService service;
    private final EducationService educationService;
    private final AdminDoctorService adminDoctorService;
    private final SecurityService securityService;

    @GetMapping
    public String index(Model model) {
        return indexDefault(model);
    }

    @GetMapping("add")
    public String create(Model model) {
        Integer departmentId = securityService.getDepartmentId();
        List<DoctorModel> doctors = adminDoctorService.getAllByDepartmentId(departmentId);
        return createDefault(model
                .addAttribute("doctors", doctors)
                .addAttribute("educations", educationService.getAll()));
    }

    @PostMapping
    public String create(@Valid PatientModel model, BindingResult bindingResult) {
        return createDefault(model, bindingResult);
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        return editDefault(id, model);
    }

    @PutMapping("{id}")
    public String edit(@PathVariable Long id, @Valid PatientModel model, BindingResult bindingResult) {
        return editDefault(id, model, bindingResult);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id) {
        return deleteDefault(id);
    }

    @Override
    public String getEntityName() {
        return "entity";
    }

    @Override
    public String getEntitiesName() {
        return "entities";
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
        return "admin/patients/";
    }

    @Override
    public String getRedirectToRootPath() {
        return "redirect:/admin/patients";
    }
}
