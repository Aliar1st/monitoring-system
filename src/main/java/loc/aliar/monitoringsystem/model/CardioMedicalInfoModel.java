package loc.aliar.monitoringsystem.model;

import loc.aliar.monitoringsystem.repository.DepartmentRepository;
import loc.aliar.monitoringsystem.repository.PatientRepository;
import loc.aliar.monitoringsystem.validation.annotation.Exists;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardioMedicalInfoModel {
    private Long id;

    @NotEmpty
    private String basicDiagnosis;
    private String concomitantDiagnosis;
    private String operations;
    private String oslozhneniye;

    @Min(0) private Short kdoLzh;
    @Min(0) private Short ksoLzh;
    @Min(0) private Short imm;
    @Min(0) private Short fv;
    @Min(0) private Short ksoLp;
    @Min(0) private Short ksoPp;
    @Min(0) private Short sdla;

    @Size(max = 20) private String diastDisf;
    @Size(max = 20) private String lokalnSokr;
    @Size(max = 10) private String khmEkg;
    @Size(max = 50) private String osnRitm;
    @Size(max = 20) private String zhaZht;
    @Size(max = 15) private String sumIshemiya;
    @Size(max = 30) private String ekgRitm;
    @Size(max = 100) private String narRitma;
    @Size(max = 100) private String narprovodimosti;
    @Size(max = 10) private String st;
    @Size(max = 10) private String tolerantnost;
    @Size(max = 100) private String prichinaPrekrashch;

    @Min(0) private Short prodolzhNagruzki;
    @Min(0) private Double okh;
    @Min(0) private Double lpnp;
    @Min(0) private Double lpvp;
    @Min(0) private Double tg;
    @Min(0) private Double alt;
    @Min(0) private Double ast;
    @Min(0) private Double glyu;
    @Min(0) private Double kr;
    private String medikamentyGruppy;

    @Size(max = 100) private String kag;

    @Min(0) @Max(100) private Byte harmonious;
    @Min(0) @Max(100) private Byte ergopatial;
    @Min(0) @Max(100) private Byte anognocy;
    @Min(0) @Max(100) private Byte disturbing;
    @Min(0) @Max(100) private Byte hypochondriacal;
    @Min(0) @Max(100) private Byte neurasthenic;
    @Min(0) @Max(100) private Byte melancholy;
    @Min(0) @Max(100) private Byte apathetic;
    @Min(0) @Max(100) private Byte sentimental;
    @Min(0) @Max(100) private Byte self_centered;
    @Min(0) @Max(100) private Byte paranoid;
    @Min(0) @Max(100) private Byte dysphoric;

    @Size(max = 20) private String personality_type;

    @Size(max = 30) private String type_relationship;

    @NotNull
    @Exists(PatientRepository.class)
    private Long patientId;

    @NotNull
    @Exists(DepartmentRepository.class)
    private Integer departmentId;
}
