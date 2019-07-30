package loc.aliar.monitoringsystem.model;

import loc.aliar.monitoringsystem.repository.SpecializationRepository;
import loc.aliar.monitoringsystem.validation.annotation.Unique;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpecializationModel implements IdAble {
    private Long id;

    @NotEmpty
    @Size(min = 4, max = 50)
    @Unique(SpecializationRepository.class)
    private String name;
}
