package loc.aliar.monitoringsystem.service.admin.impl;

import loc.aliar.monitoringsystem.domain.BodyPosition;
import loc.aliar.monitoringsystem.model.BodyPositionModel;
import loc.aliar.monitoringsystem.repository.BodyPositionRepository;
import loc.aliar.monitoringsystem.service.admin.BodyPositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BodyPositionServiceImpl implements BodyPositionService {
    private final BodyPositionRepository repository;
    private final ConversionService conversionService;

    @Override
    public JpaRepository<BodyPosition, Long> getRepository() {
        return repository;
    }

    @Override
    public ConversionService getConversationService() {
        return conversionService;
    }

    @Override
    public Class<BodyPosition> getEntityClass() {
        return BodyPosition.class;
    }

    @Override
    public Class<BodyPositionModel> getModelClass() {
        return BodyPositionModel.class;
    }
}
