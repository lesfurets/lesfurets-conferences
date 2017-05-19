package com.lesfurets.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LegacyFicheAutoDAO {

    private static final String COL_ID = "id";
    private static final String COL_OFFRE_UID = "offre_uid";
    private static final String COL_STATUT = "statut";
    private static final String COL_XML = "xml";

    private static final String TABLE_FICHES_AUTO = "FICHES_AUTO";

    private final String SELECT_ONE = "SELECT " + COL_ID + ", " + COL_OFFRE_UID + ", " + COL_STATUT + ", " + COL_XML +
            " FROM " + TABLE_FICHES_AUTO +
            " WHERE offre_uid=? " + //
            " ORDER BY id DESC, statut DESC LIMIT 0,1 ";

    public String readXmlArchive(Connection conn, String offreUid) throws Exception {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_ONE)) {
            ps.setString(1, offreUid);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    throw new Exception(offreUid);
                }
                String xml = rs.getString(COL_XML);
                if (xml == null || xml.isEmpty()) {
                    throw new Exception(offreUid);
                }
                return xml;
            }
        }
    }

}