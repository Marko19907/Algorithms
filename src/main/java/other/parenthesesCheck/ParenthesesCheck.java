package other.parenthesesCheck;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Design an algorithm that checks whether a given algebraic expression has balanced parentheses.
 * In other words, we detect missing or extra parentheses. If the given expression has
 * well-balanced parentheses, our algorithm should return -1, otherwise it should output the
 * index of first invalid parenthesis.
 *
 * Case #1
 * Checking (a+1)/(2+c) should return -1 because the given input has balanced parentheses.
 *
 * Case #2
 * Checking (a+(2-c)*3 should return 0 because the first parenthesis is never closed.
 *
 * Case #3
 * Checking (a+b)*3)+c should return 7 because the closing parenthesis at index 7 has no match.
 *
 * Case #4
 * Checking a+b/c should return -1 because it does not contain any parenthesis.
 */
public class ParenthesesCheck {

    /**
     * The initial version of the parentheses check algo.
     */
    public static int checkParentheses(char[] expression) {
        if (expression == null) {
            throw new IllegalArgumentException("The given char array can not be null!");
        }

        final Stack<Integer> openStack = new Stack<>();
        final Stack<Character> brackets = new Stack<>();
        final char open = '(';
        final char close = ')';
        boolean notInterrupted = true;
        boolean containsBrackets = false;
        int toReturn = -1;
        int index = 0;

        while (index < expression.length) {
            if (expression[index] == open) {
                containsBrackets = true;
                brackets.push(expression[index]);

                openStack.add(index);
            }
            if (expression[index] == close) {
                containsBrackets = true;
                try {
                    brackets.pop();
                    openStack.pop();
                }
                catch (EmptyStackException e) {
                    notInterrupted = false;
                    toReturn = index;
                }
            }

            index++;
        }

        if (containsBrackets) {
            if (((brackets.size() % 2) != 0) && notInterrupted) {
                // unmatched start
                toReturn = openStack.pop();
            }
            if (brackets.isEmpty() && notInterrupted) {
                toReturn = -1;
            }
        }

        return toReturn;
    }

    /**
     * An optimized approach to the parentheses check algo.
     */
    public static int checkParenthesesOptimized(char[] expression) {
        final char open = '(';
        final char close = ')';
        int bracketToClose = 0;
        int groupStart = -1;

        for (int index = 0; index < expression.length; index++) {
            if (expression[index] == open) {
                bracketToClose += 1;

                if (bracketToClose == 1) {
                    groupStart = index;
                }
            }
            else if (expression[index] == close) {
                bracketToClose -= 1;
            }

            if (bracketToClose < 0) {
                return index;
            }
        }

        if (bracketToClose > 0) {
            return groupStart;
        }

        return -1;
    }


    public static void main(String[] args) {
        char[] test1 = "(a+1)/(2+c)".toCharArray();
        char[] test2 = "(a+(2-c)*3".toCharArray();
        char[] test3 = "(a+b)*3)+c".toCharArray();
        char[] test4 = "a+b/c".toCharArray();
        char[] test5 = "(((()".toCharArray();

        System.out.println(checkParentheses(test1));
        System.out.println(checkParentheses(test2));
        System.out.println(checkParentheses(test3));
        System.out.println(checkParentheses(test4));

        System.out.println(checkParentheses(test5));
    }
}
