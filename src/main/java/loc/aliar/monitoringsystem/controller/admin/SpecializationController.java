package loc.aliar.monitoringsystem.controller.admin;

import loc.aliar.monitoringsystem.domain.Specialization;
import loc.aliar.monitoringsystem.model.SpecializationModel;
import loc.aliar.monitoringsystem.service.admin.CrudService;
import loc.aliar.monitoringsystem.service.admin.SpecializationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("admin/specializations")
@RequiredArgsConstructor
public class SpecializationController implements BaseAdminController<Specialization, SpecializationModel> {
    private final SpecializationService service;

    @GetMapping
    public String index(Model model) {
        return indexDefault(model);
    }

    @GetMapping("add")
    public String create(Model model) {
        return createDefault(model);
    }

    @PostMapping
    public String create(@Valid SpecializationModel model, BindingResult bindingResult) {
        return createDefault(model, bindingResult);
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        return editDefault(id, model);
    }

    @PutMapping("{id}")
    public String edit(@PathVariable Long id, @Valid SpecializationModel model, BindingResult bindingResult) {
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
    public Class<SpecializationModel> getModelClass() {
        return SpecializationModel.class;
    }

    @Override
    public CrudService<Specialization, SpecializationModel> getCrudService() {
        return service;
    }

    @Override
    public String getHtmlFolder() {
        return "admin/specializations/";
    }

    @Override
    public String getRedirectToRootPath() {
        return "redirect:/admin/specializations";
    }
}
