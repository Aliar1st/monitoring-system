package loc.aliar.monitoringsystem.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    public static final Map<Integer, Departments> ID_DEPARTMENTS = new HashMap<>();

    @Getter
    public enum Departments {
        CARDIO(1);

        private final int id;
        private final Department department;

        Departments(int id) {
            this.id = id;
            this.department = new Department(id);
            ID_DEPARTMENTS.put(id, this);
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, length = 50, nullable = false)
    private String name;

    public Department(Integer id) {
        this.id = id;
    }
}
