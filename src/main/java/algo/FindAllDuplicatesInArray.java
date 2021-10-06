package algo;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-duplicates-in-an-array
 */
public class FindAllDuplicatesInArray {
    /**
     * Intuition: every time we're at index, replace the value to negative, those next time we're aware if we've been there
     * Time complexity: O(N)
     * Space complexity: O(1)
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] < 0) res.add(idx + 1);

            nums[idx] = -nums[idx];
        }

        return res;
    }

    /**
     * Intuition: we can sort array with O(N) by swapping element with its position keeping in mind nums[i] < nums.length
     * Time complexity: O(N)
     * Space complexity: O(1)
     */
    public List<Integer> findDuplicates_swaps(int[] nums) {
        List<Integer> res = new LinkedList<>();
        int i = 0;

        while (i < nums.length) {
            if (nums[i] == i + 1 || nums[i] == 0) i++;
            else if (nums[i] == nums[nums[i] - 1]) {
                res.add(nums[i]);
                nums[i] = 0;
                i++;
            } else {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }

        return res;
    }
}
