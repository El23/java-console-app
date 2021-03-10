package com.company.functional;



import com.company.model.FinancialOrganization;

public interface Sender {
    int send(int money);

    boolean canSend(int amount);

    String getSenderInfo();

    float getCommission();
}

