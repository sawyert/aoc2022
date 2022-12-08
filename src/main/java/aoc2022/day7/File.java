package aoc2022.day7;

public class File {
    private long size;
    private String filename;

    public File(String line) {
        int spacePosition = line.indexOf(" ");
        String size = line.substring(0, spacePosition).trim();
        String filename = line.substring(spacePosition).trim();

        this.size = Long.parseLong(size);
        this.filename = filename;
    }

    public long getSize() {
        return size;
    }
}
