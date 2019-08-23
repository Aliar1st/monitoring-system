package loc.aliar.monitoringsystem.controller.admin;

import loc.aliar.monitoringsystem.model.IdAble;
import loc.aliar.monitoringsystem.service.admin.CrudService;
import lombok.SneakyThrows;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpSession;

public interface BaseAdminController<E, M extends IdAble> {
    default String indexDefault(Model model) {
        model.addAttribute(getCrudService().getAll());
        return getHtmlFolder() + "index";
    }

    @SneakyThrows
    default String createDefault(Model model) {
        model.addAttribute(getModelClass().newInstance());
        setAdditionAttributes(model);
        return getHtmlFolder() + "create";
    }

    @SneakyThrows
    default String createDefault(Model model, HttpSession session) {
        model.addAttribute(getModelClass().newInstance());
        setAdditionAttributes(model, session);
        return getHtmlFolder() + "create";
    }

    default String createDefault(M entityModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return getHtmlFolder() + "create";
        }

        getCrudService().save(entityModel);

        return getRedirectToRootPath();
    }

    default String createDefault(M entityModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            setAdditionAttributes(model);
            return getHtmlFolder() + "create";
        }

        getCrudService().save(entityModel);

        return getRedirectToRootPath();
    }

    default String createDefault(M entityModel, BindingResult bindingResult, Model model, HttpSession session) {
        if (bindingResult.hasErrors()) {
            setAdditionAttributes(model, session);
            return getHtmlFolder() + "create";
        }

        prepareModelToSave(entityModel, session);
        getCrudService().save(entityModel);

        return getRedirectToRootPath();
    }

    default String editDefault(Long id, Model model) {
        model.addAttribute(getCrudService().get(id));
        setAdditionAttributes(model);
        return getHtmlFolder() + "edit";
    }

    default String editDefault(Long id, Model model, HttpSession session) {
        model.addAttribute(getCrudService().get(id));
        setAdditionAttributes(model, session);
        return getHtmlFolder() + "edit";
    }

    default String editDefault(Long id, M entityModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return getHtmlFolder() + "edit";
        }

        entityModel.setId(id);
        getCrudService().save(entityModel);

        return getRedirectToRootPath();
    }

    default String editDefault(Long id, M entityModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            setAdditionAttributes(model);
            return getHtmlFolder() + "edit";
        }

        entityModel.setId(id);
        getCrudService().save(entityModel);

        return getRedirectToRootPath();
    }

    default String editDefault(Long id, M entityModel, BindingResult bindingResult, Model model, HttpSession session) {
        if (bindingResult.hasErrors()) {
            setAdditionAttributes(model, session);
            return getHtmlFolder() + "edit";
        }

        entityModel.setId(id);
        prepareModelToSave(entityModel, session);
        getCrudService().save(entityModel);

        return getRedirectToRootPath();
    }

    default String deleteDefault(Long id) {
        getCrudService().delete(id);

        return getRedirectToRootPath();
    }

    default void prepareModelToSave(M entityModel, HttpSession session) { }

    default void setAdditionAttributes(Model model) { }

    default void setAdditionAttributes(Model model, HttpSession session) { }

    Class<M> getModelClass();

    CrudService<E, M> getCrudService();

    String getHtmlFolder();

    String getRedirectToRootPath();
}
