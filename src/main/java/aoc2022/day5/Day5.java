package aoc2022.day5;

import java.util.ArrayList;
import java.util.List;

public class Day5 {
    List<String> instructions = new ArrayList<>();
    List<Stack> stacks = null;

    public Day5(String[] testInput, List<Stack> startStacks) {
        this.stacks = startStacks;

        boolean blankLineFound = false;
        for (String line : testInput) {
            if (line.trim().length() == 0) {
                blankLineFound = true;
                continue;
            }

            if (blankLineFound) {
                this.instructions.add(line);
            }
        }
    }

    public String execute1() {
        for (String instr: this.instructions) {
            //move 5 from 4 to 5
            int firstSpace = instr.indexOf(" ");
            instr = instr.substring(firstSpace).trim();
            int nextSpace = instr.indexOf(" from");
            int count = Integer.parseInt(instr.substring(0, nextSpace).trim());
            instr = instr.substring(nextSpace + " from".length()).trim();
            nextSpace = instr.indexOf(" to ");
            int from = Integer.parseInt(instr.substring(0, nextSpace).trim());
            int to = Integer.parseInt(instr.substring(nextSpace + " to".length()).trim());

            Stack stackFrom = this.findStack(from);
            Stack stackTo = this.findStack(to);

            for (int i=0; i<count; i++) {
                String crate = stackFrom.pop();
                stackTo.push(crate);
            }
        }

        String tops = "";
        for (Stack eachStack : this.stacks) {
            tops += eachStack.peek();
        }

        return tops;
    }

    private Stack findStack(int stack) {
        for (Stack eachStack : this.stacks) {
            if (eachStack.getNumber() == stack) {
                return eachStack;
            }
        }
        throw new UnsupportedOperationException();
    }

    public String execute2() {
        for (String instr: this.instructions) {
            //move 5 from 4 to 5
            int firstSpace = instr.indexOf(" ");
            instr = instr.substring(firstSpace).trim();
            int nextSpace = instr.indexOf(" from");
            int count = Integer.parseInt(instr.substring(0, nextSpace).trim());
            instr = instr.substring(nextSpace + " from".length()).trim();
            nextSpace = instr.indexOf(" to ");
            int from = Integer.parseInt(instr.substring(0, nextSpace).trim());
            int to = Integer.parseInt(instr.substring(nextSpace + " to".length()).trim());

            Stack stackFrom = this.findStack(from);
            Stack stackTo = this.findStack(to);

           String crates = stackFrom.popMany(count);
           stackTo.pushMany(crates);
        }

        String tops = "";
        for (Stack eachStack : this.stacks) {
            tops += eachStack.peek();
        }

        return tops;
    }
}
