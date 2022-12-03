package aoc2022;

import aoc2022.day2.Day2;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day2Tests {

    @Test
    void testPart1BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day2Example.txt");

        Day2 Day2 = new Day2(testInput);
        assertEquals(15, Day2.execute1());
    }

    @Test
    void testPart1Answer() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day2.txt");

        Day2 Day2 = new Day2(testInput);
        System.out.println(Day2.execute1());
    }


    @Test
    void testPart2BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day2Example.txt");

        Day2 Day2 = new Day2(testInput);
        assertEquals(12, Day2.execute2());
    }

    @Test
    void testPart2Answer() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day2.txt");

        Day2 Day2 = new Day2(testInput);
        System.out.println(Day2.execute2());
    }
}
