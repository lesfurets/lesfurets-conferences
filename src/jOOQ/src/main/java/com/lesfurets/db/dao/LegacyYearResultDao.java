package com.lesfurets.db.dao;

import com.google.common.annotations.VisibleForTesting;
import com.lesfurets.db.YearReport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LegacyYearResultDao {

    @VisibleForTesting
    static String SELECT_YEAR_RESULT = "select DEPARTEMENT, "
            + "MANAGER, "
            + "NETPROFIT,"
            + "OPERATINGEXPENSE, "
            + "TURNOVER,"
            + "CREATION_DATE "
            + "FROM YEAR_RESULT "
            + "WHERE DEPARTEMENT=? ORDER BY CREATION_DATE ASC";

    private final Connection connection;

    public LegacyYearResultDao(Connection connection) {
        this.connection = connection;
    }

    public List<YearReport> findYearResultBy(String departementToFind) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_YEAR_RESULT)) {
            List<YearReport> results = new ArrayList<>();
            preparedStatement.setString(1, departementToFind);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String departement = resultSet.getString("departement");
                String manager = resultSet.getString("manager");
                Double netProfit = resultSet.getDouble("netprofit");
                Double operatingExpense = resultSet.getDouble("operatingexpense");
                Double turnover = resultSet.getDouble("turnover");
                Date date = resultSet.getDate("creation_date");
                LocalDate localDate = Instant.ofEpochMilli(date.getTime())
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate();
                results.add(new YearReport(departement, manager, netProfit, operatingExpense, turnover, localDate));
            }
            return results;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
