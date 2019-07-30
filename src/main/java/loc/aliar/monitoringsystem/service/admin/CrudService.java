package loc.aliar.monitoringsystem.service.admin;

import org.springframework.core.convert.ConversionService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Collectors;

public interface CrudService<E, M> {
    default M get(Long id) {
        E entity = getRepository().getOne(id);
        return getConversationService().convert(entity, getModelClass());
    }

    default List<M> getAll(){
        List<E> entities = getRepository().findAll();
        return convertEntitiesListToModels(entities);
    }

    default M save(M model){
        E entity = getConversationService().convert(model, getEntityClass());
        getRepository().save(entity);
        return getConversationService().convert(entity, getModelClass());
    }

    default void delete(Long id){
        getRepository().deleteById(id);
    }

    default List<M> convertEntitiesListToModels(List<E> entities) {
        return entities.parallelStream()
                .map(e -> getConversationService().convert(e, getModelClass()))
                .collect(Collectors.toList());
    }

    JpaRepository<E, Long> getRepository();

    ConversionService getConversationService();

    Class<E> getEntityClass();

    Class<M> getModelClass();
}
