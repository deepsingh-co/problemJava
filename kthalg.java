import java.util.*;

public class kthalg {

    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    static long lcm(long a, long b, long limit) {
        long g = gcd(a, b);

        // Prevent overflow
        if (a / g > limit / b) {
            return limit + 1;
        }

        return (a / g) * b;
    }

    static long countValid(long x, int[] coins) {
        int n = coins.length;
        long count = 0;

        // Inclusion-exclusion
        for (int mask = 1; mask < (1 << n); mask++) {

            long L = 1;
            int bits = 0;
            boolean tooLarge = false;

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) {
                    bits++;

                    L = lcm(L, coins[i], x);

                    if (L > x) {
                        tooLarge = true;
                        break;
                    }
                }
            }

            if (tooLarge) {
                continue;
            }

            long multiples = x / L;

            if (bits % 2 == 1) {
                count += multiples;
            } else {
                count -= multiples;
            }
        }

        return count;
    }

    static long findKthSmallest(int[] coins, int k) {

        int minCoin = coins[0];

        for (int coin : coins) {
            minCoin = Math.min(minCoin, coin);
        }

        long left = 1;
        long right = (long) minCoin * k;

        while (left < right) {

            long mid = left + (right - left) / 2;

            if (countValid(mid, coins) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {

        int[] coins = {3, 5};
        int k = 5;

        long answer = findKthSmallest(coins, k);

        System.out.println("Answer: " + answer);
    }
}