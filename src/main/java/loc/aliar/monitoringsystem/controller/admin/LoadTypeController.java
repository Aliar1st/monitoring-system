package loc.aliar.monitoringsystem.controller.admin;

import loc.aliar.monitoringsystem.domain.LoadType;
import loc.aliar.monitoringsystem.model.LoadTypeModel;
import loc.aliar.monitoringsystem.service.admin.CrudService;
import loc.aliar.monitoringsystem.service.admin.LoadTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("admin/load-types")
@RequiredArgsConstructor
public class LoadTypeController implements BaseAdminController<LoadType, LoadTypeModel> {
    private final LoadTypeService service;

    @GetMapping
    public String index(Model model) {
        return indexDefault(model);
    }

    @GetMapping("add")
    public String create(Model model) {
        return createDefault(model);
    }

    @PostMapping
    public String create(@Valid LoadTypeModel model, BindingResult bindingResult) {
        return createDefault(model, bindingResult);
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        return editDefault(id, model);
    }

    @PutMapping("{id}")
    public String edit(@PathVariable Long id, @Valid LoadTypeModel model, BindingResult bindingResult) {
        return editDefault(id, model, bindingResult);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id) {
        return deleteDefault(id);
    }

    @Override
    public Class<LoadTypeModel> getModelClass() {
        return LoadTypeModel.class;
    }

    @Override
    public CrudService<LoadType, LoadTypeModel> getCrudService() {
        return service;
    }

    @Override
    public String getHtmlFolder() {
        return "admin/load-types/";
    }

    @Override
    public String getRedirectToRootPath() {
        return "redirect:/admin/load-types";
    }
}
