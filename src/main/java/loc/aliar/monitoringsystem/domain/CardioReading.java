package loc.aliar.monitoringsystem.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NamedEntityGraph(name = CardioReading.NEWG_W_ALL_EX_PATIENT, attributeNodes = {
        @NamedAttributeNode(value = "load", subgraph = CardioReading.NESG_W_LOADTYPE),
        @NamedAttributeNode("bodyPosition"),
        @NamedAttributeNode("statement")
}, subgraphs = {
        @NamedSubgraph(name = CardioReading.NESG_W_LOADTYPE, attributeNodes = {
             @NamedAttributeNode("loadType")
        })
})
public class CardioReading extends AbstractModel {
    public static final String NEWG_W_ALL_EX_PATIENT = "CardioReading.all_ex_patient";
    public static final String NESG_W_LOADTYPE = "CardioReading.Load.loadType";

    @Column(nullable = false)
    private Short duration;

    @Column(nullable = false)
    private Short growth;

    @Column(nullable = false)
    private Short weight;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Patient patient;

    @ManyToOne(optional = false)
    private Load load;

    @ManyToOne(optional = false)
    private BodyPosition bodyPosition;

    @ManyToOne(optional = false)
    private Statement statement;

    @Builder
    public CardioReading(
            Long id, Short duration, Short growth, Short weight, Patient patient,
            Load load, BodyPosition bodyPosition, Statement statement) {
        super(id);
        this.duration = duration;
        this.growth = growth;
        this.weight = weight;
        this.patient = patient;
        this.load = load;
        this.bodyPosition = bodyPosition;
        this.statement = statement;
    }
}
