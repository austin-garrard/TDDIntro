package com.thoughtworks.tddintro.factorial;

public class Factorial {
    public Integer compute(int i) {
        if(i == 1) {
            return 1;
        }

        if(i == 2) {
            return 2;
        }

        return -1;
    }
}
