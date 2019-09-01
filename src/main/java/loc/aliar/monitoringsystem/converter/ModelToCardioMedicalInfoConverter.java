package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.CardioMedicalInfo;
import loc.aliar.monitoringsystem.domain.PatientDiseaseAttitude;
import loc.aliar.monitoringsystem.model.CardioMedicalInfoModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ModelToCardioMedicalInfoConverter implements Converter<CardioMedicalInfoModel, CardioMedicalInfo> {
    @Override
    public CardioMedicalInfo convert(CardioMedicalInfoModel source) {
        return CardioMedicalInfo.builder()
                .id(source.getId())
                .basicDiagnosis(source.getBasicDiagnosis())
                .concomitantDiagnosis(source.getConcomitantDiagnosis())
                .operations(source.getOperations())
                .oslozhneniye(source.getOslozhneniye())
                .kdoLzh(source.getKdoLzh())
                .ksoLzh(source.getKsoLzh())
                .imm(source.getImm())
                .fv(source.getFv())
                .ksoLp(source.getKsoLp())
                .ksoPp(source.getKsoPp())
                .sdla(source.getSdla())
                .diastDisf(source.getDiastDisf())
                .lokalnSokr(source.getLokalnSokr())
                .khmEkg(source.getKhmEkg())
                .osnRitm(source.getOsnRitm())
                .nzhaNzhtzhaZht(source.getNzhaNzhtzhaZht())
                .zhaZht(source.getZhaZht())
                .sumIshemiya(source.getSumIshemiya())
                .ekgRitm(source.getEkgRitm())
                .narRitma(source.getNarRitma())
                .narprovodimosti(source.getNarprovodimosti())
                .st(source.getSt())
                .tolerantnost(source.getTolerantnost())
                .prichinaPrekrashch(source.getPrichinaPrekrashch())
                .prodolzhNagruzki(source.getProdolzhNagruzki())
                .okh(source.getOkh())
                .lpnp(source.getLpnp())
                .lpvp(source.getLpvp())
                .tg(source.getTg())
                .alt(source.getAlt())
                .ast(source.getAst())
                .glyu(source.getGlyu())
                .kr(source.getKr())
                .medikamentyGruppy(source.getMedikamentyGruppy())
                .kag(source.getKag())
                .patientDiseaseAttitude(PatientDiseaseAttitude.builder()
                        .harmonious(source.getHarmonious())
                        .ergopatial(source.getErgopatial())
                        .anognocy(source.getAnognocy())
                        .disturbing(source.getDisturbing())
                        .hypochondriacal(source.getHypochondriacal())
                        .neurasthenic(source.getNeurasthenic())
                        .melancholy(source.getMelancholy())
                        .apathetic(source.getApathetic())
                        .sentimental(source.getSentimental())
                        .self_centered(source.getSelf_centered())
                        .paranoid(source.getParanoid())
                        .dysphoric(source.getDysphoric())
                        .personality_type(source.getPersonality_type())
                        .type_relationship(source.getType_relationship())
                        .build())
                .build();
    }
}
