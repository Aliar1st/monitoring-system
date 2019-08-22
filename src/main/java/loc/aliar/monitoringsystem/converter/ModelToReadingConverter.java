package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.*;
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
                .patient(new Patient(source.getPatientId()))
                .build();
    }
}
