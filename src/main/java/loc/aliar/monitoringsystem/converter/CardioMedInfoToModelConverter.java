package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.CardioMedicalInfo;
import loc.aliar.monitoringsystem.model.CardioMedicalInfoModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CardioMedInfoToModelConverter implements Converter<CardioMedicalInfo, CardioMedicalInfoModel> {
    @Override
    public CardioMedicalInfoModel convert(CardioMedicalInfo source) {
        return CardioMedicalInfoModel.builder()
                .id(source.getId())
                .basicDiagnosis(source.getBasicDiagnosis())
                .build();
    }
}
