package loc.aliar.monitoringsystem.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CardioMedicalInfo extends AbstractModel {

    @Column(columnDefinition = "text", nullable = false)
    private String basicDiagnosis;

    @Column(columnDefinition = "text")
    private String concomitantDiagnosis;

    @Column(columnDefinition = "text")
    private String operations;

    @Column(columnDefinition = "text")
    private String oslozhneniye;
    private Short kdoLzh;
    private Short ksoLzh;
    private Short imm;
    private Short fv;
    private Short ksoLp;
    private Short ksoPp;
    private Short sdla;

    @Column(length = 20)
    private String diastDisf;

    @Column(length = 20)
    private String lokalnSokr;

    @Column(length = 10)
    private String khmEkg;

    @Column(length = 50)
    private String osnRitm;

    @Column(length = 20)
    private String nzhaNzhtzhaZht;

    @Column(length = 20)
    private String zhaZht;

    @Column(length = 15)
    private String sumIshemiya;

    @Column(length = 30)
    private String ekgRitm;

    @Column(length = 100)
    private String narRitma;

    @Column(length = 100)
    private String narprovodimosti;

    @Column(length = 10)
    private String st;

    @Column(length = 10)
    private String tolerantnost;

    @Column(length = 100)
    private String prichinaPrekrashch;
    private Short prodolzhNagruzki;
    private Double okh;
    private Double lpnp;
    private Double lpvp;
    private Double tg;
    private Double alt;
    private Double ast;
    private Double glyu;
    private Double kr;

    @Column(columnDefinition = "text")
    private String medikamentyGruppy;

    @Column(length = 100)
    private String kag;

    @Embedded
    private PatientDiseaseAttitude patientDiseaseAttitude;

    @ManyToOne
    private Patient patient;

    @Builder
    public CardioMedicalInfo(
            Long id, String basicDiagnosis, String concomitantDiagnosis, String operations,
            String oslozhneniye, Short kdoLzh, Short ksoLzh, Short imm, Short fv, Short ksoLp,
            Short ksoPp, Short sdla, String diastDisf, String lokalnSokr, String khmEkg,
            String osnRitm, String zhaZht, String sumIshemiya, String ekgRitm, String narRitma,
            String narprovodimosti, String st, String tolerantnost, String prichinaPrekrashch,
            Short prodolzhNagruzki, Double okh, Double lpnp, Double lpvp, Double tg, Double alt,
            Double ast, Double glyu, Double kr, String medikamentyGruppy, String kag,
            PatientDiseaseAttitude patientDiseaseAttitude, Patient patient) {
        super(id);
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
        this.patientDiseaseAttitude = patientDiseaseAttitude;
        this.patient = patient;
    }

    public PatientDiseaseAttitude getPatientDiseaseAttitude() {
        return patientDiseaseAttitude != null ? patientDiseaseAttitude : new PatientDiseaseAttitude();
    }
}
