package com.lesfurets.db;

import java.time.LocalDate;
import java.util.Objects;

public class YearReport {
    private final String departement;
    private final String manager;
    private final Double netprofit;
    private final Double operatingexpense;
    private final Double turnover;
    private final LocalDate creationDate;

    public YearReport(String departement, String manager, Double netprofit, Double operatingexpense, Double turnover,
            LocalDate creationDate) {
        this.departement = departement;
        this.manager = manager;
        this.netprofit = netprofit;
        this.operatingexpense = operatingexpense;
        this.turnover = turnover;
        this.creationDate = creationDate;
    }

    public String getDepartement() {
        return departement;
    }

    public String getManager() {
        return manager;
    }

    public Double getNetprofit() {
        return netprofit;
    }

    public Double getOperatingexpense() {
        return operatingexpense;
    }

    public Double getTurnover() {
        return turnover;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        YearReport that = (YearReport) o;
        return Objects.equals(departement, that.departement) &&
                Objects.equals(manager, that.manager) &&
                Objects.equals(netprofit, that.netprofit) &&
                Objects.equals(operatingexpense, that.operatingexpense) &&
                Objects.equals(turnover, that.turnover) &&
                Objects.equals(creationDate, that.creationDate);
    }

    @Override public int hashCode() {
        return Objects.hash(departement, manager, netprofit, operatingexpense, turnover, creationDate);
    }
}
