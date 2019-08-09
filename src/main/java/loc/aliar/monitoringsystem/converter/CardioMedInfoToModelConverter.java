package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.CardioMedicalInfo;
import loc.aliar.monitoringsystem.model.CardioMedicalInfoModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CardioMedInfoToModelConverter implements Converter<CardioMedicalInfo, CardioMedicalInfoModel> {
    @Override
    public CardioMedicalInfoModel convert(CardioMedicalInfo source) {
        return CardioMedicalInfoModel.builder()
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
                .harmonious(source.getPatientDiseaseAttitude().getHarmonious())
                .ergopatial(source.getPatientDiseaseAttitude().getErgopatial())
                .anognocy(source.getPatientDiseaseAttitude().getAnognocy())
                .disturbing(source.getPatientDiseaseAttitude().getDisturbing())
                .hypochondriacal(source.getPatientDiseaseAttitude().getHypochondriacal())
                .neurasthenic(source.getPatientDiseaseAttitude().getNeurasthenic())
                .melancholy(source.getPatientDiseaseAttitude().getMelancholy())
                .apathetic(source.getPatientDiseaseAttitude().getApathetic())
                .sentimental(source.getPatientDiseaseAttitude().getSentimental())
                .self_centered(source.getPatientDiseaseAttitude().getSelf_centered())
                .paranoid(source.getPatientDiseaseAttitude().getParanoid())
                .dysphoric(source.getPatientDiseaseAttitude().getDysphoric())
                .personality_type(source.getPatientDiseaseAttitude().getPersonality_type())
                .type_relationship(source.getPatientDiseaseAttitude().getType_relationship())
                .patientId(source.getPatient().getId())
                .build();
    }
}
