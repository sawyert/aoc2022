package aoc2022.day13;

public class Packet {

    private PacketEntryList entry = new PacketEntryList();
    public Packet(String packetString) {
        // remove outermost brackets
        String shortString = packetString.substring(1, packetString.length()-1);
        String remainder = entry.parse(shortString);
    }

    public String toString() {
        return this.entry.toString();
    }

    public int compare(Packet right) {
        return this.entry.compare(right.entry);
    }
}
