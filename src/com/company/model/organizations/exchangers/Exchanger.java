package com.company.model.organizations.exchangers;



import com.company.functional.Converter;
import com.company.model.Currency;
import com.company.model.FinancialOrganization;

import java.util.HashMap;

    public class Exchanger extends FinancialOrganization implements Converter {

        private HashMap<String, Currency> currencies;

        public Exchanger(String name, String address, HashMap<String, Currency> currencies) {
            super(name, address);
            this.currencies = currencies;
        }

        @Override
        public float convert(int money, ConvertAction action, String currencyName){
            return currencies.get(currencyName.toUpperCase()).convertMoney(money, action);
        }

        @Override
        public boolean canConvert(int amount, String currName) {
            return currencies.containsKey(currName.toUpperCase());
        }

        @Override
        public Currency getCurrency(String name) {
            return currencies.get(name.toUpperCase());
        }

        @Override
        public String getInfo() {
            return String.format("--> Name: %s, address: %s", name,address);
        }
    }


