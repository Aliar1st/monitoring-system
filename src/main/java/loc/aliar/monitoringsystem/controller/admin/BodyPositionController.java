package loc.aliar.monitoringsystem.controller.admin;

import loc.aliar.monitoringsystem.domain.BodyPosition;
import loc.aliar.monitoringsystem.model.BodyPositionModel;
import loc.aliar.monitoringsystem.service.admin.BodyPositionService;
import loc.aliar.monitoringsystem.service.admin.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("admin/body-positions")
@RequiredArgsConstructor
public class BodyPositionController implements BaseAdminController<BodyPosition, BodyPositionModel> {
    private final BodyPositionService service;

    @GetMapping
    public String index(Model model) {
        return indexDefault(model);
    }

    @GetMapping("add")
    public String create(Model model) {
        return createDefault(model);
    }

    @PostMapping
    public String create(@Valid BodyPositionModel model, BindingResult bindingResult) {
        return createDefault(model, bindingResult);
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        return editDefault(id, model);
    }

    @PutMapping("{id}")
    public String edit(@PathVariable Long id, @Valid BodyPositionModel model, BindingResult bindingResult) {
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
    public Class<BodyPositionModel> getModelClass() {
        return BodyPositionModel.class;
    }

    @Override
    public CrudService<BodyPosition, BodyPositionModel> getCrudService() {
        return service;
    }

    @Override
    public String getHtmlFolder() {
        return "admin/body-positions/";
    }

    @Override
    public String getRedirectToRootPath() {
        return "redirect:/admin/body-positions";
    }
}
