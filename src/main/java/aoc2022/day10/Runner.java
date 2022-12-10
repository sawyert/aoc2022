package aoc2022.day10;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Runner {

    private int clockCycle = 1;
    private long registerX = 1;

    private List<StackLog> stackLog  = new ArrayList<>();

    public Runner() {
        this.stackLog.add(new StackLog(this.clockCycle, this.registerX));
    }

    public void execute(String cmd) {
        String commandString = cmd;
        int number = 0;
        if (commandString.contains(" ")) {
            String[] cmdSplit = commandString.split(" ");
            commandString = cmdSplit[0];
            number = Integer.parseInt(cmdSplit[1]);
        }

        switch (commandString) {
            case "noop":
                this.clockCycle += 1;
                break;
            case "addx":
                this.clockCycle += 1;
                this.stackLog.add(new StackLog(this.clockCycle, this.registerX));
                this.clockCycle += 1;
                this.registerX += number;
                break;
            default:
                throw new UnsupportedOperationException();
        }

        this.stackLog.add(new StackLog(this.clockCycle, this.registerX));
    }


    public StackLog getStackLog(int position) {
        Optional<StackLog> matchingEntry = this.stackLog.stream().filter(a -> a.getClockCycle() == position).findFirst();
        if (matchingEntry.isEmpty()) {
            throw new UnsupportedOperationException();
        }
        return matchingEntry.get();
    }

    public void printStackLog() {
        for (StackLog stackLog1 : this.stackLog) {
            System.out.println(stackLog1.toString());
        }
    }

    public long getSignalStrength(int position) {
        return this.getStackLog(position).getSignalStrength();
    }

    public void printLetters() {
        for (StackLog eachStack : this.stackLog) {
            int clock = eachStack.getClockCycle();
            int position = clock - 1;
            while (position > 40) {
                position -= 40;
            }
            long registerX = eachStack.getRegisterX();

            if (position == registerX - 1 || position == registerX || position == registerX + 1) {
                System.out.print("#");
            } else {
                System.out.print(" ");
            }

            if (clock % 40 == 0) {
                System.out.println();
            }
        }


    }
}
