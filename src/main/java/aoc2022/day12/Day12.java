package aoc2022.day12;

public class Day12 {

    private final int[][] map;
    private final int[][] visitedDistances;

    private static final String ALPHABET = "_abcdefghijklmnopqrstuvwxyz";

    private int startRow = 0;
    private int startColumn = 0;
    private int endRow = 0;
    private int endColumn = 0;

    private static final int DESTINATION = 999;
    private static final int START = -999;


    public Day12(String[] testInput) {
        this.map = new int[testInput.length][testInput[0].length()];
        int rowNumber = 0;
        for (String line : testInput) {
            int columnNumber = 0;
            char[] lineChars = line.toCharArray();
            for (char eachChar : lineChars) {

                if (eachChar == 'S') {
                    this.startRow = rowNumber;
                    this.startColumn = columnNumber;
                    this.map[rowNumber][columnNumber] = START;
                } else if (eachChar == 'E') {
                    this.endRow = rowNumber;
                    this.endColumn = columnNumber;
                    this.map[rowNumber][columnNumber] = DESTINATION;
                } else {
                    this.map[rowNumber][columnNumber] = 'z'+1-eachChar; // ALPHABET.indexOf(eachChar);
                }

                columnNumber++;
            }
            rowNumber++;
        }

        this.visitedDistances = new int[this.map.length][this.map[0].length];
    }

    private int path(int oldRow, int oldColumn) {
        int newCount = this.visitedDistances[oldRow][oldColumn] + 1;
        int lowestCount = 9999999;

        for(int direction = 1; direction <= 7; direction+=2) {  // ???
            int newRow = oldRow + ((direction % 3) - 1);
            int newColumn = oldColumn + ((direction / 3) - 1);

            if (newRow >= 0 && newColumn >= 0 && newRow < this.map.length && newColumn < this.map[0].length) {

                boolean canMoveThere = this.map[newRow][newColumn] <= this.map[oldRow][oldColumn] + 1 || this.map[oldRow][oldColumn] == DESTINATION || this.map[newRow][newColumn] == START;
                boolean isVisitedOrBetter = this.visitedDistances[newRow][newColumn] == 0 || newCount < this.visitedDistances[newRow][newColumn];
                if (canMoveThere && isVisitedOrBetter) {
                    this.visitedDistances[newRow][newColumn] = newCount;
                    if (newRow == this.startRow && newColumn == this.startColumn) {
                        return newCount;
                    }
                    lowestCount = Math.min(lowestCount, this.path(newRow, newColumn));
                }
            }
        }
        return lowestCount;
    }

    private int path2(int oldRow, int oldColumn) {
        int newCount = this.visitedDistances[oldRow][oldColumn] + 1;
        int lowestCount = 9999999;

        for(int direction = 1; direction <= 7; direction+=2) {  // ???
            int newRow = oldRow + ((direction % 3) - 1);
            int newColumn = oldColumn + ((direction / 3) - 1);

            if (newRow >= 0 && newColumn >= 0 && newRow < this.map.length && newColumn < this.map[0].length) {

                boolean canMoveThere = this.map[newRow][newColumn] <= this.map[oldRow][oldColumn] + 1 || this.map[oldRow][oldColumn] == DESTINATION || this.map[newRow][newColumn] == START;
                boolean isVisitedOrBetter = this.visitedDistances[newRow][newColumn] == 0 || newCount < this.visitedDistances[newRow][newColumn];
                if (canMoveThere && isVisitedOrBetter) {
                    this.visitedDistances[newRow][newColumn] = newCount;
                    if (this.map[newRow][newColumn] == 26) {
                        return newCount;
                    }
                    lowestCount = Math.min(lowestCount, this.path2(newRow, newColumn));
                }
            }
        }
        return lowestCount;
    }

    public long execute1() {
        return path(this.endRow, this.endColumn);
    }

    public long execute2() {
        return path2(this.endRow, this.endColumn);
    }
}
