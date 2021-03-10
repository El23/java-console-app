package com.company;

import com.company.data.database.FinancialDataBase;
import com.company.functional.Converter;


import com.company.data.database.ConvertDataBase;
import com.company.data.database.FinancialDataBase;
import com.company.functional.Converter;

    public class UI {
        private FinancialDataBase dataBase;

        public UI(FinancialDataBase dataBase) {
            this.dataBase = dataBase;
            printSpace();
        }

        public void showInfoAboutBestExchanger(int amount, Converter.ConvertAction action, String currencyName){
            System.out.println(String.format("For the exchange of %,d UAH to %s is best to choose:",amount,currencyName));
            dataBase.printSortedExchangers(amount, action, currencyName);
            System.out.println();
            printSpace();
        }

        public void showInfoAboutBestCreditOrg(int amount) {
            System.out.println(String.format("Minimum interest rate for a loan in the amount of %,d UAH: ", amount));
            dataBase.printSortedCreditors(amount);
            System.out.println();
            printSpace();
        }

        public void showInfoAboutBestDepositOrg(int defValue) {
            System.out.println(String.format("The best organization for opening a deposit for %,d months:",defValue));
            dataBase.printSortedDepositors(defValue);
            System.out.println();
            printSpace();
        }

        public void showInfoAboutBestSender(int defValue) {
            System.out.println(String.format("The best organization for sending %,d UAH:",defValue));
            dataBase.printSortedSenders(1000);
        }

        private void printSpace(){
            System.out.println("========================================================");
        }
    }


