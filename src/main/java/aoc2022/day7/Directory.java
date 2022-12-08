package aoc2022.day7;

import java.util.ArrayList;
import java.util.List;

public class Directory {
    private final String name;
    private final Directory parent;
    private final List<Directory> directories = new ArrayList<>();
    private final List<File> files = new ArrayList<>();

    public String getName() {
        return this.name;
    }

    public Directory findRoot() {
        Directory current = this;
        while (current.parent != null) {
            current = current.parent;
        }
        return current;
    }

    public long getSize() {
        long totalSize = 0;
        for (Directory dir : this.directories) {
            totalSize += dir.getSize();
        }
        for (File file : this.files) {
            totalSize += file.getSize();
        }
        return totalSize;
    }

    public Directory(Directory parent, String name) {
        this.parent = parent;
        this.name = name;
    }

    public void addDirectory(String directoryName) {
        Directory newDirectory = new Directory(this, directoryName);
        this.directories.add(newDirectory);
    }

    public void addFile(String line) {
        File newFile = new File(line);
        this.files.add(newFile);
    }

    public Directory getDirectory(String directoryName) {
        switch (directoryName) {
            case "..":
                return this.parent;
            case "/":
                return this.findRoot();
            default:
                return this.directories.stream().filter(n -> n.getName().equals(directoryName)).findFirst().get();
        }
    }

    public long totalSizeAtMost10k() {
        long total = 0;
        for (Directory dir : this.directories) {
            long size = dir.getSize();
            if (size <= 100000) {
                total += size;
                System.out.println(" ++ Added  " + size + " from " + dir.getName() + " new total " + total);
            }

            long subsize = dir.totalSizeAtMost10k();
            System.out.println(" ++ Added  " + subsize + " from " + dir.getName() + " new total " + total);
            total += subsize;
        }

        return total;
    }

    public List<Directory> listDirectories() {
        List<Directory> returnDirectories = new ArrayList<>();
        for (Directory dir : this.directories) {
            returnDirectories.add(dir);
            returnDirectories.addAll(dir.listDirectories());
        }

        return returnDirectories;

    }
}
