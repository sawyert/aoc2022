package aoc2022.day4;

import java.util.ArrayList;
import java.util.List;

public class Day4 {
    private final String[] testInput;

    public Day4(String[] testInput) {
        this.testInput = testInput;
    }

    public long execute1() {
        long count = 0;
        for (String inputLine: this.testInput) {
            String[] parts = inputLine.split(",");
            String[] rangeLeft = parts[0].split("-");
            String[] rangeRight = parts[1].split("-");

            int startLeft = Integer.parseInt(rangeLeft[0]);
            int endLeft = Integer.parseInt(rangeLeft[1]);
            int startRight = Integer.parseInt(rangeRight[0]);
            int endRight = Integer.parseInt(rangeRight[1]);

            if (startLeft <= startRight && endLeft >= endRight) {
                count++;
                continue;
            }

            if (startRight <= startLeft && endRight >= endLeft) {
                count++;
            }
        }

        return count;
    }

    public long execute2() {
        long count = 0;
        for (String inputLine: this.testInput) {
            String[] parts = inputLine.split(",");
            String[] rangeLeft = parts[0].split("-");
            String[] rangeRight = parts[1].split("-");

            int startLeft = Integer.parseInt(rangeLeft[0]);
            int endLeft = Integer.parseInt(rangeLeft[1]);
            int startRight = Integer.parseInt(rangeRight[0]);
            int endRight = Integer.parseInt(rangeRight[1]);

            List<Integer> leftRange = new ArrayList<>();
            for (int i=startLeft; i<=endLeft; i++) {
                leftRange.add(i);
            }

            List<Integer> rightRange = new ArrayList<>();
            for (int i=startRight; i<=endRight; i++) {
                rightRange.add(i);
            }

            List<Integer> leftRangeCopy = new ArrayList<>();
            leftRangeCopy.addAll(leftRange);

            if (leftRangeCopy.removeAll(rightRange)) {
                count++;
                continue;
            }

            List<Integer> rightRangeCopy = new ArrayList<>();
            rightRangeCopy.addAll(rightRange);

            if (rightRangeCopy.removeAll(leftRange)) {
                count++;
            }

        }

        return count;
    }
}
