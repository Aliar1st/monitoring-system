package loc.aliar.monitoringsystem.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientDiseaseAttitude {
    private Byte harmonious;
    private Byte ergopatial;
    private Byte anognocy;
    private Byte disturbing;
    private Byte hypochondriacal;
    private Byte neurasthenic;
    private Byte melancholy;
    private Byte apathetic;
    private Byte sentimental;
    private Byte self_centered;
    private Byte paranoid;
    private Byte dysphoric;

    @Column(length = 20)
    private String personality_type;

    @Column(length = 30)
    private String type_relationship;
}
