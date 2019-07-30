package loc.aliar.monitoringsystem.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    @ManyToOne(optional = false)
    private Department department;
}
