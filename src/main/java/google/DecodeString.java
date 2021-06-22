package google;

import java.util.Stack;

class Tuple2<F, S> {
    F first;
    S second;

    Tuple2(F f, S s) {
        first = f;
        second = s;
    }
}

class DecodeString {
    public String decodeString(String s) {
        return decodeStringStack(s);
    }

    String decodeStringStack(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            StringBuilder builder = new StringBuilder();
            if (c == ']') {
                // get string to decode
                while (!stack.empty() && stack.peek() != '[') {
                    builder.append(stack.pop());
                }

                // pop '['
                stack.pop();

                // get k
                int base = 1;
                int k = 0;
                while (!stack.empty() && Character.isDigit(stack.peek())) {
                    k = k + base * (stack.pop() - '0');
                    base *= 10;
                }

                // push decoded string back to stack (reversed)
                while (k > 0) {
                    for (int i = builder.length() - 1; i >= 0; i--) {
                        stack.push(builder.charAt(i));
                    }
                    k--;
                }
            } else {
                stack.push(c);
            }
        }

        StringBuilder result = new StringBuilder(stack.size());
        while (!stack.empty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }

    String decodeStringRecursive(String s) {
        return decode(s).first;
    }

    private Tuple2<String, Integer> decode(String s) {
        int i = 0;
        StringBuilder builder = new StringBuilder();

        while (i < s.length()) {
            if (s.charAt(i) == ']') {
                return new Tuple2<>(builder.toString(), ++i);
            } else if (Character.isDigit(s.charAt(i))) {
                int repeats = 0;
                while (Character.isDigit(s.charAt(i))) {
                    repeats = 10 * repeats + Character.getNumericValue(s.charAt(i++));
                }
                Tuple2<String, Integer> decoded = decode(s.substring(++i));
                builder.append(repeat(decoded.first, repeats));
                i += decoded.second;
            } else {
                builder.append(s.charAt(i++));
            }
        }

        return new Tuple2<>(builder.toString(), i);
    }

    private String repeat(String s, int times) {
        if (times <= 0) return "";
        else return s + repeat(s, times - 1);
    }
}
