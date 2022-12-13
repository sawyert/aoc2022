package aoc2022.day9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grid {
    private Knot head = new Knot();
    private Knot tail = new Knot();

    private List<Knot> knots = new ArrayList<>();

    private Map<String,String> tailPositions = new HashMap<>();

    private String getPosition(Knot knot) {
        return knot.row + "__" + knot.column;
    }

    public void moveHeadPart1(String instruction) {
        String[] instr = instruction.split(" ");
        String direction = instr[0];
        int distance = Integer.parseInt(instr[1]);

        for (int i=0; i<distance; i++) {

            switch (direction) {
                case "R":
                    this.head.column += 1;
                    break;
                case "L":
                    this.head.column -= 1;
                    break;
                case "U":
                    this.head.row += 1;
                    break;
                case "D":
                    this.head.row -= 1;
                    break;
            }
            this.moveTailPart1();
            this.tailPositions.put(this.getPosition(this.tail), "Visited");
        }
    }

    private void moveTailPart1() {
        if (this.samePosition(tail, head)) {
            return; // nothing to do
        }
        if (this.nextTo(tail, head)) {
            return; // nothing to do
        }
        this.moveCloser(this.tail, this.head);
    }

    public void addKnots(int count) {
        for (int i=0; i<count; i++) {
            this.knots.add(new Knot());
        }
    }

    public void moveHeadPart2(String instruction) {
        String[] instr = instruction.split(" ");
        String direction = instr[0];
        int distance = Integer.parseInt(instr[1]);

        for (int i=0; i<distance; i++) {

            switch (direction) {
                case "R":
                    this.head.column += 1;
                    break;
                case "L":
                    this.head.column -= 1;
                    break;
                case "U":
                    this.head.row += 1;
                    break;
                case "D":
                    this.head.row -= 1;
                    break;
            }

            Knot target = this.head;
            for (Knot eachKnot : this.knots) {
                this.moveKnot(eachKnot, target);
                target = eachKnot;
            }
            this.tailPositions.put(this.getPosition(this.knots.get(this.knots.size()-1)), "Visited");
        }
    }

    private void moveKnot(Knot from, Knot target) {
        if (this.samePosition(from, target)) {
            return; // nothing to do
        }
        if (this.nextTo(from, target)) {
            return; // nothing to do
        }
        this.moveCloser(from, target);
    }


    private void moveCloser(Knot from, Knot target) {
        if (from.column != target.column) {
            if (target.column - from.column > 0) {
                from.column += 1;
            } else {
                from.column -= 1;
            }
        }

        if (from.row != target.row) {
            if (target.row - from.row > 0) {
                from.row += 1;
            } else {
                from.row -= 1;
            }
        }
    }

    private boolean nextTo(Knot from, Knot target) {
        boolean tailAboveHead = target.row-1 == from.row && target.column == from.column;
        boolean tailTopRightHead = target.row-1 == from.row && target.column+1 == from.column;
        boolean tailRightHead = target.row == from.row && target.column+1 == from.column;
        boolean tailBottomRightHead = target.row+1 == from.row && target.column+1 == from.column;
        boolean tailBelowHead = target.row+1 == from.row && target.column == from.column;
        boolean tailBottomLeftHead = target.row+1 == from.row && target.column-1 == from.column;
        boolean tailLeftHead = target.row == from.row && target.column-1 == from.column;
        boolean tailTopLeftHead = target.row-1 == from.row && target.column-1 ==from.column;

        return tailAboveHead || tailTopRightHead || tailRightHead || tailBottomRightHead || tailBelowHead || tailBottomLeftHead || tailLeftHead || tailTopLeftHead;
    }

    private boolean samePosition(Knot from, Knot target) {
        return target.column == from.column && target.row == from.row;
    }

    public long getTailVisitCount() {
        return this.tailPositions.keySet().size();
    }


}
