package loc.aliar.monitoringsystem.service.admin.impl;

import loc.aliar.monitoringsystem.domain.Degree;
import loc.aliar.monitoringsystem.model.DegreeModel;
import loc.aliar.monitoringsystem.repository.DegreeRepository;
import loc.aliar.monitoringsystem.service.admin.DegreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DegreeServiceImpl implements DegreeService {
    private final DegreeRepository repository;
    private final ConversionService conversionService;

    @Override
    public JpaRepository<Degree, Long> getRepository() {
        return repository;
    }

    @Override
    public ConversionService getConversationService() {
        return conversionService;
    }

    @Override
    public Class<Degree> getEntityClass() {
        return Degree.class;
    }

    @Override
    public Class<DegreeModel> getModelClass() {
        return DegreeModel.class;
    }
}
