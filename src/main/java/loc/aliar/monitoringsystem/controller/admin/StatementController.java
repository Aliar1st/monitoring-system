package loc.aliar.monitoringsystem.controller.admin;

import loc.aliar.monitoringsystem.domain.Statement;
import loc.aliar.monitoringsystem.model.StatementModel;
import loc.aliar.monitoringsystem.service.admin.CrudService;
import loc.aliar.monitoringsystem.service.admin.StatementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("admin/statements")
@RequiredArgsConstructor
public class StatementController implements BaseAdminController<Statement, StatementModel> {
    private final StatementService service;

    @GetMapping
    public String index(Model model) {
        return indexDefault(model);
    }

    @GetMapping("add")
    public String create(Model model) {
        return createDefault(model);
    }

    @PostMapping
    public String create(@Valid StatementModel model, BindingResult bindingResult) {
        return createDefault(model, bindingResult);
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        return editDefault(id, model);
    }

    @PutMapping("{id}")
    public String edit(@PathVariable Long id, @Valid StatementModel model, BindingResult bindingResult) {
        return editDefault(id, model, bindingResult);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id) {
        return deleteDefault(id);
    }

    @Override
    public Class<StatementModel> getModelClass() {
        return StatementModel.class;
    }

    @Override
    public CrudService<Statement, StatementModel> getCrudService() {
        return service;
    }

    @Override
    public String getHtmlFolder() {
        return "admin/statements/";
    }

    @Override
    public String getRedirectToRootPath() {
        return "redirect:/admin/statements";
    }
}
