import java.util.*;

public class Main {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        backtrack(result, new StringBuilder(), 0, 0, n);

        return result;
    }

    public static void backtrack(
            List<String> result,
            StringBuilder current,
            int open,
            int close,
            int n) {

        // If the string has 2*n characters, it is complete
        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }

        // We can add '(' if we haven't used all n opening brackets
        if (open < n) {
            current.append('(');

            backtrack(result, current, open + 1, close, n);

            // Remove the last character (backtracking)
            current.deleteCharAt(current.length() - 1);
        }

        // We can add ')' only if there is an unmatched '('
        if (close < open) {
            current.append(')');

            backtrack(result, current, open, close + 1, n);

            // Remove the last character (backtracking)
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {

        int n = 3;

        List<String> result = generateParenthesis(n);

        System.out.println(result);
    }
}
