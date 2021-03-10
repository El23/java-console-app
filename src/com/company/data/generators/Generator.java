package com.company.data.generators;



import com.company.model.Currency;
import com.company.model.FinancialOrganization;
import com.company.model.organizations.banks.Bank;
import com.company.model.organizations.creditors.CreditCafe;
import com.company.model.organizations.creditors.CreditUnion;
import com.company.model.organizations.creditors.Pawnshop;
import com.company.model.organizations.depositors.InvestmentFund;
import com.company.model.organizations.exchangers.Exchanger;

import com.company.model.organizations.senders.OnlineTranslationService;
import com.company.model.organizations.senders.PostOffice;

import java.util.*;

public final class Generator {
    private Generator() {
    }

    public static ArrayList<FinancialOrganization> generate() {
        ArrayList<FinancialOrganization> organizations = new ArrayList<>();
        {
            HashMap<String, Currency> currencyMap = new HashMap<>();
            currencyMap.put("USD",new Currency( 29.4f, 28.5f));
            currencyMap.put("EUR",new Currency( 35.4f, 34.5f));
            currencyMap.put("RUB",new Currency(0.4f, 0.36f));
            organizations.add(new Bank(
                    "Privat", "Gogola 107B", 1998, currencyMap, 0.15f));
        }
        {
            HashMap<String, Currency> currencyMap = new HashMap<>();
            currencyMap.put("USD",new Currency( 29.8f, 28.6f));
            currencyMap.put("EUR",new Currency( 35.15f, 34.45f));
            currencyMap.put("RUB",new Currency(0.39f, 0.36f));
            organizations.add(new Bank(
                    "MonoBank", "pl. Konstitusii 34", 2012, currencyMap, 0.18f));
        }
        {
            HashMap<String, Currency> currencyMap = new HashMap<>();
            currencyMap.put("USD",new Currency( 30.1f, 29.3f));
            currencyMap.put("EUR",new Currency( 35.1f, 31.4f));
            organizations.add(new Exchanger("Real course", "Lva Tolstogo 19A", currencyMap));
        }
        organizations.add(new Pawnshop("Lombard10", "Mira 16"));

        organizations.add(new InvestmentFund(
                "Fund Georgia", "Nila Amstronga 17/2", 1992, 0.13f));

        organizations.add(new OnlineTranslationService("PayPal", "https://paypal.com",0.19f));

        organizations.add(new PostOffice("UkrPoshta", "Bogomolsa 4"));

        organizations.add(new CreditCafe("CafeCredit", "Dorna 15/3"));

        organizations.add(new CreditUnion("HelperUnion", "Filipova 110A"));

        organizations.add(new Pawnshop("Lombard15", "Lisova 18"));

        return organizations;
    }
}
