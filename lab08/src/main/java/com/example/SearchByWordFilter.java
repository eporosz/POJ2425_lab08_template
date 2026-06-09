package com.example;

import java.util.ArrayList;
import java.util.List;

public class SearchByWordFilter implements Filter {
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
        return searchSettings.getWord() != null && !searchSettings.getWord().isEmpty();
    }

    @Override
    public List<CarOffer> filter() {
        List<CarOffer> filteredOffers = new ArrayList<>(carOffers);

        for (CarOffer offer : carOffers) {
            if (searchSettings.getWord() != null && !searchSettings.getWord().isEmpty()) {
                if (!offer.getTitle().contains(searchSettings.getWord())) {
                    filteredOffers.remove(offer);
                }
            }
        }

        return filteredOffers;
    }
}
