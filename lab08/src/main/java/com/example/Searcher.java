package com.example;

import java.util.ArrayList;
import java.util.List;

public class Searcher {
    private List<Filter> filters =  new ArrayList<>();

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    public List<CarOffer> filter(List<CarOffer> carOffers, SearchSettings searchSettings) {
        List<CarOffer> filteredOffers = new ArrayList<>(carOffers);

        for (Filter filter : filters) {
            filter.setCarOffers(filteredOffers);
            filter.setSearchSettings(searchSettings);
            if (filter.canFilter()) {
                filteredOffers = filter.filter();
            }
        }

        return filteredOffers;
    }
}
