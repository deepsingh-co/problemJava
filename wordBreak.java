import java.util.*;

public class wordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);

        int n = s.length();
        boolean[] dp = new boolean[n + 1];

        // Empty string can be segmented
        dp[0] = true;

        for (int i = 1; i <= n; i++) {

            for (int j = 0; j < i; j++) {

                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {

        String s = "leetcode";

        List<String> wordDict = Arrays.asList(
            "leet",
            "code"
        );

        System.out.println(wordBreak(s, wordDict));
    }
}