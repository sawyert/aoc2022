package aoc2022.day11;

import java.math.BigInteger;

public class Item {

    private BigInteger worryLevel;
    public Item(BigInteger worryLevel) {
        this.worryLevel = worryLevel;
    }

    public BigInteger getWorryLevel() {
        return this.worryLevel;
    }

    public void setWorryLevel(BigInteger reducedWorryLevel) {
        this.worryLevel = reducedWorryLevel;
    }

    public String toString() {
        return "" + this.worryLevel;
    }
}
