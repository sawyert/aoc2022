package aoc2022.day13;

import aoc2022.day11.Monkey;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Day13_2 {
    private List<Packet> packets = new ArrayList<>();

    public Day13_2(String[] testInput) {
        this.packets.add(new Packet("[[2]]"));
        this.packets.add(new Packet("[[6]]"));
        for (int i=0; i<testInput.length; i+=3) {
            String leftString = testInput[i];
            String rightString = testInput[i+1];

            this.packets.add(new Packet(leftString));
            this.packets.add(new Packet(rightString));
        }
    }


    public long execute2() {
        List<Packet> sortedPackets = this.packets.stream().sorted((i, j) -> i.compare(j)).collect(Collectors.toList());

        int total = 1;
        for (int i=1; i<=sortedPackets.size(); i++) {
            if (sortedPackets.get(i-1).toString().equals("[[2]]") || sortedPackets.get(i-1).toString().equals("[[6]]")) {
                total *= i;
            }
        }
        return total;
    }
}
