package aoc2022;

import aoc2022.day3.Day3;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day3Tests {

    @Test
    void testPart1BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day3Example.txt");

        Day3 day3 = new Day3(testInput);
        assertEquals(157, day3.execute1());
    }

    @Test
    void testPart1Answer() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day3.txt");

        Day3 day3 = new Day3(testInput);
        System.out.println(day3.execute1());
    }

    @Test
    void testPart2BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day3Example.txt");

        Day3 day3 = new Day3(testInput);
        assertEquals(70, day3.execute2());
    }

    @Test
    void testPart2Answer() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day3.txt");

        Day3 day3 = new Day3(testInput);
        System.out.println(day3.execute2());
    }
}
