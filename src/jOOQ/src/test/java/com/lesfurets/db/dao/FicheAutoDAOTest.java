package com.lesfurets.db.dao;

import com.lesfurets.model.FicheAuto;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;

import static org.assertj.core.api.Assertions.assertThat;

public class FicheAutoDAOTest {

    private LegacyFicheAutoDAO legacyFicheAutoDAO;

    private FicheAutoDAO yearResultDao;

    @Before
    public void setUp() throws Exception {
        Connection connection = ConnectionManager.getConnection();
        ConnectionManager.init(connection);
        legacyFicheAutoDAO = new LegacyFicheAutoDAO(connection);
        yearResultDao = new FicheAutoDAO(connection);
    }

    @Test
    public void should_have_no_regression() throws Exception {
        int statut = 100;
        FicheAuto reportFromLegacy = legacyFicheAutoDAO.selectRecentFiche(statut);
        FicheAuto report = yearResultDao.selectRecentFiche(statut);
        assertThat(report).isEqualTo(reportFromLegacy);

        System.out.println(report);
    }

}