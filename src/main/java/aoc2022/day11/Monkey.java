package aoc2022.day11;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Monkey {

    private long itemsInspected = 0;
    private List<Item> items = new ArrayList<>();
    private String operation;
    private int divisibleByCheck;
    private int trueMonkey;
    private int falseMonkey;
    private boolean reduceWorryLevel;

    public Monkey() {
        this.reduceWorryLevel = true;
    }

    public Monkey(boolean reduceWorryLevel) {
        this.reduceWorryLevel = reduceWorryLevel;
    }

    public void addItem(int worryLevel) {
        this.addItem(new Item(new BigInteger("" + worryLevel)));
    }

    private void addItem(Item eachItem) {
        this.items.add(eachItem);
    }

    public void setOperation(String equation) {
        this.operation = equation;
    }

    public void setTestDivisibleBy(int divisor) {
        this.divisibleByCheck = divisor;
    }

    public void setTestTrueDestination(int monkeyNumber) {
        this.trueMonkey = monkeyNumber;
    }

    public void setTestFalseDestination(int monkeyNumber) {
        this.falseMonkey = monkeyNumber;
    }

    public long getItemsInspectedCount() {
        return this.itemsInspected;
    }

    public void inspectItems(List<Monkey> monkeys) {
        BigInteger productOfDivisors = new BigInteger("1");
        for (Monkey monkey : monkeys) {
            productOfDivisors = productOfDivisors.multiply(new BigInteger(""+monkey.getDivisibleByCheck()));
        }
        for (Item eachItem : this.items) {
            this.itemsInspected++;
            BigInteger worryLevel = eachItem.getWorryLevel().mod(productOfDivisors);
            BigInteger newWorryLevel = this.executeOperation(worryLevel);
            BigInteger reducedWorryLevel = newWorryLevel;
            if (this.reduceWorryLevel) {
                reducedWorryLevel = newWorryLevel.divide(new BigInteger("3"));
            }

            eachItem.setWorryLevel(reducedWorryLevel);
            if (reducedWorryLevel.mod(new BigInteger(""+this.divisibleByCheck)).equals(new BigInteger("0"))) {
                monkeys.get(this.trueMonkey).addItem(eachItem);
            } else  {
                monkeys.get(this.falseMonkey).addItem(eachItem);
            }
        }

        this.items = new ArrayList<>();
    }

    private int getDivisibleByCheck() {
        return this.divisibleByCheck;
    }

    private BigInteger executeOperation(BigInteger worryLevel) {
        String[] expressionSplit = this.operation.split(" ");
        if (expressionSplit[0].equals("old")) {
            expressionSplit[0] = "" + worryLevel;
        }
        if (expressionSplit[2].equals("old")) {
            expressionSplit[2] = "" + worryLevel;
        }

        BigInteger leftInt = new BigInteger(expressionSplit[0]);
        BigInteger rightInt = new BigInteger(expressionSplit[2]);

        switch (expressionSplit[1]) {
            case "+":
                return leftInt.add(rightInt);
            case "*" :
                return leftInt.multiply(rightInt);
        }

        throw new UnsupportedOperationException();
    }


}
