package Proiectmicroservices.demo.accounts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Table(name="T_ACCOUNT")
public class Account {
    public static Long nextId = 0L;

    @Id
    protected Long id;

    protected String number;

    @Column(name = "name")
    protected String owner;

    protected BigDecimal balance;

    protected static Long getNextId(){
        synchronized (nextId){
            return nextId++;
        }
    }

    public Account(){
        balance=BigDecimal.ZERO;
    }
    public Account(String number, String owner) {
        id = getNextId();
        this.number = number;
        this.owner = owner;
        balance = BigDecimal.ZERO;
    }

    public long getId() {
        return id;
    }
    public String getNumber() {
        return number;
    }

    protected void setNumber(String accountNumber) {
        this.number = accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    protected void setOwner(String owner) {
        this.owner = owner;
    }

    public BigDecimal getBalance() {
        return balance.setScale(2, RoundingMode.HALF_EVEN);
    }

    public void withdraw(BigDecimal amount) {
        balance.subtract(amount);
    }

    public void deposit(BigDecimal amount) {
        balance.add(amount);
    }

    @Override
    public String toString() {
        return number + " [" + owner + "]: $" + balance;
    }

}
