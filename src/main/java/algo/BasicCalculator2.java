package algo;

import java.util.Stack;

/**
 * https://leetcode.com/problems/basic-calculator-ii/
 */
public class BasicCalculator2 {
    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int calculate(String s) {
        int prevNum = 0;
        int currentNum = 0;
        char currentOp = '+';
        int res = 0;

        // 1+2+3*4-5
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                currentNum = currentNum * 10 + c - '0';
            } // 1, 2, 3

            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if (currentOp == '+') {
                    res += prevNum; // 0+0, 0+1=1, 1+2
                    prevNum = currentNum; //1,2,3
                } else if (currentOp == '-') {
                    res += prevNum;
                    prevNum = -currentNum;
                } else if (currentOp == '*') {
                    prevNum *= currentNum;
                } else {
                    prevNum /= currentNum;
                }

                currentOp = c; // +, +
                currentNum = 0;
            }
        }

        return res + prevNum;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public int calculate_stack(String s) {
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
