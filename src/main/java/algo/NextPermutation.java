package algo;

/**
 * https://leetcode.com/problems/next-permutation/
 */
public class NextPermutation {
    /**
     * Go right to left and find a[i-1] < a[i]
     * All values to the right if a[i-1] are in decreasing order and no bigger permutation is available for them
     * Then swap a[i-1] with the next greater element to the right
     * And reverse the tail
     * <p>
     * Time complexity: O(N)
     * Space complexity: O(1)
     */
    public void nextPermutation(int[] nums) {
        int idx = nums.length - 2;
        while (idx >= 0 && nums[idx] >= nums[idx + 1]) {
            idx--;
        }

        if (idx < 0) {
            reverse(nums, 0, nums.length - 1);
        } else {
            int idxNextGreater = nums.length - 1;
            while (nums[idx] >= nums[idxNextGreater]) idxNextGreater--;

            swap(nums, idx, idxNextGreater);
            reverse(nums, idx + 1, nums.length - 1);
        }
    }

    private void reverse(int[] nums, int lo, int hi) {
        while (lo < hi) {
            swap(nums, lo++, hi--);
        }
    }

    private void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

//    private void quickSort(int[] nums, int lo, int hi) {
//        if (lo >= hi) return;
//
//        int pivot = nums[hi];
//        int i = lo;
//        int j = i;
//
//        while (j < hi) {
//            if (nums[j] < pivot) {
//                swap(nums, i, j);
//                i++;
//            }
//            j++;
//        }
//
//        swap(nums, i, hi);
//        quickSort(nums, lo, i - 1);
//        quickSort(nums, i + 1, hi);
//    }
}
