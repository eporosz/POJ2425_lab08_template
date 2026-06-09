package com.example;

import java.util.ArrayList;
import java.util.List;

public class SearchByYearFilter implements Filter {
    private List<CarOffer> carOffers;
    private SearchSettings searchSettings;

    @Override
    public void setCarOffers(List<CarOffer> carOffers) {
        this.carOffers = carOffers;
    }

    @Override
    public void setSearchSettings(SearchSettings settings) {
        this.searchSettings = settings;
    }

    @Override
    public boolean canFilter() {
        return searchSettings.getYearFrom() > 0 ||  searchSettings.getYearTo() > 0;
    }

    @Override
    public List<CarOffer> filter() {
        List<CarOffer> filteredOffers = new ArrayList<>(carOffers);

        for (CarOffer offer : carOffers) {
            if (searchSettings.getYearTo() > 0) {
                if (offer.getYear() > searchSettings.getYearTo()) {
                    filteredOffers.remove(offer);
                }
            }
            if (searchSettings.getYearFrom() > 0) {
                if (offer.getYear() < searchSettings.getYearFrom()) {
                    filteredOffers.remove(offer);
                }
            }
        }

        return filteredOffers;
    }
}
