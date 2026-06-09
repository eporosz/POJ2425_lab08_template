package com.example;

import java.time.LocalDate;

public class SearchSettings {

    private double priceFrom;
    private double priceTo;
    private int yearFrom;
    private int milleageFrom;
    private int milleageTo;
    private int yearTo;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private String word;

    public double getPriceFrom() {
        return priceFrom;
    }

    public double getPriceTo() {
        return priceTo;
    }

    public int getYearFrom() {
        return yearFrom;
    }

    public int getMilleageFrom() {
        return milleageFrom;
    }

    public int getMilleageTo() {
        return milleageTo;
    }

    public int getYearTo() {
        return yearTo;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public String getWord() {
        return word;
    }

    public void setPriceFrom(double priceFrom) {
        this.priceFrom = priceFrom;
    }

    public void setPriceTo(double priceTo) {
        this.priceTo = priceTo;
    }

    public void setYearFrom(int yearFrom) {
        this.yearFrom = yearFrom;
    }

    public void setMilleageFrom(int milleageFrom) {
        this.milleageFrom = milleageFrom;
    }

    public void setMilleageTo(int milleageTo) {
        this.milleageTo = milleageTo;
    }

    public void setYearTo(int yearTo) {
        this.yearTo = yearTo;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
