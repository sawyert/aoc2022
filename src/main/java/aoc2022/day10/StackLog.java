package aoc2022.day10;

public class StackLog {
    private int clockCycle;
    private long registerX;

    public StackLog(int clockCycle, long registerX) {
        this.clockCycle = clockCycle;
        this.registerX = registerX;
    }

    public String toString() {
        return "During " + this.clockCycle + " - " + this.registerX;
    }

    public int getClockCycle() {
        return this.clockCycle;
    }
    public long getRegisterX() {
        return this.registerX;
    }

    public long getSignalStrength() {
        return this.registerX * this.clockCycle;
    }
}
