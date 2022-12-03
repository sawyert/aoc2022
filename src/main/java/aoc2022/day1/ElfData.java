package aoc2022.day1;

import java.util.ArrayList;
import java.util.List;

public class ElfData {
    private List<Long> data = new ArrayList<>();

    public void addLine(String eachLine) {
        this.data.add(Long.parseLong(eachLine));
    }

    public Long getTotal() {
        Long total = 0l;
        for (Long longValue : data) {
            total += longValue;
        }
        return total;
    }
}
