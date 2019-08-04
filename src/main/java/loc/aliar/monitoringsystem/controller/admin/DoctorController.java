package loc.aliar.monitoringsystem.controller.admin;

import loc.aliar.monitoringsystem.domain.Doctor;
import loc.aliar.monitoringsystem.model.DoctorModel;
import loc.aliar.monitoringsystem.service.admin.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller("adminDoctorController")
@RequestMapping("admin/doctors")
@RequiredArgsConstructor
public class DoctorController implements BaseAdminController<Doctor, DoctorModel> {
    private final AdminDoctorService service;
    private final PositionService positionService;
    private final DegreeService degreeService;
    private final SpecializationService specializationService;

    @GetMapping
    public String index(Model model) {
        return indexDefault(model);
    }

    @GetMapping("add")
    public String create(Model model) {
        return createDefault(model
                .addAttribute("positions", positionService.getAll())
                .addAttribute("degrees", degreeService.getAll())
                .addAttribute("specializations", specializationService.getAll()));
    }

    @PostMapping
    public String create(@Valid DoctorModel model, BindingResult bindingResult) {
        return createDefault(model, bindingResult);
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        return editDefault(id, model);
    }

    @PutMapping("{id}")
    public String edit(@PathVariable Long id, @Valid DoctorModel model, BindingResult bindingResult) {
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
