package com.company.data.database;



import com.company.functional.Depositor;
import com.company.model.FinancialOrganization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class DepositDataBase {
    private ArrayList<Depositor> depositors;

    public DepositDataBase(ArrayList<FinancialOrganization> organizations) {
        this.depositors = findDepositors(organizations);
    }

    public ArrayList<Depositor> getDepositors() {
        return depositors;
    }

    private ArrayList<Depositor> findDepositors(ArrayList<FinancialOrganization> organizations) {
        ArrayList<Depositor> depositors = new ArrayList<>();
        for (FinancialOrganization organization : organizations) {
            if (organization instanceof Depositor) {
                depositors.add((Depositor) organization);
            }
        }
        return depositors;
    }

    public void sortAnnualInterest() {
        Collections.sort(depositors,
                (depositor1, depositor2) -> Float.compare(depositor2.getDepositAnnualInterest(),depositor1.getDepositAnnualInterest()));
    }

    public void checkCanItGiveDeposit(int months) {
        Iterator<Depositor> iterator = depositors.iterator();
        while (iterator.hasNext()){
            if (!iterator.next().canGiveDeposit(months)){
                iterator.remove();
            }
        }
    }

}

