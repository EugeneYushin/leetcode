package algo;

public class RomanToInteger {
    public int romanToInt(String s) {
        int out = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int x = this.baseRomanToInt(s.charAt(i));
            if (x * 3 < out) out -= x;
            else out += x;
        }
        return out;
    }

    private int baseRomanToInt(Character c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new IllegalArgumentException("Can't convert from Roman: " + c);
        }
    }
}
