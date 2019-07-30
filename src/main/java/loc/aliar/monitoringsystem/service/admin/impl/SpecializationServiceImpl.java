package loc.aliar.monitoringsystem.service.admin.impl;

import loc.aliar.monitoringsystem.domain.Specialization;
import loc.aliar.monitoringsystem.model.SpecializationModel;
import loc.aliar.monitoringsystem.repository.SpecializationRepository;
import loc.aliar.monitoringsystem.service.admin.SpecializationService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpecializationServiceImpl implements SpecializationService {
    private final SpecializationRepository repository;
    private final ConversionService conversionService;

    @Override
    public JpaRepository<Specialization, Long> getRepository() {
        return repository;
    }

    @Override
    public ConversionService getConversationService() {
        return conversionService;
    }

    @Override
    public Class<Specialization> getEntityClass() {
        return Specialization.class;
    }

    @Override
    public Class<SpecializationModel> getModelClass() {
        return SpecializationModel.class;
    }
}
