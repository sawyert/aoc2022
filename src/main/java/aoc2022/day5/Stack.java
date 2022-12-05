package aoc2022.day5;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    private int stackNumber;
    List<String> crates = new ArrayList<>();

    public Stack(int stackNumber, String crates) {
        this.stackNumber = stackNumber;
        for (char c : crates.toCharArray()) {
            this.crates.add("" + c);
        }
    }

    public int getNumber() {
        return this.stackNumber;
    }

    public String pop() {
        int lastPosition = this.crates.size() - 1;
        String value = this.crates.get(lastPosition);
        this.crates.remove(lastPosition);
        return value;
    }

    public void push(String crate) {
        this.crates.add(crate);
    }

    public String peek() {
        int lastPosition = this.crates.size() - 1;
        return this.crates.get(lastPosition);
    }

    public String popMany(int count) {
        StringBuilder values = new StringBuilder();
        for (int i=1; i<=count;i++) {
            int position = this.crates.size() - i;
            String value = this.crates.get(position);
            values.append(value);
        }

        for (int i=0; i<count;i++) {
            this.pop();
        }

        values.reverse();
        return values.toString();
    }

    public void pushMany(String crates) {
        for (char c : crates.toCharArray()) {
            this.crates.add("" + c);
        }
    }
}
