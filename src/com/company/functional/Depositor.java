package com.company.functional;



import com.company.model.FinancialOrganization;

public interface Depositor {
    int openDeposit(int money, int monthNum);

    boolean canGiveDeposit(int monthNum);

    String getDepositInfo();

    float getDepositAnnualInterest();
}
