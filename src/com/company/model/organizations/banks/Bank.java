package com.company.model.organizations.banks;


import com.company.functional.Converter;
import com.company.functional.Creditor;
import com.company.functional.Depositor;
import com.company.functional.Sender;
import com.company.model.Currency;
import com.company.model.FinancialOrganization;

import java.util.HashMap;

    public class Bank extends FinancialOrganization implements Creditor, Depositor, Sender, Converter {

        private int maxConvertAmount = 150_000; // in UAH
        private int convertCommission = 15; // in UAH

        private int maxCreditAmount = 200_000; // in UAH
        private float creditAnnualInterest = 0.25f; // 25%

        private int maxDepositPeriod = 12; // months
        private float depositAnnualInterest; // ...%

        private int minSendAmount = 25; // in UAH
        private float sendCommission = 0.01f; // 1%

        private int yearOfLicense;
        private HashMap<String, Currency> currencies;

        public Bank(String name, String address, int yearOfLicense, HashMap<String, Currency> currencies, float depositAnnualInterest) {
            super(name, address);
            this.yearOfLicense = yearOfLicense;
            this.currencies = currencies;
            this.depositAnnualInterest = depositAnnualInterest;
        }


        // Creditor block:
        @Override
        public float getCreditAnnualInterest() {
            return creditAnnualInterest;
        }

        @Override
        public int takeCredit(int money, int months) {
            float monthPr = creditAnnualInterest / 12;
            return (int) (money * (1 + monthPr * months));
        }

        @Override
        public boolean canGiveCredit(int amount) {
            return amount < maxCreditAmount;
        }

        @Override
        public String getCreditInfo() {
            return String.format(
                    "\tMaximum credit amount: %d, credit annual interest: %d%%",
                    maxCreditAmount, (int) (creditAnnualInterest * 100));
        }
        // Creditor block end.

        // Depositor block:
        @Override
        public float getDepositAnnualInterest() {
            return depositAnnualInterest;
        }
        @Override
        public int openDeposit(int money, int monthNum) {
            float monthPr = depositAnnualInterest / 12;
            return (int) (money * (1 + monthPr * monthNum));
        }

        @Override
        public boolean canGiveDeposit(int monthNum) {
            return monthNum <= maxDepositPeriod;
        }

        @Override
        public String getDepositInfo() {
            return String.format(
                    "\tMaximum deposit period: %d, deposit annual interest: %d%%",
                    maxDepositPeriod, (int) (depositAnnualInterest * 100));
        }
        // Depositor block end.

        // Sender block:
        @Override
        public float getCommission() {
            return sendCommission;
        }

        @Override
        public int send(int money) {
            return (int) (money * (1 + sendCommission));
        }

        @Override
        public boolean canSend(int amount) {
            return amount >= minSendAmount;
        }

        @Override
        public String getSenderInfo() {
            return String.format(
                    "\tMinimum send amount: %d, commission: %d%%",
                    minSendAmount, (int) (sendCommission * 100));
        }
        // Sender block end.

        // Converter block:
        @Override
        public float convert(int money, ConvertAction action, String currencyName) {
            return currencies.get(currencyName.toUpperCase())
                    .convertMoney(money, action) - convertCommission;
        }

        @Override
        public boolean canConvert(int amount, String currName) {
            return !(amount > maxConvertAmount) &&
                    currencies.containsKey(currName.toUpperCase());
        }

        @Override
        public Currency getCurrency(String name) {
            return currencies.get(name.toUpperCase());
        }
        // Converter block end.

        @Override
        public String getInfo() {
            return String.format("--> Name: %s, address: %s, year of license: %s", name, address, yearOfLicense);
        }
    }


