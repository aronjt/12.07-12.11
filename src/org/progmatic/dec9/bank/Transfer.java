package org.progmatic.dec9.bank;

public class Transfer {
    String from;
    String to;
    int amount;

    public Transfer(String from, String to, int amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", amount=" + amount +
                '}';
    }
}
