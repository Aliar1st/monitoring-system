package loc.aliar.monitoringsystem.controller.admin;

import loc.aliar.monitoringsystem.domain.Admin;
import loc.aliar.monitoringsystem.model.AdminModel;
import loc.aliar.monitoringsystem.service.admin.AdminService;
import loc.aliar.monitoringsystem.service.admin.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("admin/admins")
@RequiredArgsConstructor
public class AdminController implements BaseAdminController<Admin, AdminModel> {
    private final AdminService service;

    @GetMapping
    public String index(Model model) {
        return indexDefault(model);
    }

    @GetMapping("add")
    public String create(Model model) {
        return createDefault(model);
    }

    @PostMapping
    public String create(@Valid AdminModel model, BindingResult bindingResult) {
        return createDefault(model, bindingResult);
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        return editDefault(id, model);
    }

    @PutMapping("{id}")
    public String edit(@PathVariable Long id, @Valid AdminModel model, BindingResult bindingResult) {
        return editDefault(id, model, bindingResult);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id) {
        return deleteDefault(id);
    }

    @Override
    public Class<AdminModel> getModelClass() {
        return AdminModel.class;
    }

    @Override
    public CrudService<Admin, AdminModel> getCrudService() {
        return service;
    }

    @Override
    public String getHtmlFolder() {
        return "admin/admins/";
    }

    @Override
    public String getRedirectToRootPath() {
        return "redirect:/admin/admins";
    }
}
