package loc.aliar.monitoringsystem.controller.admin;

import loc.aliar.monitoringsystem.domain.Position;
import loc.aliar.monitoringsystem.model.PositionModel;
import loc.aliar.monitoringsystem.service.admin.CrudService;
import loc.aliar.monitoringsystem.service.admin.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("admin/positions")
@RequiredArgsConstructor
public class PositionController implements BaseAdminController<Position, PositionModel> {
    private final PositionService service;

    @GetMapping
    public String index(Model model) {
        return indexDefault(model);
    }

    @GetMapping("add")
    public String create(Model model) {
        return createDefault(model);
    }

    @PostMapping
    public String create(@Valid PositionModel entityModel, BindingResult bindingResult) {
        return createDefault(entityModel, bindingResult);
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        return editDefault(id, model);
    }

    @PutMapping("{id}")
    public String edit(@PathVariable Long id, @Valid PositionModel entityModel, BindingResult bindingResult) {
        return editDefault(id, entityModel, bindingResult);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id) {
        return deleteDefault(id);
    }

    @Override
    public Class<PositionModel> getModelClass() {
        return PositionModel.class;
    }

    @Override
    public CrudService<Position, PositionModel> getCrudService() {
        return service;
    }

    @Override
    public String getHtmlFolder() {
        return "admin/positions/";
    }

    @Override
    public String getRedirectToRootPath() {
        return "redirect:/admin/positions";
    }
}
