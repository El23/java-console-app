package com.company.functional;



import com.company.model.FinancialOrganization;

public interface Creditor {
    int takeCredit(int money, int months);

    boolean canGiveCredit(int amount);

    float getCreditAnnualInterest();

    String getCreditInfo();
}

