package algo;

import java.util.Stack;

public class LargestRectangleInHistogram {
    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {
            int h = i == heights.length ? 0 : heights[i];

            while (!stack.empty() && heights[stack.peek()] > h) {
                int currIdx = stack.pop();
                int prevIdx = stack.isEmpty() ? -1 : stack.peek();

                maxArea = Math.max(maxArea, heights[currIdx] * (i - prevIdx - 1));
            }

            stack.push(i);
        }

        return maxArea;
    }
}
