public class sumWord {

    public static boolean sumGame(String num) {
        int n = num.length();
        int half = n / 2;

        int leftSum = 0;
        int rightSum = 0;
        int leftQ = 0;
        int rightQ = 0;

        // First half
        for (int i = 0; i < half; i++) {
            char c = num.charAt(i);

            if (c == '?') {
                leftQ++;
            } else {
                leftSum += c - '0';
            }
        }

        // Second half
        for (int i = half; i < n; i++) {
            char c = num.charAt(i);

            if (c == '?') {
                rightQ++;
            } else {
                rightSum += c - '0';
            }
        }

        // Odd number of '?' means Alice wins
        if ((leftQ + rightQ) % 2 == 1) {
            return true;
        }

        int sumDiff = leftSum - rightSum;
        int questionDiff = leftQ - rightQ;

        // Bob wins only when the difference can be balanced
        return Math.abs(sumDiff) != (Math.abs(questionDiff) / 2) * 9;
    }

    public static void main(String[] args) {

        String num = "?6?6?000?3";

        boolean result = sumGame(num);

        System.out.println(result);
    }
}
