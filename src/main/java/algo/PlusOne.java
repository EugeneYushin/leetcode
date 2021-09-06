package algo;

public class PlusOne {
    /**
     * Time complexity: O(N)
     * Space complexity: O(N) worst case (all 9s), O(1) in general
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }

        // all 9s, just increase the size and set the first digit to 1
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
