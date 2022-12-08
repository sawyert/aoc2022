package aoc2022;

import aoc2022.day6.Day6;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day6Tests {

    @Test
    void testPart1BasicInputWorks() throws IOException, URISyntaxException {
        Day6 day6 = new Day6("mjqjpqmgbljsphdztnvjfqwrcgsmlb");
        assertEquals(7, day6.execute1());

        day6 = new Day6("bvwbjplbgvbhsrlpgdmjqwftvncz");
        assertEquals(5, day6.execute1());

        day6 = new Day6("nppdvjthqldpwncqszvftbrmjlhg");
        assertEquals(6, day6.execute1());

        day6 = new Day6("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg");
        assertEquals(10, day6.execute1());

        day6 = new Day6("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw");
        assertEquals(11, day6.execute1());
    }

    @Test
    void testPart1Answer() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day6.txt");

        Day6 day6 = new Day6(testInput[0]);
        System.out.println(day6.execute1());
    }

    @Test
    void testPart2BasicInputWorks() throws IOException, URISyntaxException {
        Day6 day6 = new Day6("mjqjpqmgbljsphdztnvjfqwrcgsmlb");
        assertEquals(19, day6.execute2());

        day6 = new Day6("bvwbjplbgvbhsrlpgdmjqwftvncz");
        assertEquals(23, day6.execute2());

        day6 = new Day6("nppdvjthqldpwncqszvftbrmjlhg");
        assertEquals(23, day6.execute2());

        day6 = new Day6("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg");
        assertEquals(29, day6.execute2());

        day6 = new Day6("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw");
        assertEquals(26, day6.execute2());
    }

    @Test
    void testPart2Answer() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day6.txt");

        Day6 day6 = new Day6(testInput[0]);
        System.out.println(day6.execute2());
    }
}
