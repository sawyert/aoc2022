package aoc2022.day9;

public class Day9 {
    private final String[] testInput;
    private final Grid grid = new Grid();

    public Day9(String[] testInput) {
        this.testInput = testInput;
    }

    public long execute1() {
        for (String instruction : this.testInput) {
            grid.moveHead(instruction);
        }

        return grid.getTailVisitCount();
    }

    public long execute2() {
        return 0;
    }
}
