package com.lesfurets.db.dao;

import org.jooq.impl.DSL;

import java.sql.Connection;

import static com.lesfurets.db.tables.FichesAuto.FICHES_AUTO;
import static org.jooq.impl.DSL.trueCondition;

public class FicheAutoDAO {

    public String readXmlArchive(Connection conn, String offreUid, String provider, Integer statut)
            throws Exception {
        String xml = DSL
                .using(conn)
                .select(FICHES_AUTO.ID)
                .select(FICHES_AUTO.OFFRE_UID)
                .select(FICHES_AUTO.STATUT)
                .select(FICHES_AUTO.XML)
                .from(FICHES_AUTO)
                .where(FICHES_AUTO.OFFRE_UID.equal(offreUid))
                .and(provider == null ? trueCondition() : FICHES_AUTO.PROVIDER.equal(provider))
                .and(statut == null ? trueCondition() : FICHES_AUTO.STATUT.equal(statut))
                .orderBy(FICHES_AUTO.ID.desc(), FICHES_AUTO.STATUT.desc())
                .limit(1)
                .fetchOptional()
                .orElseThrow(() -> new Exception(offreUid)).get(FICHES_AUTO.XML);
        if (xml == null || xml.isEmpty()) {
            throw new Exception(offreUid);
        }
        return xml;
    }

}
