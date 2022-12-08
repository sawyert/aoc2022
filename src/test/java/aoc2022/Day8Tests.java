package aoc2022;

import aoc2022.day8.Day8;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Day8Tests {

    @Test
    void testPart1BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day8Example.txt");

        Day8 day8 = new Day8(testInput);
        assertEquals(21, day8.execute1());
    }

    @Test
    void testPart1Answer() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day8.txt");


        Day8 day8 = new Day8(testInput);
        long result = day8.execute1();
        System.out.println(result);
    }

    @Test
    void testPart2BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day8Example.txt");

        Day8 day8 = new Day8(testInput);
        assertEquals(8, day8.execute2());
    }

    @Test
    void testPart2Answer() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day8.txt");

        Day8 day8 = new Day8(testInput);
        long result = day8.execute2();
        System.out.println(result);
    }
}
