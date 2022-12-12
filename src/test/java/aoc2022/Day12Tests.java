package aoc2022;

import aoc2022.day12.Day12;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Day12Tests {

    @Test
    void testPart1BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day12Example.txt");

        Day12 day12 = new Day12(testInput);
        assertEquals(31, day12.execute1());
    }

    @Test
    void testPart1Answer() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day12.txt");


        Day12 day12 = new Day12(testInput);
        long result = day12.execute1();
        assertTrue(result < 2919);
        System.out.println(result);
    }

    @Test
    void testPart2BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day12Example.txt");

        Day12 day12 = new Day12(testInput);
        assertEquals(29, day12.execute2());
    }

    @Test
    void testPart2Answer() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day12.txt");

        Day12 day12 = new Day12(testInput);
        long result = day12.execute2();
        System.out.println(result);
    }
}
