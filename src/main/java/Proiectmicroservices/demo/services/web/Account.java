package Proiectmicroservices.demo.services.web;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.math.BigDecimal;
import java.math.RoundingMode;

@JsonRootName("Account")
public class Account {

    protected Long id;
    protected String number;
    protected String owner;
    protected BigDecimal balance;

    protected Account() {
        balance = BigDecimal.ZERO;
    }

    protected long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public BigDecimal getBalance() {
        return balance.setScale(2, RoundingMode.HALF_EVEN);
    }

    public void setBalance(BigDecimal balance) {
        balance = balance;
        balance.setScale(2, RoundingMode.HALF_EVEN);
    }

    @Override
    public String toString() {
        return number + " [" + owner + "]: $" + balance;
    }
}
