package algo;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (!stack.empty() && this.isEnclosed(stack.peek(), c)) stack.pop();
            else stack.push(c);
        }

        return stack.empty();
    }

    private boolean isEnclosed(char c1, char c2) {
        switch (c1) {
            case '[': return c2 == ']';
            case '(': return c2 == ')';
            case '{': return c2 == '}';
            default: return false;
        }
    }
}
