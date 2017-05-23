package com.lesfurets.db.dao;

import com.lesfurets.model.FicheAuto;

import java.sql.Connection;
import java.util.List;

public class BruJugFichesAutoDAO extends DAO {

    public BruJugFichesAutoDAO(Connection connection) {
        super(connection);
    }

    public List<FicheAuto> selectRecentFiches(int statut) throws Exception {
        return null;
    }

}
