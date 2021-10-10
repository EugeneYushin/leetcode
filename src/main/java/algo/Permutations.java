package algo;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 */
public class Permutations {
    /**
     * Optimized recursive backtracking solution
     * Time complexity: O(n!)
     * Space complexity: O(n) for recursive calls + O(n) for bool array = O(n)
     */
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);

        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, boolean[] used) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!used[i]) {   // O(1), skip already existing values
                    current.add(nums[i]);
                    used[i] = true;
                    backtrack(result, current, nums, used);
                    current.remove(current.size() - 1);
                    used[i] = false;
                }
            }
        }
    }

    /**
     * Recursive backtracking solution
     * Time complexity: O(n*n!)
     * Space complexity: O(n) for recursive calls
     */
    public List<List<Integer>> permute_notOptimal(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        backtrack_notOprimal(result, new ArrayList<>(), nums);

        return result;
    }

    private void backtrack_notOprimal(List<List<Integer>> result, List<Integer> current, int[] nums) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!current.contains(nums[i])) {   // O(N), skip already existing values
                    current.add(nums[i]);
                    backtrack_notOprimal(result, current, nums);
                    current.remove(current.size() - 1);
                }
            }
        }
    }

    /**
     * Iterative backtracking solution
     * Time complexity: O(n!)
     * Space complexity: O(n)
     */
    public List<List<Integer>> permute_iterative(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>() {{
            add(nums[nums.length - 1]);
        }});

        for (int i = nums.length - 2; i >= 0; i--) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> current = result.get(0);  // extra space
                result.remove(0);

                for (int pos = 0; pos <= current.size(); pos++) {
                    current.add(pos, nums[i]);
                    result.add(new ArrayList<>(current));
                    current.remove(pos);    // backtrack
                }
            }
        }

        return result;
    }
}
