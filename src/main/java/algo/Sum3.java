package algo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 */
public class Sum3 {
    /**
     * Time complexity: O(N^2)
     * Space complexity: O(1)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();

        if (nums.length < 3) return result;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) { // skip duplicates on the left
                int lo = i + 1;
                int hi = nums.length - 1;

                while (lo < hi) {
                    if (nums[i] + nums[lo] + nums[hi] < 0) lo++;
                    else if (nums[i] + nums[lo] + nums[hi] > 0) hi--;
                    else {
                        result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;   // skip duplicates
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;   // skip duplicates
                        lo++;
                        hi--;
                    }
                }
            }
        }

        return result;
    }
}
