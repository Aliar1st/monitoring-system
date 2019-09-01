package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.CardioReading;
import loc.aliar.monitoringsystem.domain.LoadType;
import loc.aliar.monitoringsystem.model.CardioReadingModel;
import loc.aliar.monitoringsystem.utils.ObjectUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ReadingToModelConverter implements Converter<CardioReading, CardioReadingModel> {
    @Override
    public CardioReadingModel convert(CardioReading source) {
        return CardioReadingModel.builder()
                .id(source.getId())
                .weight(source.getWeight())
                .growth(source.getGrowth())
                .duration(source.getDuration())
                .borg(source.getStatement().getBorgResult())
                .date(source.getCreatedDate().orElse(null))
                .loadName(source.getLoad().getName())
                .loadTypeName(ObjectUtils.nullSafe(source.getLoad().getLoadType(), LoadType::getName))
                .recommendation(source.getStatement().getRecommendation())
                .loadId(source.getLoad().getId())
                .bodyPositionId(source.getBodyPosition().getId())
                .statementId(source.getStatement().getId())
                .build();
    }
}
