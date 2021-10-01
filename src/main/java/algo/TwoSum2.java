package algo;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSum2 {
    /**
     * 2 pointers
     * Time complexity: O(N)
     * Space complexity: O(1)
     */
    public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;
        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if (sum > target) end--;
            else if (sum < target) start++;
            else return new int[] {start + 1, end + 1};
        }
        return null;
    }

    /**
     * Hash based solution
     * Time complexity: O(N)
     * Space complexity: O(N)
     */
    public int[] twoSum_hash(int[] numbers, int target) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            Integer id1 = hash.get(numbers[i]);
            if (id1 != null) return new int[] {id1 + 1, i + 1};
            hash.put(target - numbers[i], i);
        }
        return null;
    }
}
