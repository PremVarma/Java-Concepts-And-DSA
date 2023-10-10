package ds.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Expressions {
    public static void main(String[] args) {
//        BODMAS => Bracket, Order, Divide, Multiply. Add. Subtract
//        Infix => Normal expression (a*b)
//        Postfix => Operand and then Operator (ab*)
//        Prefix => Operator and operand (*ab)
        String exp = "a+b*(c^d-e)^(f+g*h)-i";

        // Function call
        System.out.println(infixToPostfix(exp));
    }

    static int Prec(char ch)
    {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    // The main method that converts
    // given infix expression
    // to postfix expression.
    static String infixToPostfix(String exp)
    {
        // Initializing empty String for result
        StringBuilder result = new StringBuilder();

        // Initializing empty stack
        Deque<Character> stack
                = new ArrayDeque<Character>();

        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);

            // If the scanned character is an
            // operand, add it to output.
            if (Character.isLetterOrDigit(c))
                result.append(c);

                // If the scanned character is an '(',
                // push it to the stack.
            else if (c == '(')
                stack.push(c);

                // If the scanned character is an ')',
                // pop and output from the stack
                // until an '(' is encountered.
            else if (c == ')') {
                while (!stack.isEmpty()
                        && stack.peek() != '(') {
                    result.append(stack.peek());
                    stack.pop();
                }

                stack.pop();
            }

            // An operator is encountered
            else
            {
                while (!stack.isEmpty()
                        && Prec(c) <= Prec(stack.peek())) {

                    result.append(stack.peek());
                    stack.pop();
                }
                stack.push(c);
            }
        }

        // Pop all the operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression";
            result.append(stack.peek());
            stack.pop();
        }

        return result.toString();
    }
}
