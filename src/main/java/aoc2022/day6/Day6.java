package aoc2022.day6;

public class Day6 {
    private final String message;

    public Day6(String message) {
        this.message = message;
    }

    public long execute1() {
        for (int i=3; i<this.message.length(); i++) {
            StringBuilder previousFourChars = new StringBuilder();
            previousFourChars.append(this.message.charAt(i));
            previousFourChars.append(this.message.charAt(i-1));
            previousFourChars.append(this.message.charAt(i-2));
            previousFourChars.append(this.message.charAt(i-3));

            if (!hasDuplicateChar(previousFourChars)) {
                return i+1;
            }
        }
        throw new UnsupportedOperationException();
    }

    private boolean hasDuplicateChar(StringBuilder previousFourChars) {
        for (int i=0; i<previousFourChars.length(); i++) {
            for (int j=0; j<previousFourChars.length(); j++) {
                if (i != j && previousFourChars.charAt(i) == previousFourChars.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int execute2() {
        for (int i=13; i<this.message.length(); i++) {
            StringBuilder previousFourChars = new StringBuilder();
            previousFourChars.append(this.message.charAt(i));
            previousFourChars.append(this.message.charAt(i-1));
            previousFourChars.append(this.message.charAt(i-2));
            previousFourChars.append(this.message.charAt(i-3));
            previousFourChars.append(this.message.charAt(i-4));
            previousFourChars.append(this.message.charAt(i-5));
            previousFourChars.append(this.message.charAt(i-6));
            previousFourChars.append(this.message.charAt(i-7));
            previousFourChars.append(this.message.charAt(i-8));
            previousFourChars.append(this.message.charAt(i-9));
            previousFourChars.append(this.message.charAt(i-10));
            previousFourChars.append(this.message.charAt(i-11));
            previousFourChars.append(this.message.charAt(i-12));
            previousFourChars.append(this.message.charAt(i-13));

            if (!hasDuplicateChar(previousFourChars)) {
                return i+1;
            }
        }
        throw new UnsupportedOperationException();
    }
}
