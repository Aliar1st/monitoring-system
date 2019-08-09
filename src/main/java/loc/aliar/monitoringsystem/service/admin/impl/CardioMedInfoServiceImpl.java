package loc.aliar.monitoringsystem.service.admin.impl;

import loc.aliar.monitoringsystem.domain.CardioMedicalInfo;
import loc.aliar.monitoringsystem.model.CardioMedicalInfoModel;
import loc.aliar.monitoringsystem.repository.CardioMedicalInfoRepository;
import loc.aliar.monitoringsystem.service.admin.CardioMedInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardioMedInfoServiceImpl implements CardioMedInfoService {
    private final CardioMedicalInfoRepository repository;
    private final ConversionService conversionService;

    @Override
    public JpaRepository<CardioMedicalInfo, Long> getRepository() {
        return repository;
    }

    @Override
    public ConversionService getConversationService() {
        return conversionService;
    }

    @Override
    public Class<CardioMedicalInfo> getEntityClass() {
        return CardioMedicalInfo.class;
    }

    @Override
    public Class<CardioMedicalInfoModel> getModelClass() {
        return CardioMedicalInfoModel.class;
    }

    @Override
    public CardioMedicalInfoModel getByPatientId(Long patientId) {
        return conversionService.convert(repository.findByPatientId(patientId), CardioMedicalInfoModel.class);
    }
}
