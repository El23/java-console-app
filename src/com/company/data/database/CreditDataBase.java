package com.company.data.database;



import com.company.functional.Creditor;
import com.company.model.FinancialOrganization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class CreditDataBase {

    private ArrayList<Creditor> creditors;

    public CreditDataBase(ArrayList<FinancialOrganization> creditors) {
        this.creditors = findCreditors(creditors);
    }

    public ArrayList<Creditor> getCreditors() {
        return creditors;
    }

    private ArrayList<Creditor> findCreditors(ArrayList<FinancialOrganization> organizations) {
        ArrayList<Creditor> creditors = new ArrayList<>();
        for (FinancialOrganization organization : organizations) {
            if (organization instanceof Creditor) {
                creditors.add((Creditor) organization);
            }
        }
        return creditors;
    }

    public void sortAnnualInterest() {
        Collections.sort(creditors,
                (creditor1,creditor2) -> Float.compare(creditor1.getCreditAnnualInterest(),creditor2.getCreditAnnualInterest()));
    }

    public void checkCanItGiveCredit(int amount) {
        Iterator<Creditor> iterator = creditors.iterator();
        while (iterator.hasNext()){
            if (!iterator.next().canGiveCredit(amount)){
                iterator.remove();
            }
        }
    }
}

