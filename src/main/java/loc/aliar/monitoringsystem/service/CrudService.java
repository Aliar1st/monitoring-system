package loc.aliar.monitoringsystem.service;

import loc.aliar.monitoringsystem.exception.EntityNotFoundException;
import loc.aliar.monitoringsystem.model.IdAble;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
public interface CrudService<E, M extends IdAble> {
    default M get(Long id) {
        E entity = getRepository().findById(id).orElseThrow(
                () -> new EntityNotFoundException(getEntityClass().getSimpleName(), id));
        return convertToModel(entity);
    }

    default List<M> getAll(){
        List<E> entities = getRepository().findAll();
        return convertToModelList(entities);
    }

    default M save(M model){
        E entity = getRepository().save(convertToEntity(model));
        return convertToModel(entity);
    }

    default M save(Long id, M model){
        E oldEntity = getRepository().findById(id).orElseThrow(
                () -> new EntityNotFoundException(getEntityClass().getSimpleName(), id));

        BeanUtils.copyProperties(convertToEntity(model), oldEntity, getIgnoreCopyProperties());
        oldEntity = getRepository().save(oldEntity);
        return convertToModel(oldEntity);
    }

    default void delete(Long id){
        getRepository().deleteById(id);
    }

    default List<M> convertToModelList(List<E> entities) {
        return entities.parallelStream()
                .map(this::convertToModel)
                .collect(Collectors.toList());
    }

    default E convertToEntity(M model) {
        return getConversationService().convert(model, getEntityClass());
    }

    default M convertToModel(E entity) {
        return getConversationService().convert(entity, getModelClass());
    }

    default String[] getIgnoreCopyProperties() {
        return new String[]{IdAble.ID_COLUMN};
    }

    JpaRepository<E, Long> getRepository();

    ConversionService getConversationService();

    Class<E> getEntityClass();

    Class<M> getModelClass();
}
