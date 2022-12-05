package aoc2022;

import aoc2022.day5.Day5;
import aoc2022.day5.Stack;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day5Tests {

    @Test
    void testPart1BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day5Example.txt");

        List<Stack> startStacks = new ArrayList<>();
        startStacks.add(new Stack(1, "ZN"));
        startStacks.add(new Stack(2, "MCD"));
        startStacks.add(new Stack(3, "P"));

        Day5 day5 = new Day5(testInput, startStacks);
        assertEquals("CMZ", day5.execute1());
    }

    @Test
    void testPart1Answer() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day5.txt");

        List<Stack> startStacks = new ArrayList<>();
        startStacks.add(new Stack(1, "SLW"));
        startStacks.add(new Stack(2, "JTNQ"));
        startStacks.add(new Stack(3, "SCHFJ"));
        startStacks.add(new Stack(4, "TRMWNGB"));
        startStacks.add(new Stack(5, "TRLSDHQB"));
        startStacks.add(new Stack(6, "MJBVFHRL"));
        startStacks.add(new Stack(7, "DWRNJM"));
        startStacks.add(new Stack(8, "BZTFHNDJ"));
        startStacks.add(new Stack(9, "HLQNBFT"));


        Day5 day5 = new Day5(testInput, startStacks);
        System.out.println(day5.execute1());
    }

    @Test
    void testPart2BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day5Example.txt");

        List<Stack> startStacks = new ArrayList<>();
        startStacks.add(new Stack(1, "ZN"));
        startStacks.add(new Stack(2, "MCD"));
        startStacks.add(new Stack(3, "P"));

        Day5 day5 = new Day5(testInput, startStacks);
        assertEquals("MCD", day5.execute2());
    }

    @Test
    void testPart2Answer() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day5.txt");

        List<Stack> startStacks = new ArrayList<>();
        startStacks.add(new Stack(1, "SLW"));
        startStacks.add(new Stack(2, "JTNQ"));
        startStacks.add(new Stack(3, "SCHFJ"));
        startStacks.add(new Stack(4, "TRMWNGB"));
        startStacks.add(new Stack(5, "TRLSDHQB"));
        startStacks.add(new Stack(6, "MJBVFHRL"));
        startStacks.add(new Stack(7, "DWRNJM"));
        startStacks.add(new Stack(8, "BZTFHNDJ"));
        startStacks.add(new Stack(9, "HLQNBFT"));

        Day5 day5 = new Day5(testInput, startStacks);
        System.out.println(day5.execute2());
    }
}
