import java.util.*;

public class stoneGame {

    static int[] prefix;
    static int[][] memo;

    public static int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;

        // Prefix sum
        prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        // Memoization table
        memo = new int[n][n];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dfs(0, n - 1);
    }

    static int dfs(int left, int right) {

        // Only one stone remains
        if (left == right) {
            return 0;
        }

        // Already calculated
        if (memo[left][right] != -1) {
            return memo[left][right];
        }

        int ans = 0;

        // Try every possible split
        for (int k = left; k < right; k++) {

            int leftSum = getSum(left, k);
            int rightSum = getSum(k + 1, right);

            if (leftSum < rightSum) {

                // Bob throws right part
                // Alice keeps left part
                ans = Math.max(
                    ans,
                    leftSum + dfs(left, k)
                );

            } else if (leftSum > rightSum) {

                // Bob throws left part
                // Alice keeps right part
                ans = Math.max(
                    ans,
                    rightSum + dfs(k + 1, right)
                );

            } else {

                // Equal sums: Alice chooses either side
                ans = Math.max(
                    ans,
                    Math.max(
                        leftSum + dfs(left, k),
                        rightSum + dfs(k + 1, right)
                    )
                );
            }
        }

        memo[left][right] = ans;
        return ans;
    }

    // Returns sum of stoneValue[left...right]
    static int getSum(int left, int right) {
        return prefix[right + 1] - prefix[left];
    }

    public static void main(String[] args) {

        int[] stoneValue = {6, 2, 3, 4, 5, 5};

        int answer = stoneGameV(stoneValue);

        System.out.println("Maximum score = " + answer);
    }
}