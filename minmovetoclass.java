import java.util.*;

public class Main {

    static class State {
        int r, c;
        int mask;
        int energy;

        State(int r, int c, int mask, int energy) {
            this.r = r;
            this.c = c;
            this.mask = mask;
            this.energy = energy;
        }
    }

    public static int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int startR = 0;
        int startC = 0;
        int litterCount = 0;

        // Find starting position and count litter
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                char ch = classroom[r].charAt(c);

                if (ch == 'S') {
                    startR = r;
                    startC = c;
                }

                if (ch == 'L') {
                    litterCount++;
                }
            }
        }

        // No litter
        if (litterCount == 0) {
            return 0;
        }

        // Give every litter cell a unique ID
        int[][] litterId = new int[m][n];

        for (int[] row : litterId) {
            Arrays.fill(row, -1);
        }

        int id = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (classroom[r].charAt(c) == 'L') {
                    litterId[r][c] = id++;
                }
            }
        }

        // All litter collected
        int allCollected = (1 << litterCount) - 1;

        /*
         * visited[row][column][mask][energy]
         */
        boolean[][][][] visited =
                new boolean[m][n][1 << litterCount][energy + 1];

        Queue<State> queue = new LinkedList<>();

        // Start state
        queue.offer(new State(startR, startC, 0, energy));
        visited[startR][startC][0][energy] = true;

        int[][] directions = {
                {1, 0},   // down
                {-1, 0},  // up
                {0, 1},   // right
                {0, -1}   // left
        };

        int moves = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            // Process all states at the current distance
            while (size-- > 0) {

                State current = queue.poll();

                int r = current.r;
                int c = current.c;
                int mask = current.mask;
                int currentEnergy = current.energy;

                // All litter collected
                if (mask == allCollected) {
                    return moves;
                }

                for (int[] dir : directions) {

                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    // Check boundaries
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }

                    // Cannot move through obstacle
                    if (classroom[nr].charAt(nc) == 'X') {
                        continue;
                    }

                    // No energy means no movement
                    if (currentEnergy == 0) {
                        continue;
                    }

                    // Moving costs 1 energy
                    int newEnergy = currentEnergy - 1;

                    int newMask = mask;

                    char cell = classroom[nr].charAt(nc);

                    // Collect litter
                    if (cell == 'L') {
                        int litterIndex = litterId[nr][nc];
                        newMask |= (1 << litterIndex);
                    }

                    // Reset energy at R
                    if (cell == 'R') {
                        newEnergy = energy;
                    }

                    // Visit new state
                    if (!visited[nr][nc][newMask][newEnergy]) {

                        visited[nr][nc][newMask][newEnergy] = true;

                        queue.offer(
                                new State(
                                        nr,
                                        nc,
                                        newMask,
                                        newEnergy
                                )
                        );
                    }
                }
            }

            moves++;
        }

        return -1;
    }

    public static void main(String[] args) {

        String[] classroom = {
                "S..",
                ".L.",
                "..R"
        };

        int energy = 3;

        int answer = minMoves(classroom, energy);

        System.out.println("Minimum moves = " + answer);
    }
}
