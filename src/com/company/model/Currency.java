package com.company.model;



import com.company.functional.Converter;

    public class Currency {
        private float rateBuy;
        private float rateSell;

        public Currency(float rateBuy, float rateSell) {
            this.rateBuy = rateBuy;
            this.rateSell = rateSell;
        }

        public float getRateBuy() {
            return rateBuy;
        }

        public float getRateSell() {
            return rateSell;
        }

        public float convertMoney(int money, Converter.ConvertAction action) {
            switch (action) {
                case BAY:
                    return money / rateBuy;
                case SELL:
                    return money * rateSell;
            }
            return -1;
        }

        @Override
        public String toString() {
            return String.format("rate buy = %.2f; rate sell = %.2f", rateBuy, rateSell);
        }
    }


