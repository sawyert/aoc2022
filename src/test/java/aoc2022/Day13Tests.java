package aoc2022;

import aoc2022.day13.Day13;
import aoc2022.day13.Day13_2;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day13Tests {

    @Test
    void testPart1BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day13Example.txt");

        Day13 day13 = new Day13(testInput);
        assertEquals(13, day13.execute1());
    }

    @Test
    void testPart1Answer() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day13.txt");


        Day13 day13 = new Day13(testInput);
        long result = day13.execute1();
        System.out.println(result);
    }

    @Test
    void testPart2BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day13Example.txt");

        Day13_2 day13 = new Day13_2(testInput);
        assertEquals(140, day13.execute2());
    }

    @Test
    void testPart2Answer() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day13.txt");

        Day13_2 day13 = new Day13_2(testInput);
        long result = day13.execute2();
        System.out.println(result);
    }
}
