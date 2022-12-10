package aoc2022;

import aoc2022.day10.Day10;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day10Tests {

    @Test
    void testPart1SimpleInputWorks() {
        String[] cmdArray = new String[3];
        cmdArray[0] = "noop";
        cmdArray[1] = "addx 3";
        cmdArray[2] = "addx -5";
        Day10 day10 = new Day10(cmdArray);
        day10.execute1();
    }

    @Test
    void testPart1BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day10Example.txt");

        Day10 day10 = new Day10(testInput);
        assertEquals(13140, day10.execute1());
    }

    @Test
    void testPart1Answer() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day10.txt");


        Day10 day10 = new Day10(testInput);
        long result = day10.execute1();
        System.out.println(result);
    }

    @Test
    void testPart2BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day10Example.txt");

        Day10 day10 = new Day10(testInput);
        day10.execute2();
    }

    @Test
    void testPart2Answer() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day10.txt");

        Day10 day10 = new Day10(testInput);
        long result = day10.execute2();
        System.out.println(result);

        // NOT PCPBKAPJ
        // IS PCPBKAPJ
    }
}
