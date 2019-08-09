package loc.aliar.monitoringsystem.model;

import loc.aliar.monitoringsystem.repository.PositionRepository;
import loc.aliar.monitoringsystem.validation.annotation.Unique;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PositionModel implements IdAble {
    private Long id;

    @NotEmpty
    @Size(min = 4, max = 70)
    @Unique(PositionRepository.class)
    private String name;
}
