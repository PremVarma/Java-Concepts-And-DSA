package ds.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParenthesis {
    public static void main(String[] args) {
        String paranthesis = "(({}[]))";
        System.out.println(isValidParanthesis(paranthesis));
    }

    private static boolean isValidParanthesis(String parenthesis) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < parenthesis.length(); i++) {
            if (parenthesis.charAt(i) == '(' || parenthesis.charAt(i) == '{' || parenthesis.charAt(i) == '[') {
                deque.push(parenthesis.charAt(i));
            } else {
                if (deque.isEmpty()) return false;
                else if (!isMatching(deque.peek(), parenthesis.charAt(i))) return false;
                else deque.pop();
            }
        }
        return deque.isEmpty();
    }

    static boolean isMatching(char a, char b) {
        return (a == '(' && b == ')') || (a == '{' && b == '}') || (a == '[' && b == ']');
    }
}
