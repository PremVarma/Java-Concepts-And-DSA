package ds.Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Expressions {
    public static void main(String[] args) {
//        BODMAS => Bracket, Order, Divide, Multiply. Add. Subtract
//        Infix => Normal expression (a*b)
//        Postfix => Operand and then Operator (ab*)
//        Prefix => Operator and operand (*ab)
        String exp = "a+b*(c^d-e)^(f+g*h)-i";

        // Function call
        System.out.println(infixToPostfix(exp));
        postfixToInfix("AB-DE+F*/");
        prefixToInfix("*+PQ-MN");
    }

    static int precedence(char ch) {
        return switch (ch) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }

    // Check if character is operator
    static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }

    // Reverse and replace brackets
    static String reverseAndSwap(String exp) {
        StringBuilder result = new StringBuilder();
        for (int i = exp.length() - 1; i >= 0; i--) {
            char ch = exp.charAt(i);
            if (ch == '(') result.append(')');
            else if (ch == ')') result.append('(');
            else result.append(ch);
        }
        return result.toString();
    }

    // Convert infix to postfix
    static String infixToPostfix(String exp) {
        StringBuilder result = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : exp.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result.append(stack.pop());
                stack.pop();
            } else if (isOperator(ch)) {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty())
            result.append(stack.pop());

        return result.toString();
    }

    // Convert infix to prefix
    public static String infixToPrefix(String infix) {
        String reversed = reverseAndSwap(infix);
        String postfix = infixToPostfix(reversed);
        return new StringBuilder(postfix).reverse().toString();
    }

    public static String postfixToInfix(String postfix) {
        Deque<String> stack = new ArrayDeque<>();
        for (char c : postfix.toCharArray()) {
            if (isOperator(c)) {
                String first = stack.pop();
                String second = stack.pop();
                stack.push("(" + second + c + first + ")");
            } else if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c));
            }
        }
        System.out.println(stack.peek());
        return stack.pop();
    }

    public static String prefixToInfix(String prefix) {
        Deque<String> stack = new ArrayDeque<>();
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char ch = prefix.charAt(i);

            if (!isOperator(ch)) {
                stack.push(String.valueOf(ch)); // Operand
            } else {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String exp = "(" + op1 + ch + op2 + ")";
                stack.push(exp);
            }
        }
        System.out.println(stack.peek());
        return stack.pop();
    }

    public static String postfixToPrefix(String postfix) {
        Deque<String> stack = new ArrayDeque<>();

        for (char ch : postfix.toCharArray()) {
            if (!isOperator(ch)) {
                stack.push(String.valueOf(ch)); // Operand
            } else {
                String op2 = stack.pop();
                String op1 = stack.pop();
                String expr = ch + op1 + op2;
                stack.push(expr);
            }
        }

        return stack.pop();
    }


}
