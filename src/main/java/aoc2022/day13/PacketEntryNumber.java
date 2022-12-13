package aoc2022.day13;

public class PacketEntryNumber extends AbstractPacketEntry {
    private final String number;
    public PacketEntryNumber(String number) {
        this.number = number;
    }

    public String toString() {
        return number;
    }

    @Override
    protected int compare(AbstractPacketEntry right) {
        if (right instanceof PacketEntryNumber) {
            int leftNumber = Integer.parseInt(this.number);
            int rightNumber = Integer.parseInt(((PacketEntryNumber) right).number);
            if (leftNumber == rightNumber) {
                return 0;
            } else if (leftNumber < rightNumber) {
                return -1;
            } else {
                return 1;
            }
        } else {
            PacketEntryList list = new PacketEntryList();
            list.entries.add(this);

            return list.compare(right);
        }
    }
}
