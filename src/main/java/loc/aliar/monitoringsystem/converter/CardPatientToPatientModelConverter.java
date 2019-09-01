package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.projection.CardPatient;
import loc.aliar.monitoringsystem.model.PatientModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CardPatientToPatientModelConverter implements Converter<CardPatient, PatientModel> {
    @Override
    public PatientModel convert(CardPatient source) {
        return PatientModel.builder()
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .photoUrl(source.getPhoto())
                .dateOfBirth(source.getDateOfBirth())
                .build();
    }
}
