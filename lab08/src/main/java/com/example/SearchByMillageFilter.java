package com.example;

import java.util.ArrayList;
import java.util.List;

public class SearchByMillageFilter implements Filter {
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
        if (searchSettings.getMilleageFrom() <= 0 && searchSettings.getMilleageTo() <= 0) {
            return false;
        }
        if (searchSettings.getMilleageFrom() > 0 && searchSettings.getMilleageTo() > 0) {
            return searchSettings.getMilleageFrom() <= searchSettings.getMilleageTo();
        }
        return true;
    }

    @Override
    public List<CarOffer> filter() {
        List<CarOffer> filteredOffers = new ArrayList<>(carOffers);

        for (CarOffer offer : carOffers) {
            if (searchSettings.getMilleageTo() > 0) {
                if (offer.getMilleage() > searchSettings.getMilleageTo()) {
                    filteredOffers.remove(offer);
                }
            }
            if (searchSettings.getMilleageFrom() > 0) {
                if (offer.getMilleage() < searchSettings.getMilleageFrom()) {
                    filteredOffers.remove(offer);
                }
            }
        }

        return filteredOffers;
    }
}
