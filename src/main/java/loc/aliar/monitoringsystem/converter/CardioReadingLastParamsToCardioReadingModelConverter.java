package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.projection.CardioReadingLastParams;
import loc.aliar.monitoringsystem.model.CardioReadingModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CardioReadingLastParamsToCardioReadingModelConverter
        implements Converter<CardioReadingLastParams, CardioReadingModel> {
    @Override
    public CardioReadingModel convert(CardioReadingLastParams source) {
        return CardioReadingModel.builder()
                .growth(source.getGrowth())
                .weight(source.getWeight())
                .build();
    }
}
