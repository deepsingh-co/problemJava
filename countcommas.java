public import java.util.Scanner;

public class countcommas {

    public static long countCommas(int n) {
        long count = 0;

        // 1,000 to 999,999 -> 1 comma
        if (n >= 1000) {
            count += (long) n - 999;
        }

        // 1,000,000 to 999,999,999 -> 2 commas
        if (n >= 1_000_000) {
            count += (long) (n - 999_999);
        }

        // 1,000,000,000 onwards -> 3 commas
        if (n >= 1_000_000_000) {
            count += (long) (n - 999_999_999);
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(countCommas(n));

        sc.close();
    }
}
 {
    
}
