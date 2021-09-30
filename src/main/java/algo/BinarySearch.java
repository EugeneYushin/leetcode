package algo;

/**
 * https://leetcode.com/problems/binary-search/
 */
public class BinarySearch {
    /**
     * Time complexity: O(logN)
     * Space complexity: O(1)
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;

        // 1, 2, 3, 4, 5, 6
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else return mid;
        }

        return -1;
    }
}
