package aoc2022.day8;

public class Day8 {
    private int[][] trees;
    public Day8(String[] testInput) {
        this.trees = new int[testInput.length][testInput.length];

        int lineNumber = 0;
        for (String line : testInput) {
            int rowNumber = 0;
            for (char eachChar : line.toCharArray()) {
                int eachNumber = Character.getNumericValue(eachChar);
                this.trees[lineNumber][rowNumber] = eachNumber;
                rowNumber++;
            }
            lineNumber++;
        }
    }

    public long execute1() {
        System.out.println(this.trees);

        long visibleCount = 0;

        for (int i=0; i<this.trees.length; i++) {
            for (int j=0; j<this.trees[i].length; j++) {
                if (this.isVisible(i, j)) {
                    visibleCount++;
                }
            }
        }

        return visibleCount;
    }

    private boolean isVisible(int row, int column) {
        if (row == 0 || column == 0) {
            return true;
        }
        if (row == this.trees.length-1 || column == this.trees.length-1) {
            return true;
        }

        int treeHeight = this.trees[row][column];

        // look up
        boolean foundBlock = false;
        for (int i = row - 1; i >= 0; i--) {
            if (this.trees[i][column] >= treeHeight) {
                foundBlock = true;
            }
        }

        if (foundBlock == false) {
            return true;
        }

        // look down
        foundBlock = false;
        for (int i = row + 1; i < this.trees.length; i++) {
            if (this.trees[i][column] >= treeHeight) {
                foundBlock = true;
            }
        }

        if (foundBlock == false) {
            return true;
        }

        // look left
        foundBlock = false;
        for (int i = column - 1; i >= 0; i--) {
            if (this.trees[row][i] >= treeHeight) {
                foundBlock = true;
            }
        }

        if (foundBlock == false) {
            return true;
        }

        // look right
        foundBlock = false;
        for (int i = column + 1; i < this.trees.length; i++) {
            if (this.trees[row][i] >= treeHeight) {
                foundBlock = true;
            }
        }

        if (foundBlock == false) {
            return true;
        }

        return false;
    }

    private long scenicScore(int row, int column) {

        int thisTreeHeight = this.trees[row][column];

        // look up
        long scoreUp = 0;
        for (int i = row - 1; i >= 0; i--) {
            int treeHeight = this.trees[i][column];
            if (treeHeight < thisTreeHeight) {
                scoreUp += 1;
            } else {
                scoreUp += 1;
                break;
            }
        }


        // look down
        long scoreDown = 0;
        for (int i = row + 1; i < this.trees.length; i++) {
            int treeHeight = this.trees[i][column];
            if (treeHeight < thisTreeHeight) {
                scoreDown += 1;
            } else {
                scoreDown += 1;
                break;
            }
        }


        // look left
        long scoreLeft = 0;
        for (int i = column - 1; i >= 0; i--) {
            int treeHeight = this.trees[row][i];
            if (treeHeight < thisTreeHeight) {
                scoreLeft += 1;
            } else {
                scoreLeft += 1;
                break;
            }
        }


        // look right
        long scoreRight = 0;
        for (int i = column + 1; i < this.trees.length; i++) {
            int treeHeight = this.trees[row][i];
            if (treeHeight < thisTreeHeight) {
                scoreRight += 1;
            } else {
                scoreRight += 1;
                break;
            }
        }

        return scoreLeft * scoreRight * scoreUp * scoreDown;
    }

    public long execute2() {
        long bestScore = 0;

        for (int i=0; i<this.trees.length; i++) {
            for (int j=0; j<this.trees[i].length; j++) {
                long scenicScore = this.scenicScore(i, j);
                if (scenicScore > bestScore) {
                    bestScore = scenicScore;
                }
            }
        }
        return bestScore;
    }
}
