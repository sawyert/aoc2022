package aoc2022;

import aoc2022.day4.Day4;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day4Tests {

    @Test
    void testPart1BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day4Example.txt");

        Day4 day4 = new Day4(testInput);
        assertEquals(2, day4.execute1());
    }

    @Test
    void testPart1Answer() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day4.txt");

        Day4 day4 = new Day4(testInput);
        System.out.println(day4.execute1());
    }

    @Test
    void testPart2BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day4Example.txt");

        Day4 day4 = new Day4(testInput);
        assertEquals(4, day4.execute2());
    }

    @Test
    void testPart2Answer() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day4.txt");

        Day4 day4 = new Day4(testInput);
        System.out.println(day4.execute2());
    }
}
