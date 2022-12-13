package aoc2022.day9;

public class Day9 {
    private final String[] testInput;
    private final Grid grid = new Grid();

    public Day9(String[] testInput) {
        this.testInput = testInput;
    }

    public long execute1() {
        for (String instruction : this.testInput) {
            grid.moveHeadPart1(instruction);
        }

        return grid.getTailVisitCount();
    }

    public long execute1UsingPart2() {
        this.grid.addKnots(1);
        for (String instruction : this.testInput) {
            grid.moveHeadPart2(instruction);
        }

        return grid.getTailVisitCount();
    }

    public long execute2() {
        this.grid.addKnots(9);
        for (String instruction : this.testInput) {
            grid.moveHeadPart2(instruction);
        }

        return grid.getTailVisitCount();
    }
}
