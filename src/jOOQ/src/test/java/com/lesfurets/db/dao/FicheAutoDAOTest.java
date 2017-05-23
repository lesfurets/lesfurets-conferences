package com.lesfurets.db.dao;

import com.lesfurets.model.FicheAuto;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FicheAutoDAOTest {

    private LegacyFicheAutoDAO legacyFicheAutoDAO;

    private FicheAutoDAO ficheAutoDAO;

    private BruJugFichesAutoDAO bruJugFichesAutoDAO;

    @Before
    public void setUp() throws Exception {
        Connection connection = ConnectionManager.getConnection();
        ConnectionManager.init(connection);
        legacyFicheAutoDAO = new LegacyFicheAutoDAO(connection);
        ficheAutoDAO = new FicheAutoDAO(connection);
        bruJugFichesAutoDAO = new BruJugFichesAutoDAO(connection);
    }

    @Test
    public void should_have_no_regression() throws Exception {
        String uid = "0001495183264276b2c00000e6b55262";
        int statut = 100;
        List<FicheAuto> fichesFromLegacy = legacyFicheAutoDAO.selectRecentFiches(uid, statut);
        List<FicheAuto> fiches = ficheAutoDAO.selectRecentFiches(uid, statut);
        assertThat(fiches).isEqualTo(fichesFromLegacy);

        List<FicheAuto> fichesFromBruJug = bruJugFichesAutoDAO.selectRecentFiches(uid, statut);
//        assertThat(fichesFromBruJug).isEqualTo(fichesFromLegacy);
    }

}
