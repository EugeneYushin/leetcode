package algo;

import java.util.Stack;

public class DailyTemperatures {
    /**
     * Time complexity: O(N)
     * Space complexity: O(N)
     */
    public int[] dailyTemperatures_stack(int[] t) {
        int[] days = new int[t.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < t.length; i++) {
            while (!stack.empty() && t[stack.peek()] < t[i]) {
                int prev = stack.peek();
                days[prev] = i - prev;
                stack.pop();
            }

            stack.push(i);
        }

        // stack might be non-empty, but days array already initialized with 0 for these positions
        return days;
    }

    /**
     * Time complexity: O(N)
     * Space complexity: O(1)
     */
    public int[] dailyTemperatures(int[] t) {
        // days till the next warmer day
        int[] days = new int[t.length];
        int maxTemp = 0;

        for (int i = t.length - 1; i >= 0; i--) {
            if (t[i] >= maxTemp) {
                maxTemp = t[i];
                continue;
            }

            int j = 1;

            while (t[i + j] <= t[i]) {
                j += days[i + j];
            }
            days[i] = j;
        }

        return days;
    }
}
