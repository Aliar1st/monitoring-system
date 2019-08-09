package loc.aliar.monitoringsystem.model;

import loc.aliar.monitoringsystem.repository.PatientRepository;
import loc.aliar.monitoringsystem.validation.annotation.Exists;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
@NoArgsConstructor
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
    @Size(max = 20) private String nzhaNzhtzhaZht;
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
    @Min(0) private Double kr;private String medikamentyGruppy;

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

    @Builder
    public CardioMedicalInfoModel(
            Long id, String basicDiagnosis, String concomitantDiagnosis, String operations,
            String oslozhneniye, Short kdoLzh, Short ksoLzh, Short imm, Short fv, Short ksoLp, Short ksoPp, Short sdla,
            String diastDisf, String lokalnSokr, String khmEkg, String osnRitm, String nzhaNzhtzhaZht, String zhaZht,
            String sumIshemiya, String ekgRitm, String narRitma, String narprovodimosti, String st, String tolerantnost,
            String prichinaPrekrashch, Short prodolzhNagruzki, Double okh, Double lpnp, Double lpvp, Double tg,
            Double alt, Double ast, Double glyu, Double kr, String medikamentyGruppy, String kag, Byte harmonious,
            Byte ergopatial, Byte anognocy, Byte disturbing, Byte hypochondriacal, Byte neurasthenic, Byte melancholy,
            Byte apathetic, Byte sentimental, Byte self_centered, Byte paranoid, Byte dysphoric,
            String personality_type, String type_relationship, Long patientId) {
        this.id = id;
        this.basicDiagnosis = basicDiagnosis;
        this.concomitantDiagnosis = concomitantDiagnosis;
        this.operations = operations;
        this.oslozhneniye = oslozhneniye;
        this.kdoLzh = kdoLzh;
        this.ksoLzh = ksoLzh;
        this.imm = imm;
        this.fv = fv;
        this.ksoLp = ksoLp;
        this.ksoPp = ksoPp;
        this.sdla = sdla;
        this.diastDisf = diastDisf;
        this.lokalnSokr = lokalnSokr;
        this.khmEkg = khmEkg;
        this.osnRitm = osnRitm;
        this.nzhaNzhtzhaZht = nzhaNzhtzhaZht;
        this.zhaZht = zhaZht;
        this.sumIshemiya = sumIshemiya;
        this.ekgRitm = ekgRitm;
        this.narRitma = narRitma;
        this.narprovodimosti = narprovodimosti;
        this.st = st;
        this.tolerantnost = tolerantnost;
        this.prichinaPrekrashch = prichinaPrekrashch;
        this.prodolzhNagruzki = prodolzhNagruzki;
        this.okh = okh;
        this.lpnp = lpnp;
        this.lpvp = lpvp;
        this.tg = tg;
        this.alt = alt;
        this.ast = ast;
        this.glyu = glyu;
        this.kr = kr;
        this.medikamentyGruppy = medikamentyGruppy;
        this.kag = kag;
        this.harmonious = harmonious;
        this.ergopatial = ergopatial;
        this.anognocy = anognocy;
        this.disturbing = disturbing;
        this.hypochondriacal = hypochondriacal;
        this.neurasthenic = neurasthenic;
        this.melancholy = melancholy;
        this.apathetic = apathetic;
        this.sentimental = sentimental;
        this.self_centered = self_centered;
        this.paranoid = paranoid;
        this.dysphoric = dysphoric;
        this.personality_type = personality_type;
        this.type_relationship = type_relationship;
        this.patientId = patientId;
    }
}
