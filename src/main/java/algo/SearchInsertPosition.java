package algo;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (target > nums[mid]) left = mid + 1;
            else right = mid;
        }

        return nums[left] < target ? left + 1 : left;
    }
}
