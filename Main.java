public class Main {

    public static int divide(int dividend, int divisor) {

        // Overflow case:
        // -2147483648 / -1 = 2147483648
        // which is outside the 32-bit signed integer range.
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine whether the answer should be negative.
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert to positive values using long.
        // long is necessary because abs(Integer.MIN_VALUE)
        // cannot fit inside an int.
        long dividendAbs = Math.abs((long) dividend);
        long divisorAbs = Math.abs((long) divisor);

        long quotient = 0;

        while (dividendAbs >= divisorAbs) {

            long temp = divisorAbs;
            long multiple = 1;

            // Find the largest power-of-2 multiple of divisor
            // that can be subtracted from dividend.
            while (dividendAbs >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            dividendAbs -= temp;
            quotient += multiple;
        }

        // Apply the sign.
        if (negative) {
            quotient = -quotient;
        }

        return (int) quotient;
    }

    public static void main(String[] args) {

        System.out.println(divide(10, 3));     // 3
        System.out.println(divide(7, -3));     // -2
        System.out.println(divide(-7, 3));     // -2
        System.out.println(divide(-10, -3));   // 3
        System.out.println(divide(0, 5));       // 0
        System.out.println(divide(-2147483648, -1)); // 2147483647
    }
}