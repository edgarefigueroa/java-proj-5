package src;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Stack;

public class BalancedBrackets {
    static boolean isParenthesesBalanced(String expr)
    {
        Deque<Character> stack = new ArrayDeque<Character>();
        for (int i = 0; i < expr.length(); i++) {
            char x = expr.charAt(i);

            if (x == '(') {
                stack.push(x);
                continue;
            }
            // is not opening then it must be closing. So stack
            if (stack.isEmpty())
                return false;
            if(x == ')') {
                stack.pop();
            }
        }
        return (stack.isEmpty());
    }

    static boolean isBracketsBalanced(String expr)
    {
        Deque<Character> stack
                = new ArrayDeque<Character>();

        for (int i = 0; i < expr.length(); i++) {
            char x = expr.charAt(i);
            if (x == '(' || x == '[' || x == '{') {
                stack.push(x);
                continue;
            }

            if (stack.isEmpty())
                return false;
            char check;
            switch (x) {
                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;
                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;
                case ']':
                    check = stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }
        return (stack.isEmpty());
    }

    public static boolean balancedParentheses(String s) {
        int numUnclosedOpenParens = 0;
        for (int i = 0; i < s.length(); i += 1) {
            if (s.charAt(i) == '(') {
                numUnclosedOpenParens += 1;
            }
            else if (s.charAt(i) == ')') {
                numUnclosedOpenParens -= 1;
            }

            if (numUnclosedOpenParens < 0) {
                return false;
            }
        }

        return numUnclosedOpenParens == 0;
    }

    public static boolean balancedBrackets(String s) {

        Stack<Character> stack = new Stack<Character>();
        HashMap<Character, Character> bracketPairs = new HashMap<Character, Character>();
        bracketPairs.put(')', '(');
        bracketPairs.put(']', '[');
        bracketPairs.put('}', '{');
        bracketPairs.put('>', '<');

        for (int i = 0; i < s.length(); i += 1) {

            // If character is opening bracket
            if (bracketPairs.containsValue(s.charAt(i))) {
                stack.push(s.charAt(i));
            }
            // Else, if character is closing bracket
            else if (bracketPairs.containsKey(s.charAt(i))) {
                // Closing bracket without matching opening bracket
                if (stack.isEmpty()) {
                    return false;
                }
                // Check that most recent bracket on stack matches
                Character mostRecentBracket = stack.pop();
                if (!mostRecentBracket.equals(bracketPairs.get(s.charAt(i)))) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }


    public static void main(String[] args) {
        String expr = "())";
        String expr1 = "([{}])";
        System.out.println("Balanced Parantheses/Brackets: FT");
        if (isParenthesesBalanced(expr)){
            System.out.println("True");
        }
        else {
            System.out.println("False");
        }
        if (isBracketsBalanced(expr1)) {
            System.out.println("True");
        }
        else {
            System.out.println("False");
        }


        String balancedParens = "(1)";
        String tooManyOpenParens = "((1";
        String tooManyOpenParens1 = "(1)(";
        String tooManyClosedParens = "(1))";
        String startClosedParens = ")(";
        String emptyString = "";

        System.out.println("Balanced Parantheses Testing: TTFFFF");
        System.out.println(balancedParentheses(balancedParens));
        System.out.println(balancedParentheses(emptyString));
        System.out.println(balancedParentheses(tooManyOpenParens));
        System.out.println(balancedParentheses(tooManyOpenParens1));
        System.out.println(balancedParentheses(tooManyClosedParens));
        System.out.println(balancedParentheses(startClosedParens));

        String balancedAngleBrackets = "<<>>";
        String balancedComboBrackets = "<({})>";
        String mismatchedBrackets = "<({)}>";

        System.out.println("Balanced Brackets Testing: TTFFFFTTF");
        System.out.println(balancedBrackets(emptyString));
        System.out.println(balancedBrackets(balancedParens));
        System.out.println(balancedBrackets(tooManyOpenParens));
        System.out.println(balancedBrackets(tooManyOpenParens1));
        System.out.println(balancedBrackets(tooManyClosedParens));
        System.out.println(balancedBrackets(startClosedParens));
        System.out.println(balancedBrackets(balancedAngleBrackets));
        System.out.println(balancedBrackets(balancedComboBrackets));
        System.out.println(balancedBrackets(mismatchedBrackets));


    }

}
