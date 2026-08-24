import java.util.Scanner;

public class perfectSquare {

    public static int numSquares(int n) {
        int[] dp = new int[n + 1];

        // Worst case: n = 1 + 1 + 1 + ...
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
        }

        // Try every perfect square
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                int square = j * j;
                dp[i] = Math.min(dp[i], dp[i - square] + 1);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(numSquares(n));

        sc.close();
    }
}
