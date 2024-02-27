package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class Wallet {
    private String owner;
    private ArrayList<String> cards;
    private HashMap<Integer, Integer> moneys;
    private HashMap<Integer, Integer> coins;
    int[] coinTypes = {50,  300,  3000};
    int[] moneyTypes = {1000,  2000,  5000,  10000,  20000,  50000,  100000};

    public Wallet(String owner) {
        this.owner = owner;
        this.cards = new ArrayList<>();
        this.moneys = new HashMap<>();
        for (int moneyType : moneyTypes) {
            this.moneys.put(moneyType,  0);
        }
        this.coins = new HashMap<>();
        for (int coinType : coinTypes) {
            this.coins.put(coinType,  0);
        }
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public ArrayList<String> getCards() {
        return this.cards;
    }

    public void addCard(String card) {
        if (!this.cards.contains(card)) {
            this.cards.add(card);
        }
    }
    public void removeCard(String card) {
        this.cards.remove(card);
    }
    public HashMap<Integer, Integer> getCoins() {
        return coins;
    }
    public void addCoin(Integer coin) {
        for (int coinType : coinTypes) {
            if (coin == coinType) {
                this.coins.put(coinType, this.coins.getOrDefault(coinType,  0) +  1);
                return;
            }
        }
        System.out.println("Invalid coin type");
    }
    public void takeCoin(Integer coin) {
        for (int coinType : coinTypes) {
            if (coin == coinType) {
                int currentValue = this.coins.getOrDefault(coinType,  0);
                if (currentValue >  0) {
                    this.coins.put(coinType, currentValue -  1);
                } else {
                    System.out.println("Insufficient coins");
                }
                return;
            }
        }
        System.out.println("Invalid coin type");
    }

    public HashMap<Integer, Integer> getMoneys() {
        return moneys;
    }
    public void addMoney(Integer money) {
        for (int moneyType : moneyTypes) {
            if (money == moneyType) {
                this.moneys.put(moneyType, this.moneys.getOrDefault(moneyType,  0) +  1);
                return;
            }
        }
        System.out.println("Invalid money type");
    }
    public void takeMoney(Integer money) {
        for (int moneyType : moneyTypes) {
            if (money == moneyType) {
                int currentValue = this.moneys.getOrDefault(moneyType,  0);
                if (currentValue >  0) {
                    this.moneys.put(moneyType, currentValue -  1);
                } else {
                    System.out.println("Insufficient money");
                }
                return;
            }
        }
        System.out.println("Invalid money type");
    }

    public int getMoneyAvailable() {
        return this.calculateCoins() + this.calculateMoneys();
    }

    public int calculateCoins() {
        int total =  0;
        for (int key : coins.keySet()) {
            total += key * this.coins.get(key);
        }
        return total;
    }

    public int calculateMoneys() {
        int total =  0;
        for (int key : moneys.keySet()) {
            total += key * this.moneys.get(key);
        }
        return total;
    }

    public static void main(String[] args) {
        Wallet myWallet = new Wallet("Gibran");
        myWallet.addMoney(10000);
        myWallet.addMoney(5000);
        myWallet.addCoin(300);
        myWallet.addCard("Credit Card");
        myWallet.addCard("KTM");
        myWallet.removeCard("Credit Card");
        myWallet.takeCoin(300);
        myWallet.takeMoney(10000);
        System.out.println("Jumlah uang lembaran di dompet: " + myWallet.getMoneys());
        System.out.println("Jumlah uang koin di dompet: " + myWallet.getCoins());
        System.out.println("Kartu di dompet: " + myWallet.getCards());
        System.out.println("Total uang di dompet: " + myWallet.getMoneyAvailable());
    }
}
