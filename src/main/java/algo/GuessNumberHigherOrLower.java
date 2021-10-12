package algo;

/**
 * https://leetcode.com/problems/guess-number-higher-or-lower/
 */
public class GuessNumberHigherOrLower {
    /**
     * Iterative approach
     * Time complexity: O(logn)
     * Space complexity: O(1)
     */
    public int guessNumber(int n) {
        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int guessed = guess(mid);

            if (guessed == 0) return mid;
            else if (guessed == 1) left = mid + 1;
            else right = mid - 1;
        }

        return -1;
    }

    /**
     * Recursive approach
     * Time complexity: O(logn)
     * Space complexity: O(logn)
     */
    public int guessNumber_recursive(int n) {
        return binarySearch(1, n);
    }

    private int binarySearch(int left, int right) {
        int mid = left + (right - left) / 2;

        switch (guess(mid)) {
            case -1:
                return binarySearch(left, mid - 1);
            case 1:
                return binarySearch(mid + 1, right);
            default:
                return mid;
        }

    }

    private int secret;

    public GuessNumberHigherOrLower(int secret) {
        this.secret = secret;
    }

    public int guess(int i) {
        return Integer.compare(secret, i);
    }
}
