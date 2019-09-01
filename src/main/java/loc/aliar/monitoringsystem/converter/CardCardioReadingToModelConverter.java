package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.projection.CardioCard;
import loc.aliar.monitoringsystem.model.CardioCardModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CardCardioReadingToModelConverter implements Converter<CardioCard, CardioCardModel> {
    @Override
    public CardioCardModel convert(CardioCard source) {
        return CardioCardModel.builder()
                .id(source.getId())
                .lastReadingDate(source.getLastReadingDate())
                .lastReadingBorg(source.getLastReadingBorg())
                .dateOfBirth(source.getDateOfBirth())
                .fullName(source.getFullName())
                .photo(source.getPhoto())
                .build();
    }
}
