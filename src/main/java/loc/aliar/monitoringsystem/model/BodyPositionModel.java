package loc.aliar.monitoringsystem.model;

import loc.aliar.monitoringsystem.repository.BodyPositionRepository;
import loc.aliar.monitoringsystem.validation.annotation.Unique;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BodyPositionModel implements IdAble {
    private Long id;

    @NotEmpty
    @Size(min = 3, max = 20)
    @Unique(BodyPositionRepository.class)
    private String name;
}
