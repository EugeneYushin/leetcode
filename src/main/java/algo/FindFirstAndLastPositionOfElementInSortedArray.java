package algo;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    private int start;
    private int end;

    /**
     * Time complexity: O(logN)
     * Space complexity: O(logN) to maintain a stack of recursive calls
     */
    public int[] searchRange(int[] nums, int target) {
        start = -1;
        end = -1;
        search(nums, 0, nums.length - 1, target);
        return new int[] {start, end};
    }

    private void search(int[] nums, int lo, int hi, int target) {
        if (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target > nums[mid]) {
                search(nums, mid + 1, hi, target);
            } else if (target < nums[mid]) {
                search(nums, lo, mid - 1, target);
            } else {    // target == nums[mid]
                start = start == -1 ? mid : Math.min(start, mid);
                end = Math.max(end, mid);
                search(nums, lo, mid - 1, target);
                search(nums, mid + 1, hi, target);
            }
        }
    }
}
