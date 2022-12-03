package aoc2022.day3;

public class Rucksack {

    private final String left;
    private final String right;
    private final String contents;

    public Rucksack(String line) {
        int length = line.length();
        int halfSize = length / 2;
        this.contents = line;
        this.left = line.substring(0, halfSize);
        this.right = line.substring(halfSize);
    }

    public String getCommonItem() {
        for (int i=0; i<this.left.length(); i++) {
            for (int j=0; j<this.right.length(); j++) {
                if (this.left.charAt(i) == this.right.charAt(j)) {
                    return "" + this.left.charAt(i);
                }
            }
        }
        throw new UnsupportedOperationException("Duplicate item not found");
    }

    public String getContents() {
        return this.contents;
    }
}
