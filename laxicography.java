import java.util.*;

public class laxicography {

    public static int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;

        // {value, original index}
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        // Sort by value
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int[] result = new int[n];

        int start = 0;

        while (start < n) {
            int end = start;

            // Find all values that belong to the same group
            while (end + 1 < n &&
                   arr[end + 1][0] - arr[end][0] <= limit) {
                end++;
            }

            // Collect original indices
            List<Integer> indices = new ArrayList<>();

            for (int i = start; i <= end; i++) {
                indices.add(arr[i][1]);
            }

            // Sort original indices
            Collections.sort(indices);

            // Put smallest values at smallest indices
            for (int i = start; i <= end; i++) {
                result[indices.get(i - start)] = arr[i][0];
            }

            start = end + 1;
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, 7, 6, 2};
        int limit = 3;

        int[] result = lexicographicallySmallestArray(nums, limit);

        System.out.println(Arrays.toString(result));
    }
}
