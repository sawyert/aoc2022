package aoc2022.day13;

import java.util.ArrayList;
import java.util.List;

public class PacketEntryList extends AbstractPacketEntry {
    List<AbstractPacketEntry> entries = new ArrayList<>();

    public String parse(String shortString) {
        while(shortString.length() > 0) {
            switch(shortString.charAt(0)){
                case '[':
                    shortString = shortString.substring(1);
                    PacketEntryList newPacketEntry = new PacketEntryList();
                    shortString = newPacketEntry.parse(shortString);
                    this.entries.add(newPacketEntry);
                    break;
                case ']':
                    shortString = shortString.substring(1);
                    return shortString;
                case ',':
                    shortString = shortString.substring(1);
                    break;
                default:
                    // next number
                    shortString = this.parseNumber(shortString);
            }
        }
        return shortString;
    }

    private String parseNumber(String shortString) {
        String numberValue = "";
        while (shortString.length() > 0 && Character.isDigit(shortString.charAt(0))) {
            numberValue += shortString.charAt(0);
            shortString = shortString.substring(1);
        }
        if (numberValue.length() > 0) {
            this.entries.add(new PacketEntryNumber(numberValue));
        }
        return shortString;
    }

    public String toString() {
        StringBuilder returnString = new StringBuilder();
        for (AbstractPacketEntry entry : this.entries) {
            if (returnString.length() > 0) {
                returnString.append(",");
            }
            returnString.append(entry.toString());
        }

        return "[" + returnString.toString() + "]";
    }
}
