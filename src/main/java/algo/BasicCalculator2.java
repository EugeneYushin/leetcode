package algo;

import java.util.Stack;

/**
 * https://leetcode.com/problems/basic-calculator-ii/
 */
public class BasicCalculator2 {
    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        int currentNum = 0;
        char currentOp = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                currentNum = currentNum * 10 + c - '0';
            }

            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if (currentOp == '+') nums.push(currentNum);
                else if (currentOp == '-') nums.push(-currentNum);
                else if (currentOp == '*') nums.push(nums.pop() * currentNum);
                else nums.push(nums.pop() / currentNum);

                currentOp = c;
                currentNum = 0;
            }
        }

        int res = 0;
        while (!nums.empty()) {
            res += nums.pop();
        }

        return res;
    }
}
