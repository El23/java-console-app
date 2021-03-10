package com.company;



import com.company.data.generators.Generator;
import com.company.data.database.ConvertDataBase;
import com.company.data.database.FinancialDataBase;
import com.company.functional.Converter.ConvertAction;

    public class Main {

        public static void main(String[] args) {
            FinancialDataBase dataBase = new FinancialDataBase(Generator.generate());
            UI userInterface = new UI(dataBase);

            int defValue = 20_000;
            userInterface.showInfoAboutBestExchanger(defValue,ConvertAction.BAY,ConvertDataBase.USD);
            userInterface.showInfoAboutBestExchanger(defValue,ConvertAction.BAY,ConvertDataBase.EUR);
            userInterface.showInfoAboutBestExchanger(defValue,ConvertAction.BAY,ConvertDataBase.RUB);

            defValue = 50_000;
            userInterface.showInfoAboutBestCreditOrg(defValue);

            defValue = 12;
            userInterface.showInfoAboutBestDepositOrg(defValue);

            defValue = 12;
            userInterface.showInfoAboutBestSender(defValue);
        }
    }



