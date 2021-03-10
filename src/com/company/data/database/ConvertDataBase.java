package com.company.data.database;



import com.company.functional.Converter;
import com.company.model.FinancialOrganization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import static com.company.functional.Converter.ConvertAction;

public class ConvertDataBase {
    public static final String EUR = "EUR";
    public static final String USD = "USD";
    public static final String RUB = "RUB";

    private ArrayList<Converter> converters;

    public ConvertDataBase(ArrayList<FinancialOrganization> organizations) {
        this.converters = findConverters(organizations);
    }

    public ArrayList<Converter> getConverters() {
        return converters;
    }

    private ArrayList<Converter> findConverters(ArrayList<FinancialOrganization> organizations) {
        ArrayList<Converter> converters = new ArrayList<>();
        for (FinancialOrganization organization : organizations) {
            if (organization instanceof Converter) {
                converters.add((Converter) organization);
            }
        }
        return converters;
    }

    public void sortRate(String currencyName, ConvertAction action) {
        Iterator<Converter> iterator = converters.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getCurrency(currencyName) == null) {
                iterator.remove();
            }
        }
        converters.trimToSize();
        switch (action) {
            case BAY:
                sortBuyRate(currencyName, action);
                break;
            case SELL:
                sortSellRate(currencyName, action);
                break;
        }
    }

    public void sortBuyRate(String currencyName, ConvertAction action) {
        Collections.sort(converters, new RateSorter(currencyName.toUpperCase(), action));
    }

    public void sortSellRate(String currencyName, ConvertAction action) {
        Collections.sort(converters, new RateSorter(currencyName.toUpperCase(), action));
    }

    public void checkCanItConvert(int amount, String currencyName) {
        Iterator<Converter> iterator = converters.iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().canConvert(amount, currencyName)) {
                iterator.remove();
            }
        }
        converters.trimToSize();
    }

    private class RateSorter implements Comparator<Converter> {
        private String sortedCurrency;
        private ConvertAction action;

        public RateSorter(String sortedCurrency, ConvertAction action) {
            this.sortedCurrency = sortedCurrency;
            this.action = action;
        }

        @Override
        public int compare(Converter converter1, Converter converter2) {
            if (action == ConvertAction.BAY) {
                return Float.compare(converter1.getCurrency(sortedCurrency).getRateBuy(),
                        converter2.getCurrency(sortedCurrency).getRateBuy());
            } else {
                return Float.compare(converter1.getCurrency(sortedCurrency).getRateSell(),
                        converter2.getCurrency(sortedCurrency).getRateSell());
            }
        }
    }
}

