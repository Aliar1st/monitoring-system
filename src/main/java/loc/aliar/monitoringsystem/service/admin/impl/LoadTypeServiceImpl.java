package loc.aliar.monitoringsystem.service.admin.impl;

import loc.aliar.monitoringsystem.domain.LoadType;
import loc.aliar.monitoringsystem.model.LoadTypeModel;
import loc.aliar.monitoringsystem.repository.LoadTypeRepository;
import loc.aliar.monitoringsystem.service.admin.LoadTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoadTypeServiceImpl implements LoadTypeService {
    private final LoadTypeRepository repository;
    private final ConversionService conversionService;

    @Override
    public JpaRepository<LoadType, Long> getRepository() {
        return repository;
    }

    @Override
    public ConversionService getConversationService() {
        return conversionService;
    }

    @Override
    public Class<LoadType> getEntityClass() {
        return LoadType.class;
    }

    @Override
    public Class<LoadTypeModel> getModelClass() {
        return LoadTypeModel.class;
    }
}
