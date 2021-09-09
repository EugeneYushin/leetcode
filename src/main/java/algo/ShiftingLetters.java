package algo;

public class ShiftingLetters {
    /**
     * Time complexity: O(N), N - length of string/shifts array
     * Space complexity: O(1)
     */
    public String shiftingLetters(String s, int[] shifts) {
        for (int i = shifts.length - 2; i >= 0; i--) {
            shifts[i] += shifts[i + 1] %= 26;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i < shifts.length) sb.append(shift(s.charAt(i), shifts[i]));
            else sb.append(s.charAt(i));
        }

        return sb.toString();
    }

    public char shift(char c, int times) {
        return (char) ('a' + (c - 'a' + times) % 26);
    }
}
