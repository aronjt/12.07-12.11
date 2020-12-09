package org.progmatic.dec9.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Simulator {

    public static void main(String[] args) throws InterruptedException {
        Account aladar = new Account("Aladár", 100);
        Account dalara = new Account("Dalára", 0);
        Map<String, Account> map = new HashMap<>();
        map.put(aladar.getName(), aladar);
        map.put(dalara.getName(), dalara);
        Bank b = new Bank(map);
    //    b.tranferMoney("Aladár", "Dalára", 100);
    //    b.tranferMoney("Aladár", "Dalára", 100);
    //    b.tranferMoney("Aladár", "Dalára", 100);
        List<Hacker> hackers = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            hackers.add(new Hacker(b));
        }
        for (Hacker hacker : hackers) {
            hacker.start();
        }
        for (Hacker hacker : hackers) {
            hacker.join();
        }


        b.printAccounts();
        b.printTransactionHistory();

    }
}
