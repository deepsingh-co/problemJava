import java.util.*;

public class numLength {

    public static String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];

        // Convert integers to strings
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        // Custom comparator
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // Handle case like [0, 0]
        if (arr[0].equals("0")) {
            return "0";
        }

        // Build answer
        StringBuilder result = new StringBuilder();

        for (String s : arr) {
            result.append(s);
        }

        return result.toString();
    }

    public static void main(String[] args) {

        int[] nums = {3, 30, 34, 5, 9};

        String answer = largestNumber(nums);

        System.out.println(answer);
    }
}