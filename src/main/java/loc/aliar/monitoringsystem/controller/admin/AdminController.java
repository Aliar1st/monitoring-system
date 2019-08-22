package loc.aliar.monitoringsystem.controller.admin;

import loc.aliar.monitoringsystem.config.Constants;
import loc.aliar.monitoringsystem.domain.Admin;
import loc.aliar.monitoringsystem.model.AdminModel;
import loc.aliar.monitoringsystem.service.SecurityService;
import loc.aliar.monitoringsystem.service.admin.AdminService;
import loc.aliar.monitoringsystem.service.admin.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("admin/admins")
@RequiredArgsConstructor
public class AdminController implements BaseAdminController<Admin, AdminModel> {
    private final AdminService service;
    private final SecurityService securityService;

    @GetMapping
    public String index(Model model) {
        return indexDefault(model);
    }

    @GetMapping("add")
    public String create(Model model, HttpSession session) {
        return createDefault(model, session);
    }

    @PostMapping
    public String create(
            @Valid AdminModel entityModel, BindingResult bindingResult,
            Model model, HttpSession session) {
        return createDefault(entityModel, bindingResult, model, session);
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model, HttpSession session) {
        return editDefault(id, model, session);
    }

    @PutMapping("{id}")
    public String edit(
            @PathVariable Long id, @Valid AdminModel entityModel, BindingResult bindingResult,
            Model model, HttpSession session) {
        return editDefault(id, entityModel, bindingResult, model, session);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id) {
        return deleteDefault(id);
    }

    @Override
    public void prepareModelToSave(AdminModel entityModel, HttpSession session) {
        if (!securityService.isSuperAdmin()) {
            entityModel.setDepartmentId((Integer) session.getAttribute(Constants.DEP_ATTR));
        }
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
