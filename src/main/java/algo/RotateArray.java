package algo;

/**
 * https://leetcode.com/problems/rotate-array/
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 2) return;

        k %= nums.length;
        if (k == 0) return;

        rotate_3timesReverse(nums, k);
    }

    /**
     * Reverse array 3 times
     * Time complexity: O(N)
     * Space complexity: O(1)
     */
    public void rotate_3timesReverse(int[] nums, int k) {
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] a, int start, int end) {
        while (start < end) {
            int tmp = a[start];
            a[start] = a[end];
            a[end] = tmp;
            start++;
            end--;
        }
    }

    /**
     * Brute-force solution
     * Error: Time Limit Exceeded
     * <p>
     * Time complexity: O(N*K), N = length of nums array, K = N mod k
     * Space complexity: O(1)
     */
    public void rotate_bruteforce(int[] nums, int k) {
        while (k-- > 0) {
            int tmp = nums[nums.length - 1];
            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = tmp;
        }
    }
}
