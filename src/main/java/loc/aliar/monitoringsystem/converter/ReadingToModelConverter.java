package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.Reading;
import loc.aliar.monitoringsystem.model.ReadingModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ReadingToModelConverter implements Converter<Reading, ReadingModel> {
    @Override
    public ReadingModel convert(Reading source) {
        return ReadingModel.builder()
                .id(source.getId())
                .weight(source.getWeight())
                .growth(source.getGrowth())
                .duration(source.getDuration())
                .borg(source.getStatement().getBorgResult())
                .date(source.getCreatedDate().orElse(null))
                .loadName(source.getLoad().getName())
                .loadTypeName(source.getLoad().getLoadType().getName())
                .loadId(source.getLoad().getId())
                .bodyPositionId(source.getBodyPosition().getId())
                .statementId(source.getStatement().getId())
                .build();
    }
}
