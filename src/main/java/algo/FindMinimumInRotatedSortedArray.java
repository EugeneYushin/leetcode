package algo;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 */
public class FindMinimumInRotatedSortedArray {
    /**
     * Binary search based solution
     * Time complexity: O(logN)
     * Space complexity: O(1)
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (right - left > 1) {
            if (nums[left] <= nums[right]) return nums[left];

            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[left]) right = mid;
            else left = mid;
        }

        return Math.min(nums[left], nums[right]);
    }
}
