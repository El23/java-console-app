package com.company.model.organizations.depositors;


import com.company.functional.Depositor;
import com.company.model.FinancialOrganization;

    public class InvestmentFund extends FinancialOrganization implements Depositor {

        private int yearOfFoundation;

        private int minDepositPeriod = 12; // months
        private float depositAnnualInterest;

        public InvestmentFund(String name, String address, int yearOfFoundation, float depositAnnualInterest) {
            super(name, address);
            this.yearOfFoundation = yearOfFoundation;
            this.depositAnnualInterest = depositAnnualInterest;
        }

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
            return monthNum >= minDepositPeriod;
        }

        @Override
        public String getDepositInfo() {
            return String.format(
                    "\tMinimum deposit period: %d, deposit annual interest: %d%%",
                    minDepositPeriod, (int) (depositAnnualInterest * 100));
        }

        @Override
        public String getInfo() {
            return String.format("--> Name: %s, address: %s, year of foundation %s", name, address, yearOfFoundation);
        }
    }


