import java.util.Scanner;

public class countcommas {

    public static long countCommas(int n) {
        long count = 0;

        // Numbers from 1,000 to 999,999 have 1 comma
        if (n >= 1000) {
            count += (long) n - 999;
        }

        // Numbers from 1,000,000 to 999,999,999 have 2 commas
        if (n >= 1_000_000) {
            count += (long) n - 999_999;
        }

        // Numbers from 1,000,000,000 onwards have 3 commas
        if (n >= 1_000_000_000) {
            count += (long) n - 999_999_999;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.println("Total commas: " + countCommas(n));

        sc.close();
    }
}
