package algo;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/reverse-bits/
 */
public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        return reverseBits_constant(n);
    }

    public int reverseBits_constant(int n) {
        n = (n >>> 16) | (n << 16);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1); // mask take 4 bits, so this last step operates on 2 adjacent groups
        return n;
    }

    public int reverseBits_linear(int n) {
        if (n == 0) return 0;

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;       // shift bits to the left to mirror them eventually
            result += n & 1;    // add the rightmost bit to result
            n >>= 1;            // adjust the rightmost bit of the original input
        }

        return result;
    }
}
