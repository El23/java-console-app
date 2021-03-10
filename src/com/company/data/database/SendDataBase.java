package com.company.data.database;



import com.company.functional.Sender;
import com.company.model.FinancialOrganization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class SendDataBase {
    private ArrayList<Sender> senders;

    public SendDataBase(ArrayList<FinancialOrganization> organizations) {
        this.senders = findSenders(organizations);
    }

    public ArrayList<Sender> getSenders() {
        return senders;
    }

    private ArrayList<Sender> findSenders(ArrayList<FinancialOrganization> organizations) {
        ArrayList<Sender> senders = new ArrayList<>();
        for (FinancialOrganization organization : organizations) {
            if (organization instanceof Sender) {
                senders.add((Sender) organization);
            }
        }
        return senders;
    }

    public void sortByCommission() {
        Collections.sort(senders,
                (sender1,sender2) -> Float.compare(sender1.getCommission(),sender2.getCommission()));
    }

    public void checkCanItSend(int amount) {
        Iterator<Sender> iterator = senders.iterator();
        while (iterator.hasNext()){
            if (!iterator.next().canSend(amount)){
                iterator.remove();
            }
        }
    }
}
