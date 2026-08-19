import java.util.*;

public class pascalTriangle {

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {

            List<Integer> row = new ArrayList<>();

            // First element
            row.add(1);

            // Middle elements
            for (int j = 1; j < i; j++) {
                int value = triangle.get(i - 1).get(j - 1)
                           + triangle.get(i - 1).get(j);

                row.add(value);
            }

            // Last element
            if (i > 0) {
                row.add(1);
            }

            triangle.add(row);
        }

        return triangle;
    }

    public static void main(String[] args) {

        int numRows = 5;

        List<List<Integer>> result = generate(numRows);

        System.out.println(result);
    }
}