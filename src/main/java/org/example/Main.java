package org.example;

public class Main {
    public static void main(String[] args) {

        Human hm = new Human("Seva");

        Market market = new Market();

        market.acceptToMarket(hm);
        market.update();

    }
}