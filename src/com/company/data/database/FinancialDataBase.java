package com.company.data.database;



import com.company.functional.Converter;
import com.company.functional.Converter.ConvertAction;
import com.company.functional.Creditor;
import com.company.functional.Depositor;
import com.company.functional.Sender;
import com.company.model.FinancialOrganization;

import java.util.ArrayList;

public class FinancialDataBase {

    private ArrayList<FinancialOrganization> organizations;

    public FinancialDataBase(ArrayList<FinancialOrganization> organizations) {
        this.organizations = organizations;
    }

    public void printSortedExchangers(int amount, ConvertAction action, String currencyName) {
        ConvertDataBase convertDataBase = new ConvertDataBase(organizations);
        convertDataBase.sortRate(currencyName, action);
        convertDataBase.checkCanItConvert(amount, currencyName);
        if (convertDataBase.getConverters().isEmpty()){
            System.out.println("No organizations were found");
            return;
        }
        ArrayList<Converter> converters = new ArrayList<>(convertDataBase.getConverters());
        for (Converter converter : converters) {
            System.out.println(((FinancialOrganization) converter).getInfo());
            System.out.println("\t" + currencyName.toUpperCase().concat(": ")
                    + (converter.getCurrency(currencyName)));
            System.out.printf("\tYour money in result: %.2f %s.\n",
                    converter.convert(amount, action, currencyName), currencyName.toUpperCase());
        }
    }

    public void printSortedCreditors(int amount) {
        CreditDataBase creditDataBase = new CreditDataBase(organizations);
        creditDataBase.sortAnnualInterest();
        creditDataBase.checkCanItGiveCredit(amount);
        if (creditDataBase.getCreditors().isEmpty()){
            System.out.println("No organizations were found");
            return;
        }
        ArrayList<Creditor> creditors = new ArrayList<>(creditDataBase.getCreditors());
        for (Creditor creditor : creditors) {
            System.out.println(((FinancialOrganization) creditor).getInfo());
            System.out.println(creditor.getCreditInfo());
            System.out.printf("\tYou need to pay (12 months): %d UAH.\n", creditor.takeCredit(amount, 12));
        }
    }

    public void printSortedDepositors(int months) {
        DepositDataBase depositDataBase = new DepositDataBase(organizations);
        depositDataBase.sortAnnualInterest();
        depositDataBase.checkCanItGiveDeposit(months);
        if (depositDataBase.getDepositors().isEmpty()) {
            System.out.println("No organizations were found");
            return;
        }
        ArrayList<Depositor> depositors = new ArrayList<>(depositDataBase.getDepositors());
        for (Depositor depositor : depositors) {
            System.out.println(((FinancialOrganization) depositor).getInfo());
            System.out.println(depositor.getDepositInfo());
        }
    }

    public void printSortedSenders(int amount) {
        SendDataBase sendDataBase = new SendDataBase(organizations);
        sendDataBase.sortByCommission();
        sendDataBase.checkCanItSend(amount);
        if (sendDataBase.getSenders().isEmpty()){
            System.out.println("No organizations were found");
            return;
        }
        ArrayList<Sender> senders = new ArrayList<>(sendDataBase.getSenders());
        for (Sender sender : senders) {
            System.out.println(((FinancialOrganization) sender).getInfo());
            System.out.println(sender.getSenderInfo());
            System.out.printf("\tYou need to pay: %d UAH.\n", sender.send(amount));
        }
    }
}
