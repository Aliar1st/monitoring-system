package loc.aliar.monitoringsystem.controller.admin;

import loc.aliar.monitoringsystem.domain.Education;
import loc.aliar.monitoringsystem.model.EducationModel;
import loc.aliar.monitoringsystem.service.admin.CrudService;
import loc.aliar.monitoringsystem.service.admin.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("admin/educations")
@RequiredArgsConstructor
public class EducationController implements BaseAdminController<Education, EducationModel> {
    private final EducationService service;

    @GetMapping
    public String index(Model model) {
        return indexDefault(model);
    }

    @GetMapping("add")
    public String create(Model model) {
        return createDefault(model);
    }

    @PostMapping
    public String create(@Valid EducationModel model, BindingResult bindingResult) {
        return createDefault(model, bindingResult);
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        return editDefault(id, model);
    }

    @PutMapping("{id}")
    public String edit(@PathVariable Long id, @Valid EducationModel model, BindingResult bindingResult) {
        return editDefault(id, model, bindingResult);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id) {
        return deleteDefault(id);
    }

    @Override
    public Class<EducationModel> getModelClass() {
        return EducationModel.class;
    }

    @Override
    public CrudService<Education, EducationModel> getCrudService() {
        return service;
    }

    @Override
    public String getHtmlFolder() {
        return "admin/educations/";
    }

    @Override
    public String getRedirectToRootPath() {
        return "redirect:/admin/educations";
    }
}
