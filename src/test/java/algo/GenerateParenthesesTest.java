package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenerateParenthesesTest {
    GenerateParentheses cl = new GenerateParentheses();

    @Test
    void generateParenthesis() {
        assertArrayEquals(new String[]{"()"}, cl.generateParenthesis(1).toArray());
        assertArrayEquals(new String[]{"()()", "(())"}, cl.generateParenthesis(2).toArray());
        assertArrayEquals(new String[]{"()()()", "()(())", "(())()", "(()())", "((()))"},
                cl.generateParenthesis(3).toArray());
        assertArrayEquals(new String[]{
                "()()()()", "()()(())", "()(())()", "()(()())", "()((()))", "(())()()",
                "(())(())", "(()())()", "((()))()", "(()()())", "(()(()))", "((())())", "((()()))", "(((())))"
        }, cl.generateParenthesis(4).toArray());
    }
}