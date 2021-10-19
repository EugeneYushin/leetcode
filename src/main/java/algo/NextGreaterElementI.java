package algo;

import java.util.*;

/**
 * https://leetcode.com/problems/next-greater-element-i/
 */
public class NextGreaterElementI {
    /**
     * Stack based solution
     * Time complexity: O(n2)
     * Space complexity: O(n2)
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> indexes = new HashMap<>(nums2.length);
        Stack<Integer> stack = new Stack<>();

        for (int n2: nums2) {
            while (!stack.empty() && stack.peek() < n2) indexes.put(stack.pop(), n2);
            stack.push(n2);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = indexes.getOrDefault(nums1[i], -1);
        }

        return nums1;
    }

    /**
     * Brute force with extra memory
     * Time complexity: O(n2*logn1)
     * Space complexity: O(n1)
     */
    public int[] nextGreaterElement_bruteForce_extraMemory(int[] nums1, int[] nums2) {
        Map<Integer, Integer> indexes = new HashMap<>(nums1.length);
        for (int i = 0; i < nums1.length; i++) {
            indexes.put(nums1[i], i);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(nums1.length);

        for (int n2 : nums2) {
            while (maxHeap.peek() != null && maxHeap.peek() < n2) {
                int n1 = maxHeap.poll();
                int index = indexes.get(n1);
                nums1[index] = n2;
                indexes.remove(n1);
            }

            if (indexes.containsKey(n2)) maxHeap.add(n2);
        }

        for (int index : indexes.values()) nums1[index] = -1;

        return nums1;
    }

    /**
     * Brute force solution with in-place modifications
     * Time complexity: O(n1*n2)
     * Space complexity: O(1)
     */
    public int[] nextGreaterElement_bruteForce_onPlace(int[] nums1, int[] nums2) {
        for (int j = 0; j < nums1.length; j++) {
            int n1 = nums1[j];
            int i = 0;

            while (nums2[i] != n1) i++;

            int res = -1;
            while (++i < nums2.length) {
                if (nums2[i] > n1) {
                    res = nums2[i];
                    break;
                }
            }

            nums1[j] = res;
        }

        return nums1;
    }
}
