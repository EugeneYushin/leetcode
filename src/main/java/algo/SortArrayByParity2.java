package algo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/sort-array-by-parity-ii
 */
public class SortArrayByParity2 {
    /**
     * 2 heads
     * Time complexity: O(N)
     * Space complexity: O(1)
     */
    public int[] sortArrayByParityII_2heads(int[] nums) {
        int j = 1;
        for (int i = 0; i < nums.length; i += 2) {
            // should be even number
            if ((nums[i] & 1) != 0) { // odd is found
                while (j < nums.length) {
                    // find even
                    if ((nums[j] & 1) == 0) {
                        swap(nums, i, j);
                        break;
                    }
                    j += 2;
                }
            }
        }
        return nums;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * 2 queues
     * Time complexity: O(N)
     * Space complexity: O(2*N/2) => O(N)
     */
    public int[] sortArrayByParityII_2queues(int[] nums) {
        Queue<Integer> odds = new LinkedList<>();
        Queue<Integer> evens = new LinkedList<>();

        for (int i : nums) {
            if ((i & 1) == 0) evens.add(i);
            else odds.add(i);
        }

        int i = 0;
        while (!evens.isEmpty()) {
            nums[i++] = evens.poll();
            nums[i++] = odds.poll();
        }

        return nums;
    }
}
