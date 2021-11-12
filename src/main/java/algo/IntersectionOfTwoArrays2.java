package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */
public class IntersectionOfTwoArrays2 {
    /**
     * Time complexity: O(NlogN + MlogM + min(N,M)) = O(KlogK), K = max(N,M)
     * Space complexity: O(1) not counting space to store results
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;

        List<Integer> intersection = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) i++;
            else if (nums1[i] > nums2[j]) j++;
            else {
                intersection.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] result = new int[intersection.size()];
        for (int k = 0; k < result.length; k++) result[k] = intersection.get(k);
        return result;
    }
}
