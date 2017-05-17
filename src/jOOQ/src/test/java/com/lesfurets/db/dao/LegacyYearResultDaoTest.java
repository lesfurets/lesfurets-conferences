package com.lesfurets.db.dao;

import com.lesfurets.db.YearReport;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LegacyYearResultDaoTest {

    private LegacyYearResultDao legacyYearResultDao;

    private YearResultDao yearResultDao;

    @Before
    public void setUp() throws Exception {
        // Given
        Connection connection = ConnectionManager.getConnection();
        ConnectionManager.init(connection);
        legacyYearResultDao = new LegacyYearResultDao(connection);
        yearResultDao = new YearResultDao(connection);
    }

    @Test
    public void should_have_no_regression() {
        String departement = "IT";
        List<YearReport> reportFromLegacy = legacyYearResultDao.findYearResultBy(departement);
        List<YearReport> report = yearResultDao.findYearResultBy(departement);
        assertThat(report).isEqualTo(reportFromLegacy);
    }

    @Test
    public void should_retrieve_year_result() {
        // When
        List<YearReport> yearReports = yearResultDao.findYearResultBy("IT");

        // Then
        assertThat(yearReports).isNotEmpty();
        assertThat(yearReports).hasSize(12);
        assertThat(yearReports).extracting("creationDate")
                .containsExactly(LocalDate.of(2016, Month.JANUARY, 1),
                        LocalDate.of(2016, Month.FEBRUARY, 1),
                        LocalDate.of(2016, Month.MARCH, 1),
                        LocalDate.of(2016, Month.APRIL, 1),
                        LocalDate.of(2016, Month.MAY, 1),
                        LocalDate.of(2016, Month.JUNE, 1),
                        LocalDate.of(2016, Month.JULY, 1),
                        LocalDate.of(2016, Month.AUGUST, 1),
                        LocalDate.of(2016, Month.SEPTEMBER, 1),
                        LocalDate.of(2016, Month.OCTOBER, 1),
                        LocalDate.of(2016, Month.NOVEMBER, 1),
                        LocalDate.of(2016, Month.DECEMBER, 1));
    }
}
