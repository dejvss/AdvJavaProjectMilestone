package app.main.java;

import java.util.Date;

public class Row {
    private String isoCode;
    private String continent;
    private String location;
    private Date date;
    private double totalCases;
    private double newCases;
    private double newCasesSmoothed;
    private double totalDeaths;
    private double newDeaths;
    private double newDeathsSmoothed;
    private double reproductionRate;
    private double newTests;
    private double totalTests;
    private double stringencyIndex;
    private double population;
    private double medianAge;

    public Row(){}

    public String get_iso_code() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public String get_continent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String get_location() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date get_date() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double get_total_cases() {
        return totalCases;
    }

    public void setTotalCases(double totalCases) {
        this.totalCases = totalCases;
    }

    public double get_new_cases() {
        return newCases;
    }

    public void setNewCases(double newCases) {
        this.newCases = newCases;
    }

    public double get_new_cases_smoothed() {
        return newCasesSmoothed;
    }

    public void setNewCasesSmoothed(double newCasesSmoothed) {
        this.newCasesSmoothed = newCasesSmoothed;
    }

    public double get_total_deaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(double totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public double get_new_deaths() {
        return newDeaths;
    }

    public void setNewDeaths(double newDeaths) {
        this.newDeaths = newDeaths;
    }

    public double get_new_death_smoothed() {
        return newDeathsSmoothed;
    }

    public void setNewDeathsSmoothed(double newDeathsSmoothed) {
        this.newDeathsSmoothed = newDeathsSmoothed;
    }

    public double get_reproduction_rate() {
        return reproductionRate;
    }

    public void setReproductionRate(double reproductionRate) {
        this.reproductionRate = reproductionRate;
    }

    public double get_new_tests() {
        return newTests;
    }

    public void setNewTests(double newTests) {
        this.newTests = newTests;
    }

    public double get_total_tests() {
        return totalTests;
    }

    public void setTotalTests(double totalTests) {
        this.totalTests = totalTests;
    }

    public double get_stringency_index() {
        return stringencyIndex;
    }

    public void setStringencyIndex(double stringencyIndex) {
        this.stringencyIndex = stringencyIndex;
    }

    public double get_population() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public double get_median_age() {
        return medianAge;
    }

    public void setMedianAge(double medianAge) {
        this.medianAge = medianAge;
    }
}
