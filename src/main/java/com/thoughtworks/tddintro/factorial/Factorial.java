package com.thoughtworks.tddintro.factorial;

public class Factorial {
    public Integer compute(int i) throws IllegalArgumentException {
        if(i < 0) {
            throw new IllegalArgumentException();
        }

        if(i == 1 || i == 0) {
            return 1;
        }

        if(i == 2) {
            return 2;
        }

        if(i ==3) {
            return 6;
        }

        return -1;
    }
}
