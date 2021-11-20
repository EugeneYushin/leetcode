package algo;

public class SingleElementInSortedArray {
    /**
     * Binary search
     * There's always one half of the array which consists duplicates only
     * Check neighbours of middle element, and if left or right half size is even
     * then it means it doesn't contain unique value and can be skipped
     * <p>
     * Time complexity: O(logN)
     * Space complexity: O(1)
     */
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == nums[mid + 1]) {
                if ((mid - start) % 2 == 0) start = mid + 2;
                else end = mid - 1;
            } else if (nums[mid] == nums[mid - 1]) {
                if ((end - mid) % 2 == 0) end = mid - 2;
                else start = mid + 1;
            } else {
                return nums[mid];
            }
        }

        return nums[start];
    }

    /**
     * Time complexity: O(logN)
     * Space complexity: O(1)
     */
    public int singleNonDuplicate_searchInPairs(int[] nums) {
        // pair index, there're n/2 pairs + 1 unique element
        int start = 0;
        int end = nums.length / 2;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[2 * mid] == nums[2 * mid + 1]) {
                // all pairs to the left are valid pairs, otherwise the first unique element breaks all subsequent pairs
                start = mid + 1;
            } else {
                end = mid;  // mid pair can be the first invalid
            }
        }

        return nums[2 * start];
    }
}
