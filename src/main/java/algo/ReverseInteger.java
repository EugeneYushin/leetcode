package algo;

public class ReverseInteger {
    public int reverse(int x) {
        int out = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            // 7 and -8 respect endings of max/min values
            if (out > Integer.MAX_VALUE / 10 || out == Integer.MAX_VALUE / 10 && pop > 7) return 0;
            if (out < Integer.MIN_VALUE / 10 || out == Integer.MIN_VALUE / 10 && pop < -8) return 0;
            out = out * 10 + pop;
        }
        return out;
    }
}
