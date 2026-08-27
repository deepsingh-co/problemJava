public class uniqePath {

    public static int uniquePaths(int m, int n) {
        int[] dp = new int[n];

        // First row
        for (int j = 0; j < n; j++) {
            dp[j] = 1;
        }

        // Calculate paths
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        int m = 10;
        int n = 5;

        int result = uniquePaths(m, n);

        System.out.println("Number of unique paths: " + result);
    }
}
