package algo;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class FindMinimumInRotatedSortedArray2 {
    /**
     * Binary + Linear search
     * Time complexity: O(N) worst case
     * Space complexity: O(1)
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (nums[left] >= nums[right] && left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[right]) right = mid;
            else if (nums[mid] > nums[right]) left = mid + 1;
            else {  // nums[mid] == nums[right]
                if (nums[mid] == nums[left]) { // 31333 vs 33313, go to linear search
                    left++;
                    right--;
                } else {
                    right = mid;
                }
            }
        }

        return nums[left];
    }
}
