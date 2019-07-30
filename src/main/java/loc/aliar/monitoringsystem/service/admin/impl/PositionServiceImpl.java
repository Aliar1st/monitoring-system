package loc.aliar.monitoringsystem.service.admin.impl;

import loc.aliar.monitoringsystem.domain.Position;
import loc.aliar.monitoringsystem.model.PositionModel;
import loc.aliar.monitoringsystem.repository.PositionRepository;
import loc.aliar.monitoringsystem.service.admin.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {
    private final PositionRepository repository;
    private final ConversionService conversionService;

    @Override
    public JpaRepository<Position, Long> getRepository() {
        return repository;
    }

    @Override
    public ConversionService getConversationService() {
        return conversionService;
    }

    @Override
    public Class<Position> getEntityClass() {
        return Position.class;
    }

    @Override
    public Class<PositionModel> getModelClass() {
        return PositionModel.class;
    }
}
