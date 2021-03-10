package com.company.model.organizations.creditors;


import com.company.functional.Creditor;
import com.company.model.FinancialOrganization;
    //
    public class CreditCafe extends FinancialOrganization implements Creditor {

        private int maxCreditAmount = 4000; // in UAH
        private float creditAnnualInterest = 2.0f; // 200%

        public CreditCafe(String name, String address) {
            super(name, address);
        }

        @Override
        public boolean canGiveCredit(int amount) {
            return amount < maxCreditAmount;
        }

        @Override
        public float getCreditAnnualInterest() {
            return creditAnnualInterest;
        }

        @Override
        public int takeCredit(int money, int months) {
            float monthPr = creditAnnualInterest/12;
            return (int) (money * (1 + monthPr * months));
        }

        @Override
        public String getCreditInfo() {
            return String.format(
                    "\tMaximum credit amount: %d, credit annual interest: %d%%",
                    maxCreditAmount, (int) (creditAnnualInterest * 100));
        }

        @Override
        public String getInfo() {
            return String.format("--> Name: %s, address: %s", name,address);
        }
    }


