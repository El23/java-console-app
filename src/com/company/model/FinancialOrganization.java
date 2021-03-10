package com.company.model;



    public abstract class FinancialOrganization {
        protected String name;
        protected String address;

        public FinancialOrganization(String name, String address) {
            this.name = name;
            this.address = address;
        }


        public abstract String getInfo();
    }


