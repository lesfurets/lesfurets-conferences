package com.lesfurets.db.dao;

import com.lesfurets.model.FicheAuto;
import org.jooq.Record7;
import org.jooq.Record8;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static com.lesfurets.db.tables.FichesAuto.FICHES_AUTO;
import static org.jooq.impl.DSL.trueCondition;

public class FicheAutoDAO extends DAO {

    public FicheAutoDAO(Connection connection) {
        super(connection);
    }

    public FicheAuto selectRecentFiche(Integer statut) throws Exception {
        return DSL
                .using(connection)
                .select(FICHES_AUTO.ID,
                        FICHES_AUTO.OFFRE_UID,
                        FICHES_AUTO.CREATION_DATE,
                        FICHES_AUTO.CREATION_TIME,
                        FICHES_AUTO.CODE_POSTAL,
                        FICHES_AUTO.EMAIL,
                        FICHES_AUTO.CODE_SRA,
                        FICHES_AUTO.STATUT)
                .from(FICHES_AUTO)
                .where(statut == null ? trueCondition() : FICHES_AUTO.STATUT.gt(statut))
                .orderBy(FICHES_AUTO.STATUT.desc())
                .limit(1)
                .stream()
                .map(this::mapFicheAuto)
                .findFirst()
                .orElseThrow(() -> new Exception("No fiche for " + statut));
    }

    private FicheAuto mapFicheAuto(Record8<Integer, String, LocalDate, String, String, String, String, Integer> record) {
        LocalTime localTime = record.get(FICHES_AUTO.CREATION_TIME, LocalTime.class);
        System.out.println(localTime);
        return new FicheAuto(
                FICHES_AUTO.ID.get(record),
                FICHES_AUTO.OFFRE_UID.get(record),
                FICHES_AUTO.CREATION_DATE.get(record),
                FICHES_AUTO.CODE_POSTAL.get(record),
                FICHES_AUTO.EMAIL.get(record),
                FICHES_AUTO.CODE_SRA.get(record),
                FICHES_AUTO.STATUT.get(record));
    }

}
