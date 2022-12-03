package aoc2022.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day3 {

    private static String PRIORITIES = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private List<Rucksack> rucksacks = new ArrayList<>();

    private List<List<Rucksack>> setsOfThree = new ArrayList<>();

    public Day3(String[] testInput) {
        List<Rucksack> threeSet = new ArrayList<>();

        for (String line : testInput) {
            Rucksack newRucksack = new Rucksack(line);
            rucksacks.add(newRucksack);

            if (threeSet.size() < 3) {
                threeSet.add(newRucksack);
            } else {
                this.setsOfThree.add(threeSet);
                threeSet = new ArrayList<>();
                threeSet.add(newRucksack);
            }
        }
        this.setsOfThree.add(threeSet); // add last one to threeset
    }

    public long execute1() {
        long total = 0;

        for (Rucksack eachRucksack : this.rucksacks) {
            String commonItem = eachRucksack.getCommonItem();
            int priority = this.calculatePriority(commonItem);
            total += priority;
        }

        return total;
    }

    public long execute2() {
        long total = 0;

        for (List<Rucksack> eachSet : this.setsOfThree) {
            String commonItem = this.findCommonItem(eachSet);
            int priority = this.calculatePriority(commonItem);
            total += priority;
        }

        return total;
    }

    private String findCommonItem(List<Rucksack> eachSet) {
        List<Character> l1 = eachSet.get(0).getContents().chars().mapToObj(e -> (char)e).collect(Collectors.toList());
        List<Character> l2 = eachSet.get(1).getContents().chars().mapToObj(e -> (char)e).collect(Collectors.toList());
        List<Character> l3 = eachSet.get(2).getContents().chars().mapToObj(e -> (char)e).collect(Collectors.toList());

        l1.retainAll(l2);
        l1.retainAll(l3);

        return l1.get(0).toString();
    }

    private int calculatePriority(String item) {
        return PRIORITIES.indexOf(item) + 1;
    }
}
