import java.util.*;

public class constractuniformarray {

    public static boolean uniformArray(int[] nums1) {
        int n = nums1.length;

        // If there is only one element, it is already uniform.
        if (n == 1) {
            return true;
        }

        // For n >= 2, it is always possible.
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Enter size of array
        int n = sc.nextInt();

        int[] nums1 = new int[n];

        // Enter array elements
        for (int i = 0; i < n; i++) {
            nums1[i] = sc.nextInt();
        }

        // Call the function
        boolean result = uniformArray(nums1);

        System.out.println(result);

        sc.close();
    }
}
