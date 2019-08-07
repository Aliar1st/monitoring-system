package loc.aliar.monitoringsystem.repository;

public abstract class Queries {
    private Queries() {
    }

    static final String READ_MESSAGES =
            "UPDATE Message m " +
            "   SET m.isRead = true " +
            " WHERE m.isRead = false " +
            "   AND m.fromUser.id = ?1 " +
            "   AND m.toUser.id = ?2";

    static final String PATIENT_ACTIVITY_REPORT =
            "SELECT CONCAT(d.first_name, CONCAT(' ', d.last_name)) doctor " +
            "     , CONCAT(gi.first_name, CONCAT(' ', gi.last_name)) patient " +
            " 	  , COUNT(r.id) count_interval " +
            "     , (SELECT COUNT(r.id) FROM readings r WHERE r.patient_id = p.id) count_all " +
            "     , (SELECT max(r.date) FROM readings r WHERE r.patient_id = p.id) last_date " +
            "   FROM patients p " +
            "   JOIN general_information gi ON gi.id = p.general_information_id " +
            "   JOIN doctors d ON d.id = p.doctor_id " +
            "   LEFT JOIN readings r ON r.patient_id = p.id " +
            "   WHERE r.date BETWEEN ?1 AND ?2 " +
            "   OR r.id IS NULL " +
            "   GROUP BY p.id " +
            "   ORDER BY doctor, count_interval";

    static final String MESSAGE_ACTIVITY_REPORT =
            "SELECT CONCAT(d.first_name, CONCAT(' ', d.last_name)) doctor " +
            "     , (SELECT COUNT(dm.id) " +
            "          FROM messages dm " +
            "         WHERE dm.FROM_user_id = du.id " +
            "           AND dm.to_user_id = pu.id " +
            "           AND dm.created_at BETWEEN ?1 AND ?2) doctor_mes " +
            "     , CONCAT(gi.first_name, CONCAT(' ', gi.last_name)) patient " +
            "     , (SELECT COUNT(pm.id) " +
            "          FROM messages pm " +
            "         WHERE pm.FROM_user_id = pu.id " +
            "           AND pm.to_user_id = du.id " +
            "           AND pm.created_at BETWEEN ?1 AND ?2) patient_mes " +
            "   FROM doctors" +
            "   JOIN patients p ON p.doctor_id = d.id " +
            "   JOIN general_information gi ON gi.id = p.general_information_id " +
            "   JOIN users du ON du.id = d.user_id " +
            "   JOIN users pu ON pu.id = p.user_id " +
            "  ORDER BY doctor, patient";

    static final String TREND_CHANGE_REPORT =
            "SELECT doctor, patient, (100 / yMin * yMax - 100) percent, yMin, yMax " +
            "  FROM " +
            "       (SELECT doctor, patient, " +
            "               minx xLineMin, a + b * minx yMin, " +
            "               maxx xLineMax, a + b * maxx yMax " +
            "          FROM " +
            "               (SELECT doctor, patient, minx, maxx, " +
            "			     (sy * sxx - sx * sxy) / (n * sxx - sx * sx) a, " +
            "                (n * sxy - sx * sy) / (n * sxx - sx * sx) b " +
            "                  FROM " +
            "                       (SELECT CONCAT(d.first_name, CONCAT(' ', d.last_name)) doctor " +
            "				              , CONCAT(gi.first_name, CONCAT(' ', gi.last_name)) patient " +
            "				              , SUM(s.borg_result) sy " +
            "				              , SUM(TO_DAYS(r.date) - @d := TO_DAYS(?1)) sx " +
            "				              , SUM(POW(TO_DAYS(r.date) - @d, 2)) sxx " +
            "				              , SUM(POW(s.borg_result, 2)) syy " +
            "				              , SUM(s.borg_result * (TO_DAYS(r.date) - @d)) sxy " +
            "				              , MIN(TO_DAYS(r.date) - @d) minx, MAX(TO_DAYS(r.date) - @d) maxx " +
            "				              , COUNT(*) n " +
            "                          FROM patients p " +
            "                          JOIN general_information gi ON gi.id = p.general_information_id " +
            "                          JOIN doctors d ON d.id = p.doctor_id " +
            "                          LEFT JOIN readings r ON r.patient_id = p.id " +
            "                          LEFT JOIN loads l ON l.id = r.load_id " +
            "                          LEFT JOIN statements s ON s.id = l.statement_id " +
            "                         WHERE r.date BETWEEN ?1 and ?2 " +
            "                         GROUP BY p.id " +
            "		                ) sums " +
            "	            ) rho " +
            "       ) res " +
            "ORDER BY doctor, percent desc";
}
