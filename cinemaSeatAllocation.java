import java.util.*;

public class cinemaSeatAllocation {

    public static int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Map<Integer, Set<Integer>> reserved = new HashMap<>();

        // Store reserved seats row-wise
        for (int[] seat : reservedSeats) {
            reserved
                .computeIfAbsent(seat[0], k -> new HashSet<>())
                .add(seat[1]);
        }

        // Rows with no reserved seats can always fit 2 groups
        int answer = (n - reserved.size()) * 2;

        // Check rows that have reserved seats
        for (Set<Integer> seats : reserved.values()) {

            boolean left = true;    // 2,3,4,5
            boolean middle = true;  // 4,5,6,7
            boolean right = true;   // 6,7,8,9

            for (int seat : seats) {

                if (seat >= 2 && seat <= 5) {
                    left = false;
                }

                if (seat >= 4 && seat <= 7) {
                    middle = false;
                }

                if (seat >= 6 && seat <= 9) {
                    right = false;
                }
            }

            if (left && right) {
                answer += 2;
            } else if (left || middle || right) {
                answer += 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int n = 3;

        int[][] reservedSeats = {
            {1, 2},
            {1, 3},
            {1, 8},
            {2, 6}
        };

        int result = maxNumberOfFamilies(n, reservedSeats);

        System.out.println("Maximum groups: " + result);
    }
}