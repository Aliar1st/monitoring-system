package loc.aliar.monitoringsystem.service.admin.impl;

import loc.aliar.monitoringsystem.domain.Statement;
import loc.aliar.monitoringsystem.model.StatementModel;
import loc.aliar.monitoringsystem.repository.StatementRepository;
import loc.aliar.monitoringsystem.service.admin.StatementService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatementServiceImpl implements StatementService {
    private final StatementRepository repository;
    private final ConversionService conversionService;

    @Override
    public JpaRepository<Statement, Long> getRepository() {
        return repository;
    }

    @Override
    public ConversionService getConversationService() {
        return conversionService;
    }

    @Override
    public Class<Statement> getEntityClass() {
        return Statement.class;
    }

    @Override
    public Class<StatementModel> getModelClass() {
        return StatementModel.class;
    }
}
