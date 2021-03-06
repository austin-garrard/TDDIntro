package com.thoughtworks.tddintro.accountbalance;

/**
 * @author Austin Garrard
 */
public class Account {

    private int balance;

    public Account(int initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public void withdraw(int amount) {
        if(amount > this.balance) {
            return;
        }

        this.balance -= amount;
    }

    public int balance() {

        return this.balance;
    }
}
