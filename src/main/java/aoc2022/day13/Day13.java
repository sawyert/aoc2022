package aoc2022.day13;

import java.util.ArrayList;
import java.util.List;

public class Day13 {
    List<PacketPair> pairs = new ArrayList<>();

    public Day13(String[] testInput) {
        for (int i=0; i<testInput.length; i+=3) {
            String leftString = testInput[i];
            String rightString = testInput[i+1];

            PacketPair pair = new PacketPair();
            pair.setLeft(new Packet(leftString));
            pair.setRight(new Packet(rightString));

            this.pairs.add(pair);
        }
    }

    public long execute1() {
        int total = 0;
        for (int i=1; i<=this.pairs.size(); i++) {
            PacketPair pair = this.pairs.get(i-1);
            if (pair.isRightOrder()) {
                System.out.println(i);
                total += i;
            }
        }
        return total;
    }
}
