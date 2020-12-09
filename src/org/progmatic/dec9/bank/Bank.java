package org.progmatic.dec9.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Bank {
    private final Map<String, Account> accounts;

    List<Transfer> transfers = new ArrayList<>();

    public Bank(Map<String, Account> accounts) {
        this.accounts = accounts;
    }
    private Object lock = new Object();

    public synchronized void transferMoney(String from, String to, int sum){
        Account fromAcc = accounts.get(from);
        Account toAcc = accounts.get(to);
        if(fromAcc != null && toAcc != null){
            int fromMoney = fromAcc.getMoney();
            if(fromMoney >= sum){
                transfers.add(new Transfer(from, to, sum));
                toAcc.setMoney(toAcc.getMoney()+sum);
                fromAcc.setMoney(fromMoney-sum);
            }
        }
    }
    public void printTransactionHistory(){
        for (Transfer transfer : transfers) {
            System.out.println(transfer);
        }
    }

    public void printAccounts(){
        for (Account acc : accounts.values()) {
            System.out.println(acc);
        }
    }
}
