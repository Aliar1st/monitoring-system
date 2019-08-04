package loc.aliar.monitoringsystem.controller.admin;

import loc.aliar.monitoringsystem.model.IdAble;
import loc.aliar.monitoringsystem.service.admin.CrudService;
import lombok.SneakyThrows;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

public interface BaseAdminController<E, M extends IdAble> {
    default String indexDefault(Model model) {
        model.addAttribute(getEntitiesName(), getCrudService().getAll());
        return getHtmlFolder() + "index";
    }

    @SneakyThrows
    default String createDefault(Model model) {
        model.addAttribute(getModelClass().getSimpleName(), getModelClass().newInstance());
        return getHtmlFolder() + "create";
    }

    default String createDefault(M model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return getHtmlFolder() + "create";
        }

        getCrudService().save(model);

        return getRedirectToRootPath();
    }

    default String editDefault(Long id, Model model) {
        model.addAttribute(getModelClass().getSimpleName(), getCrudService().get(id));
        return getHtmlFolder() + "edit";
    }

    default String editDefault(Long id, M model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return getHtmlFolder() + "edit";
        }

        model.setId(id);
        getCrudService().save(model);

        return getRedirectToRootPath();
    }

    default String deleteDefault(Long id) {
        getCrudService().delete(id);

        return getRedirectToRootPath();
    }

    default String getEntityName() {
        return "entity";
    }

    default String getEntitiesName() {
        return "entities";
    }

    Class<M> getModelClass();

    CrudService<E, M> getCrudService();

    String getHtmlFolder();

    String getRedirectToRootPath();
}
