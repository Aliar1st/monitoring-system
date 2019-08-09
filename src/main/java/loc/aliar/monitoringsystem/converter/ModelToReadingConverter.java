package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.BodyPosition;
import loc.aliar.monitoringsystem.domain.Load;
import loc.aliar.monitoringsystem.domain.Reading;
import loc.aliar.monitoringsystem.domain.Statement;
import loc.aliar.monitoringsystem.model.ReadingModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ModelToReadingConverter implements Converter<ReadingModel, Reading> {
    @Override
    public Reading convert(ReadingModel source) {
        return Reading.builder()
                .id(source.getId())
                .weight(source.getWeight())
                .growth(source.getGrowth())
                .duration(source.getDuration())
                .load(new Load(source.getLoadId()))
                .bodyPosition(new BodyPosition(source.getBodyPositionId()))
                .statement(new Statement(source.getStatementId()))
                .build();
    }
}
