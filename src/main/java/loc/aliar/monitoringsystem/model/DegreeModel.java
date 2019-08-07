package loc.aliar.monitoringsystem.model;

import loc.aliar.monitoringsystem.repository.DegreeRepository;
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
public class DegreeModel implements IdAble {
    private Long id;

    @NotEmpty
    @Size(min = 4, max = 30)
    @Unique(DegreeRepository.class)
    private String name;
}
