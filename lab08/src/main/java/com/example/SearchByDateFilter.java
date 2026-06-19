package com.example;

import java.util.ArrayList;
import java.util.List;

public class SearchByDateFilter implements Filter {
    private List<CarOffer> carOffers;
    public SearchSettings searchSettings;

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
        if (searchSettings.getDateFrom() == null && searchSettings.getDateTo() == null) {
            return false;
        }
        if (searchSettings.getDateFrom() != null && searchSettings.getDateTo() != null) {
            return searchSettings.getDateFrom().isBefore(searchSettings.getDateTo());
        }
        return true;
    }

    @Override
    public List<CarOffer> filter() {
        List<CarOffer> filteredOffers = new ArrayList<>(carOffers);

        for (CarOffer offer : carOffers) {
            if (searchSettings.getDateTo() != null) {
                if (offer.getDate().isAfter(searchSettings.getDateTo())) {
                    filteredOffers.remove(offer);
                }
            }
            if (searchSettings.getDateFrom() != null) {
                if (offer.getDate().isBefore(searchSettings.getDateFrom())) {
                    filteredOffers.remove(offer);
                }
            }
        }

        return filteredOffers;
    }
}
