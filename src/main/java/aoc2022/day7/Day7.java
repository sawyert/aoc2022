package aoc2022.day7;

import aoc2022.day1.ElfData;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Day7 {
    private Directory rootDirectory = new Directory(null, "/");

    public Day7(String[] testInput) {
        Directory currentDirectory = this.rootDirectory;
        for (String line : testInput) {
            if (line.startsWith("$")) {
                currentDirectory = processCommand(currentDirectory, line);
            } else if (line.startsWith("dir")) {
                String directoryName = line.substring("dir ".length()).trim();
                currentDirectory.addDirectory(directoryName);
            } else {
                currentDirectory.addFile(line);
            }
        }
    }

    private Directory processCommand(Directory currentDirectory, String line) {
        String command = line.substring("$ ".length()).trim();
        String commandKeyword = null;
        String restOfCommand = null;
        if (command.indexOf(" ") == -1) {
          commandKeyword = command;
          restOfCommand = null;
        } else {
            commandKeyword = command.substring(0, command.indexOf(" ")).trim();
            restOfCommand = command.substring(command.indexOf(" ")).trim();
        }
        switch (commandKeyword) {
            case "ls":
                // do nothing
                break;
            case "cd":
                return currentDirectory.getDirectory(restOfCommand);
            default:
                throw new UnsupportedOperationException(line + "not understood");
        }
        return currentDirectory;
    }

    public long execute1() {
        return this.rootDirectory.totalSizeAtMost10k();
    }

    public long execute2() {
        long diskSpace =  70000000;
        long freeRequired = 30000000;
        long used = this.rootDirectory.getSize();
        long freeSpace = diskSpace - used;
        long needToDelete = freeRequired - freeSpace;

        List<Directory> dirs = this.rootDirectory.listDirectories().stream().filter(a -> a.getSize() > needToDelete).sorted(Comparator.comparing(Directory::getSize)).collect(Collectors.toList());

        for (Directory dir : dirs) {
            if (dir.getSize() > needToDelete) {
                System.out.println(dir.getName() + " - " + dir.getSize());
            }
        }
        return dirs.get(0).getSize();
    }
}
