package aoc2022;

import aoc2022.day11.Day11;
import aoc2022.day11.Monkey;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Day11Tests {

    @Test
    void testPart1BasicInputWorks() throws IOException, URISyntaxException {

        Monkey monkey0 = new Monkey();
        monkey0.addItem(79);
        monkey0.addItem(98);
        monkey0.setOperation("old * 19");
        monkey0.setTestDivisibleBy(23);
        monkey0.setTestTrueDestination(2);
        monkey0.setTestFalseDestination(3);

        Monkey monkey1 = new Monkey();
        monkey1.addItem(54);
        monkey1.addItem(65);
        monkey1.addItem(75);
        monkey1.addItem(74);
        monkey1.setOperation("old + 6");
        monkey1.setTestDivisibleBy(19);
        monkey1.setTestTrueDestination(2);
        monkey1.setTestFalseDestination(0);

        Monkey monkey2 = new Monkey();
        monkey2.addItem(79);
        monkey2.addItem(60);
        monkey2.addItem(97);
        monkey2.setOperation("old * old");
        monkey2.setTestDivisibleBy(13);
        monkey2.setTestTrueDestination(1);
        monkey2.setTestFalseDestination(3);

        Monkey monkey3 = new Monkey();
        monkey3.addItem(74);
        monkey3.setOperation("old + 3");
        monkey3.setTestDivisibleBy(17);
        monkey3.setTestTrueDestination(0);
        monkey3.setTestFalseDestination(1);

        List<Monkey> monkeys = new ArrayList<>();
        monkeys.add(monkey0);
        monkeys.add(monkey1);
        monkeys.add(monkey2);
        monkeys.add(monkey3);

        Day11 day11 = new Day11(monkeys);
        assertEquals(10605, day11.execute1());
    }

    @Test
    void testPart1Answer() throws IOException, URISyntaxException {
        Monkey monkey0 = new Monkey();
        monkey0.addItem(77);
        monkey0.addItem(69);
        monkey0.addItem(76);
        monkey0.addItem(77);
        monkey0.addItem(50);
        monkey0.addItem(58);
        monkey0.setOperation("old * 11");
        monkey0.setTestDivisibleBy(5);
        monkey0.setTestTrueDestination(1);
        monkey0.setTestFalseDestination(5);

        Monkey monkey1 = new Monkey();
        monkey1.addItem(75);
        monkey1.addItem(70);
        monkey1.addItem(82);
        monkey1.addItem(83);
        monkey1.addItem(96);
        monkey1.addItem(64);
        monkey1.addItem(62);
        monkey1.setOperation("old + 8");
        monkey1.setTestDivisibleBy(17);
        monkey1.setTestTrueDestination(5);
        monkey1.setTestFalseDestination(6);

        Monkey monkey2 = new Monkey();
        monkey2.addItem(53);
        monkey2.setOperation("old * 3");
        monkey2.setTestDivisibleBy(2);
        monkey2.setTestTrueDestination(0);
        monkey2.setTestFalseDestination(7);

        Monkey monkey3 = new Monkey();
        monkey3.addItem(85);
        monkey3.addItem(64);
        monkey3.addItem(93);
        monkey3.addItem(64);
        monkey3.addItem(99);
        monkey3.setOperation("old + 4");
        monkey3.setTestDivisibleBy(7);
        monkey3.setTestTrueDestination(7);
        monkey3.setTestFalseDestination(2);

        Monkey monkey4 = new Monkey();
        monkey4.addItem(61);
        monkey4.addItem(92);
        monkey4.addItem(71);
        monkey4.setOperation("old * old");
        monkey4.setTestDivisibleBy(3);
        monkey4.setTestTrueDestination(2);
        monkey4.setTestFalseDestination(3);

        Monkey monkey5 = new Monkey();
        monkey5.addItem(79);
        monkey5.addItem(73);
        monkey5.addItem(50);
        monkey5.addItem(90);
        monkey5.setOperation("old + 2");
        monkey5.setTestDivisibleBy(11);
        monkey5.setTestTrueDestination(4);
        monkey5.setTestFalseDestination(6);

        Monkey monkey6 = new Monkey();
        monkey6.addItem(50);
        monkey6.addItem(89);
        monkey6.setOperation("old + 3");
        monkey6.setTestDivisibleBy(13);
        monkey6.setTestTrueDestination(4);
        monkey6.setTestFalseDestination(3);

        Monkey monkey7 = new Monkey();
        monkey7.addItem(83);
        monkey7.addItem(56);
        monkey7.addItem(64);
        monkey7.addItem(58);
        monkey7.addItem(93);
        monkey7.addItem(91);
        monkey7.addItem(56);
        monkey7.addItem(65);
        monkey7.setOperation("old + 5");
        monkey7.setTestDivisibleBy(19);
        monkey7.setTestTrueDestination(1);
        monkey7.setTestFalseDestination(0);

        List<Monkey> monkeys = new ArrayList<>();
        monkeys.add(monkey0);
        monkeys.add(monkey1);
        monkeys.add(monkey2);
        monkeys.add(monkey3);
        monkeys.add(monkey4);
        monkeys.add(monkey5);
        monkeys.add(monkey6);
        monkeys.add(monkey7);

        Day11 day11 = new Day11(monkeys);
        long result = day11.execute1();
        System.out.println(result);
    }

    @Test
    void testPart2BasicInputWorks() throws IOException, URISyntaxException {

        Monkey monkey0 = new Monkey(false);
        monkey0.addItem(79);
        monkey0.addItem(98);
        monkey0.setOperation("old * 19");
        monkey0.setTestDivisibleBy(23);
        monkey0.setTestTrueDestination(2);
        monkey0.setTestFalseDestination(3);

        Monkey monkey1 = new Monkey(false);
        monkey1.addItem(54);
        monkey1.addItem(65);
        monkey1.addItem(75);
        monkey1.addItem(74);
        monkey1.setOperation("old + 6");
        monkey1.setTestDivisibleBy(19);
        monkey1.setTestTrueDestination(2);
        monkey1.setTestFalseDestination(0);

        Monkey monkey2 = new Monkey(false);
        monkey2.addItem(79);
        monkey2.addItem(60);
        monkey2.addItem(97);
        monkey2.setOperation("old * old");
        monkey2.setTestDivisibleBy(13);
        monkey2.setTestTrueDestination(1);
        monkey2.setTestFalseDestination(3);

        Monkey monkey3 = new Monkey(false);
        monkey3.addItem(74);
        monkey3.setOperation("old + 3");
        monkey3.setTestDivisibleBy(17);
        monkey3.setTestTrueDestination(0);
        monkey3.setTestFalseDestination(1);

        List<Monkey> monkeys = new ArrayList<>();
        monkeys.add(monkey0);
        monkeys.add(monkey1);
        monkeys.add(monkey2);
        monkeys.add(monkey3);

        Day11 day11 = new Day11(monkeys);
        assertEquals(2713310158l, day11.execute2());
    }

    @Test
    void testPart2Answer() throws IOException, URISyntaxException {
        Monkey monkey0 = new Monkey(false);
        monkey0.addItem(77);
        monkey0.addItem(69);
        monkey0.addItem(76);
        monkey0.addItem(77);
        monkey0.addItem(50);
        monkey0.addItem(58);
        monkey0.setOperation("old * 11");
        monkey0.setTestDivisibleBy(5);
        monkey0.setTestTrueDestination(1);
        monkey0.setTestFalseDestination(5);

        Monkey monkey1 = new Monkey(false);
        monkey1.addItem(75);
        monkey1.addItem(70);
        monkey1.addItem(82);
        monkey1.addItem(83);
        monkey1.addItem(96);
        monkey1.addItem(64);
        monkey1.addItem(62);
        monkey1.setOperation("old + 8");
        monkey1.setTestDivisibleBy(17);
        monkey1.setTestTrueDestination(5);
        monkey1.setTestFalseDestination(6);

        Monkey monkey2 = new Monkey(false);
        monkey2.addItem(53);
        monkey2.setOperation("old * 3");
        monkey2.setTestDivisibleBy(2);
        monkey2.setTestTrueDestination(0);
        monkey2.setTestFalseDestination(7);

        Monkey monkey3 = new Monkey(false);
        monkey3.addItem(85);
        monkey3.addItem(64);
        monkey3.addItem(93);
        monkey3.addItem(64);
        monkey3.addItem(99);
        monkey3.setOperation("old + 4");
        monkey3.setTestDivisibleBy(7);
        monkey3.setTestTrueDestination(7);
        monkey3.setTestFalseDestination(2);

        Monkey monkey4 = new Monkey(false);
        monkey4.addItem(61);
        monkey4.addItem(92);
        monkey4.addItem(71);
        monkey4.setOperation("old * old");
        monkey4.setTestDivisibleBy(3);
        monkey4.setTestTrueDestination(2);
        monkey4.setTestFalseDestination(3);

        Monkey monkey5 = new Monkey(false);
        monkey5.addItem(79);
        monkey5.addItem(73);
        monkey5.addItem(50);
        monkey5.addItem(90);
        monkey5.setOperation("old + 2");
        monkey5.setTestDivisibleBy(11);
        monkey5.setTestTrueDestination(4);
        monkey5.setTestFalseDestination(6);

        Monkey monkey6 = new Monkey(false);
        monkey6.addItem(50);
        monkey6.addItem(89);
        monkey6.setOperation("old + 3");
        monkey6.setTestDivisibleBy(13);
        monkey6.setTestTrueDestination(4);
        monkey6.setTestFalseDestination(3);

        Monkey monkey7 = new Monkey(false);
        monkey7.addItem(83);
        monkey7.addItem(56);
        monkey7.addItem(64);
        monkey7.addItem(58);
        monkey7.addItem(93);
        monkey7.addItem(91);
        monkey7.addItem(56);
        monkey7.addItem(65);
        monkey7.setOperation("old + 5");
        monkey7.setTestDivisibleBy(19);
        monkey7.setTestTrueDestination(1);
        monkey7.setTestFalseDestination(0);

        List<Monkey> monkeys = new ArrayList<>();
        monkeys.add(monkey0);
        monkeys.add(monkey1);
        monkeys.add(monkey2);
        monkeys.add(monkey3);
        monkeys.add(monkey4);
        monkeys.add(monkey5);
        monkeys.add(monkey6);
        monkeys.add(monkey7);

        Day11 day11 = new Day11(monkeys);
        long result = day11.execute2();
        assertTrue(result < 15051118320l);
        System.out.println(result);
    }
}
