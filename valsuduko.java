public class valsuduko {

    public static boolean isValidSudoku(char[][] board) {

        boolean[][] rows = new boolean[9][10];
        boolean[][] cols = new boolean[9][10];
        boolean[][] boxes = new boolean[9][10];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                char ch = board[r][c];

                // Ignore empty cells
                if (ch == '.') {
                    continue;
                }

                int num = ch - '0';

                // Find the 3x3 box
                int box = (r / 3) * 3 + (c / 3);

                // Check duplicate
                if (rows[r][num] || cols[c][num] || boxes[box][num]) {
                    return false;
                }

                // Mark as visited
                rows[r][num] = true;
                cols[c][num] = true;
                boxes[box][num] = true;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        if (isValidSudoku(board)) {
            System.out.println("Valid Sudoku");
        } else {
            System.out.println("Invalid Sudoku");
        }
    }
}