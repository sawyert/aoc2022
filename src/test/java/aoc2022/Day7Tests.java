package aoc2022;

import aoc2022.day7.Day7;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Day7Tests {

    @Test
    void testPart1BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day7Example.txt");

        Day7 day7 = new Day7(testInput);
        assertEquals(95437, day7.execute1());
    }

    @Test
    void testPart1Answer() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day7.txt");


        Day7 day7 = new Day7(testInput);
        long result = day7.execute1();
        assertTrue(result > 68134);
        System.out.println(result);
    }

    @Test
    void testPart2BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day7Example.txt");

        Day7 day7 = new Day7(testInput);
        assertEquals(24933642, day7.execute2());
    }

    @Test
    void testPart2Answer() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day7.txt");

        Day7 day7 = new Day7(testInput);
        long result = day7.execute2();
        System.out.println(result);
    }
}
