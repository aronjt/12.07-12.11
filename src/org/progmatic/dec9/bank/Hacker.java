package org.progmatic.dec9.bank;

public class Hacker extends Thread{

    private final Bank bank;

    public Hacker(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        bank.transferMoney("Aladár", "Dalára", 100);
    }
}
