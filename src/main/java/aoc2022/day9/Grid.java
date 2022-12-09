package aoc2022.day9;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Grid {
    private int headRow = 0;
    private int headColumn = 0;
    private int tailRow = 0;
    private int tailColumn = 0;

    private Map<String,String> tailPositions = new HashMap<>();

    public Grid() {
        this.tailPositions.put(this.getTailPosition(), "Visited");
    }

    private String getTailPosition() {
        return this.tailRow + "__" + this.tailColumn;
    }


    public void moveHead(String instruction) {
        String[] instr = instruction.split(" ");
        String direction = instr[0];
        int distance = Integer.parseInt(instr[1]);

        for (int i=0; i<distance; i++) {

            switch (direction) {
                case "R":
                    this.headColumn += 1;
                    break;
                case "L":
                    this.headColumn -= 1;
                    break;
                case "U":
                    this.headRow += 1;
                    break;
                case "D":
                    this.headRow -= 1;
                    break;
            }
            this.moveTail();
            this.tailPositions.put(this.getTailPosition(), "Visited");
        }
    }

    private void moveTail() {
        if (this.tailSamePositionAsHead()) {
            return; // nothing to do
        }
        if (this.tailNextToHead()) {
            return; // nothing to do
        }
        this.moveTailCloser();
    }

    private void moveTailCloser() {
        if (this.tailColumn != this.headColumn) {
            if (this.headColumn - this.tailColumn > 0) {
                this.tailColumn += 1;
            } else {
                this.tailColumn -= 1;
            }
        }

        if (this.tailRow != this.headRow) {
            if (this.headRow - this.tailRow > 0) {
                this.tailRow += 1;
            } else {
                this.tailRow -= 1;
            }
        }
    }

    private boolean tailNextToHead() {
        boolean tailAboveHead = this.headRow-1 == this.tailRow && this.headColumn == this.tailColumn;
        boolean tailTopRightHead = this.headRow-1 == this.tailRow && this.headColumn+1 == this.tailColumn;
        boolean tailRightHead = this.headRow == this.tailRow && this.headColumn+1 == this.tailColumn;
        boolean tailBottomRightHead = this.headRow+1 == this.tailRow && this.headColumn+1 == this.tailColumn;
        boolean tailBelowHead = this.headRow+1 == this.tailRow && this.headColumn == this.tailColumn;
        boolean tailBottomLeftHead = this.headRow+1 == this.tailRow && this.headColumn-1 == this.tailColumn;
        boolean tailLeftHead = this.headRow == this.tailRow && this.headColumn-1 == this.tailColumn;
        boolean tailTopLeftHead = this.headRow-1 == this.tailRow && this.headColumn-1 == this.tailColumn;

        return tailAboveHead || tailTopRightHead || tailRightHead || tailBottomRightHead || tailBelowHead || tailBottomLeftHead || tailLeftHead || tailTopLeftHead;
    }

    private boolean tailSamePositionAsHead() {
        return this.headColumn == this.tailColumn && this.headRow == this.tailRow;
    }

    public long getTailVisitCount() {
        return this.tailPositions.keySet().size();
    }
}
