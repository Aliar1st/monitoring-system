package loc.aliar.monitoringsystem.controller.admin;

import loc.aliar.monitoringsystem.config.Constants;
import loc.aliar.monitoringsystem.domain.Doctor;
import loc.aliar.monitoringsystem.model.AdminDoctorModel;
import loc.aliar.monitoringsystem.service.CrudService;
import loc.aliar.monitoringsystem.service.SecurityService;
import loc.aliar.monitoringsystem.service.admin.AdminDoctorService;
import loc.aliar.monitoringsystem.service.admin.DegreeService;
import loc.aliar.monitoringsystem.service.admin.PositionService;
import loc.aliar.monitoringsystem.service.admin.SpecializationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller("adminDoctorController")
@RequestMapping("admin/doctors")
@RequiredArgsConstructor
public class DoctorController implements BaseAdminController<Doctor, AdminDoctorModel> {
    private final AdminDoctorService service;
    private final PositionService positionService;
    private final DegreeService degreeService;
    private final SpecializationService specializationService;
    private final SecurityService securityService;

    @GetMapping
    public String index(Model model) {
        return indexDefault(model);
    }

    @GetMapping("add")
    public String create(Model model, HttpSession session) {
        return createDefault(model, session);
    }

    @PostMapping
    public String create(
            @Valid AdminDoctorModel entityModel, BindingResult bindingResult,
            Model model, HttpSession session) {
        return createDefault(entityModel, bindingResult, model, session);
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model, HttpSession session) {
        return editDefault(id, model, session);
    }

    @PutMapping("{id}")
    public String edit(
            @PathVariable Long id, @Valid AdminDoctorModel entityModel, BindingResult bindingResult,
            Model model, HttpSession session) {
        return editDefault(id, entityModel, bindingResult, model, session);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id) {
        return deleteDefault(id);
    }

    @Override
    public void prepareModelToSave(AdminDoctorModel entityModel, HttpSession session) {
        if (!securityService.isSuperAdmin()) {
            entityModel.setDepartmentId((Integer) session.getAttribute(Constants.DEP_ATTR));
        }
    }

    @Override
    public void setAdditionAttributes(Model model, HttpSession session) {
        model
                .addAttribute("positions", positionService.getAll())
                .addAttribute("degrees", degreeService.getAll())
                .addAttribute("specializations", specializationService.getAll());
    }

    @Override
    public Class<AdminDoctorModel> getModelClass() {
        return AdminDoctorModel.class;
    }

    @Override
    public CrudService<Doctor, AdminDoctorModel> getCrudService() {
        return service;
    }

    @Override
    public String getHtmlFolder() {
        return "admin/doctors/";
    }

    @Override
    public String getRedirectToRootPath() {
        return "redirect:/admin/doctors";
    }
}
