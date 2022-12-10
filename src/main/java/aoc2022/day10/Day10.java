package aoc2022.day10;

public class Day10 {

    private String[] commands;
    public Day10(String[] testInput) {
        this.commands = testInput;
    }

    public long execute1() {
        Runner runner = new Runner();
        for (String cmd : this.commands) {
            runner.execute(cmd);
        }

        runner.printStackLog();

        long stackLog20 = runner.getSignalStrength(20);
        long stackLog60 = runner.getSignalStrength(60);
        long stackLog100 = runner.getSignalStrength(100);
        long stackLog140 = runner.getSignalStrength(140);
        long stackLog180 = runner.getSignalStrength(180);
        long stackLog220 = runner.getSignalStrength(220);

        return stackLog20 + stackLog60 + stackLog100 + stackLog140 + stackLog180 + stackLog220;
    }

    public long execute2() {
        Runner runner = new Runner();
        for (String cmd : this.commands) {
            runner.execute(cmd);
        }

        runner.printLetters();

        return 0;
    }
}
