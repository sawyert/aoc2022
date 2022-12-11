package aoc2022.day11;

import aoc2022.day1.ElfData;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Day11 {
    private List<Monkey> monkeys;

    public Day11(List<Monkey> monkeys) {
        this.monkeys = monkeys;
    }

    public long execute1() {
        for (int round=0; round<20; round++) {
            for (Monkey monkey : this.monkeys) {
                monkey.inspectItems(this.monkeys);
            }
        }

        List<Monkey> orderedList = this.monkeys.stream().sorted(Comparator.comparing(Monkey::getItemsInspectedCount).reversed()).collect(Collectors.toList());
        return orderedList.get(0).getItemsInspectedCount() * orderedList.get(1).getItemsInspectedCount();
    }

    public long execute2() {
        for (int round=0; round<10000; round++) {
            for (Monkey monkey : this.monkeys) {
                monkey.inspectItems(this.monkeys);
            }
        }

        List<Monkey> orderedList = this.monkeys.stream().sorted(Comparator.comparing(Monkey::getItemsInspectedCount).reversed()).collect(Collectors.toList());
        return orderedList.get(0).getItemsInspectedCount() * orderedList.get(1).getItemsInspectedCount();
    }
}
