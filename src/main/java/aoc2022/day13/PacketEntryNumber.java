package aoc2022.day13;

public class PacketEntryNumber extends AbstractPacketEntry {
    private final String number;
    public PacketEntryNumber(String number) {
        this.number = number;
    }

    public String toString() {
        return number;
    }
}
