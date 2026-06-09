package com.example;

import java.util.List;

public interface Filter {
    public void setCarOffers(List<CarOffer> carOffers);
    public void setSearchSettings(SearchSettings settings);
    public boolean canFilter();
    public List<CarOffer> filter();
}
