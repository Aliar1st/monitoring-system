package loc.aliar.monitoringsystem.controller.admin;

import loc.aliar.monitoringsystem.domain.Degree;
import loc.aliar.monitoringsystem.model.DegreeModel;
import loc.aliar.monitoringsystem.service.admin.CrudService;
import loc.aliar.monitoringsystem.service.admin.DegreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("admin/degrees")
@RequiredArgsConstructor
public class DegreeController implements BaseAdminController<Degree, DegreeModel> {
    private final DegreeService service;

    @GetMapping
    public String index(Model model) {
        return indexDefault(model);
    }

    @GetMapping("add")
    public String create(Model model) {
        return createDefault(model);
    }

    @PostMapping
    public String create(@Valid DegreeModel model, BindingResult bindingResult) {
        return createDefault(model, bindingResult);
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        return editDefault(id, model);
    }

    @PutMapping("{id}")
    public String edit(@PathVariable Long id, @Valid DegreeModel model, BindingResult bindingResult) {
        return editDefault(id, model, bindingResult);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id) {
        return deleteDefault(id);
    }

    @Override
    public Class<DegreeModel> getModelClass() {
        return DegreeModel.class;
    }

    @Override
    public CrudService<Degree, DegreeModel> getCrudService() {
        return service;
    }

    @Override
    public String getHtmlFolder() {
        return "admin/degrees/";
    }

    @Override
    public String getRedirectToRootPath() {
        return "redirect:/admin/degrees";
    }
}
