import java.util.*;

public class minandmax {

    public static int minimumDeletions(int[] nums) {
        int n = nums.length;

        int minIndex = 0;
        int maxIndex = 0;

        // Find minimum and maximum indices
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }

            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        // Smaller and larger index
        int left = Math.min(minIndex, maxIndex);
        int right = Math.max(minIndex, maxIndex);

        // Delete both from front
        int fromFront = right + 1;

        // Delete both from back
        int fromBack = n - left;

        // Delete one from front and one from back
        int fromBoth = (left + 1) + (n - right);

        return Math.min(fromFront, Math.min(fromBack, fromBoth));
    }

    public static void main(String[] args) {

        int[] nums = {2, 10, 7, 5, 4, 1, 8, 6};

        int result = minimumDeletions(nums);

        System.out.println("Minimum deletions: " + result);
    }
}
