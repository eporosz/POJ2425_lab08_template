package com.example;

import java.util.ArrayList;
import java.util.List;

public class SearchByPriceFilter implements Filter {
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
        if (searchSettings.getPriceFrom() <=0 && searchSettings.getPriceTo() <=0) {
            return false;
        }
        if (searchSettings.getPriceFrom() > 0 && searchSettings.getPriceTo() > 0) {
            return searchSettings.getPriceFrom() <= searchSettings.getPriceTo();
        }
        return true;
    }

    @Override
    public List<CarOffer> filter() {
        List<CarOffer> filteredOffers = new ArrayList<>(carOffers);

        for (CarOffer offer : carOffers) {
            if (searchSettings.getPriceTo() > 0) {
                if (offer.getPrice() > searchSettings.getPriceTo()) {
                    filteredOffers.remove(offer);
                }
            }
            if (searchSettings.getPriceFrom() > 0) {
                if (offer.getPrice() < searchSettings.getPriceFrom()) {
                    filteredOffers.remove(offer);
                }
            }
        }

        return filteredOffers;
    }
}
