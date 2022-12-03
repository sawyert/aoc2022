package aoc2022.day1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Day1 {
    private List<ElfData> elves = new ArrayList<>();

    public Day1(String[] testInput) {
        ElfData elf = new ElfData();
        this.elves.add(elf);
        for (String eachLine: testInput) {
            if (eachLine.strip().length() < 1) {
                elf = new ElfData();
                this.elves.add(elf);
                continue;
            }
            elf.addLine(eachLine);
        }
    }

    public long execute1() {
        Optional<ElfData> mostCaloriesElf = this.elves.stream().max(Comparator.comparing(ElfData::getTotal)).stream().findFirst();
        return mostCaloriesElf.get().getTotal();
    }

    public long execute2() {
        long total = 0;
        List<ElfData> sortedElves = this.elves.stream().sorted(Comparator.comparing(ElfData::getTotal).reversed()).collect(Collectors.toList());
        List<ElfData> topThreeElves = sortedElves.stream().limit(3).collect(Collectors.toList());
        for (ElfData elf : topThreeElves) {
            total += elf.getTotal();
        }
        return total;
    }
}
