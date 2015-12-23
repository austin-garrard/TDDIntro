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
        this.balance -= amount;
    }

    public int balance() {

        return this.balance;
    }
}
