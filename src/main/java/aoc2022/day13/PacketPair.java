package aoc2022.day13;

public class PacketPair {

    private Packet left;
    private Packet right;
    public void setLeft(Packet packet) {
        this.left = packet;
    }

    public void setRight(Packet packet) {
        this.right = packet;
    }

    public boolean isRightOrder() {
        return false;
    }
}
