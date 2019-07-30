package loc.aliar.monitoringsystem.service.admin.impl;

import loc.aliar.monitoringsystem.domain.Load;
import loc.aliar.monitoringsystem.model.LoadModel;
import loc.aliar.monitoringsystem.repository.LoadRepository;
import loc.aliar.monitoringsystem.service.admin.LoadService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoadServiceImpl implements LoadService {
    private final LoadRepository repository;
    private final ConversionService conversionService;

    @Override
    public JpaRepository<Load, Long> getRepository() {
        return repository;
    }

    @Override
    public ConversionService getConversationService() {
        return conversionService;
    }

    @Override
    public Class<Load> getEntityClass() {
        return Load.class;
    }

    @Override
    public Class<LoadModel> getModelClass() {
        return LoadModel.class;
    }
}
