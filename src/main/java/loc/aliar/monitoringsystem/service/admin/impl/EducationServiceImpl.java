package loc.aliar.monitoringsystem.service.admin.impl;

import loc.aliar.monitoringsystem.domain.Education;
import loc.aliar.monitoringsystem.model.EducationModel;
import loc.aliar.monitoringsystem.repository.EducationRepository;
import loc.aliar.monitoringsystem.service.admin.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EducationServiceImpl implements EducationService {
    private final EducationRepository repository;
    private final ConversionService conversionService;

    @Override
    public JpaRepository<Education, Long> getRepository() {
        return repository;
    }

    @Override
    public ConversionService getConversationService() {
        return conversionService;
    }

    @Override
    public Class<Education> getEntityClass() {
        return Education.class;
    }

    @Override
    public Class<EducationModel> getModelClass() {
        return EducationModel.class;
    }
}
