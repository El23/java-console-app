package com.company.functional;



import com.company.model.Currency;

public interface Converter {
    float convert(int money, ConvertAction action, String currencyName);

    Currency getCurrency(String name);

    boolean canConvert(int amount, String currName);

    enum ConvertAction {
        BAY, SELL
    }
}
