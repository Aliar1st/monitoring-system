package loc.aliar.monitoringsystem.controller.admin;

import loc.aliar.monitoringsystem.config.Constants;
import loc.aliar.monitoringsystem.domain.Doctor;
import loc.aliar.monitoringsystem.model.DoctorModel;
import loc.aliar.monitoringsystem.service.SecurityService;
import loc.aliar.monitoringsystem.service.admin.*;
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
public class DoctorController implements BaseAdminController<Doctor, DoctorModel> {
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
            @Valid DoctorModel entityModel, BindingResult bindingResult,
            Model model, HttpSession session) {
        return createDefault(entityModel, bindingResult, model, session);
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model, HttpSession session) {
        return editDefault(id, model, session);
    }

    @PutMapping("{id}")
    public String edit(
            @PathVariable Long id, @Valid DoctorModel entityModel, BindingResult bindingResult,
            Model model, HttpSession session) {
        return editDefault(id, entityModel, bindingResult, model, session);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id) {
        return deleteDefault(id);
    }

    @Override
    public void prepareModelToSave(DoctorModel entityModel, HttpSession session) {
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
    public Class<DoctorModel> getModelClass() {
        return DoctorModel.class;
    }

    @Override
    public CrudService<Doctor, DoctorModel> getCrudService() {
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
