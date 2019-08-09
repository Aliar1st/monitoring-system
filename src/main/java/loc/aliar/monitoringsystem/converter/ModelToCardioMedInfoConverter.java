package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.CardioMedicalInfo;
import loc.aliar.monitoringsystem.model.CardioMedicalInfoModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ModelToCardioMedInfoConverter implements Converter<CardioMedicalInfoModel, CardioMedicalInfo> {
    @Override
    public CardioMedicalInfo convert(CardioMedicalInfoModel source) {
        return null;
    }
}
