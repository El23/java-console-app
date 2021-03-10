package com.company.model.organizations.senders;


import com.company.functional.Sender;
import com.company.model.FinancialOrganization;

    public class PostOffice extends FinancialOrganization implements Sender {

        private float sendCommission = 0.02f; // 2%

        public PostOffice(String name, String address) {
            super(name, address);
        }

        @Override
        public float getCommission() {
            return sendCommission;
        }

        @Override
        public int send(int money) {
            return (int) (money * (1 + sendCommission));
        }

        @Override
        public boolean canSend(int amount) {
            return true;
        }

        @Override
        public String getSenderInfo() {
            return String.format(
                    "\tCommission: %d%%",
                    (int) (sendCommission * 100));
        }

        @Override
        public String getInfo() {
            return String.format("--> Name: %s, Link: %s", name, address);
        }
    }


