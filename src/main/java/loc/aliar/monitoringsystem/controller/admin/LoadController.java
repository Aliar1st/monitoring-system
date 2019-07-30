package loc.aliar.monitoringsystem.controller.admin;

import loc.aliar.monitoringsystem.domain.Load;
import loc.aliar.monitoringsystem.model.LoadModel;
import loc.aliar.monitoringsystem.service.admin.CrudService;
import loc.aliar.monitoringsystem.service.admin.LoadService;
import loc.aliar.monitoringsystem.service.admin.LoadTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("admin/loads")
@RequiredArgsConstructor
public class LoadController implements BaseAdminController<Load, LoadModel> {
    private final LoadService service;
    private final LoadTypeService loadTypeService;

    @GetMapping
    public String index(Model model) {
        return indexDefault(model);
    }

    @GetMapping("add")
    public String create(Model model) {
        return createDefault(model
                .addAttribute("loadTypes", loadTypeService.getAll()));
    }

    @PostMapping
    public String create(@Valid LoadModel model, BindingResult bindingResult) {
        return createDefault(model, bindingResult);
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        return editDefault(id, model);
    }

    @PutMapping("{id}")
    public String edit(@PathVariable Long id, @Valid LoadModel model, BindingResult bindingResult) {
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
    public Class<LoadModel> getModelClass() {
        return LoadModel.class;
    }

    @Override
    public CrudService<Load, LoadModel> getCrudService() {
        return service;
    }

    @Override
    public String getHtmlFolder() {
        return "admin/loads/";
    }

    @Override
    public String getRedirectToRootPath() {
        return "redirect:/admin/loads";
    }
}
