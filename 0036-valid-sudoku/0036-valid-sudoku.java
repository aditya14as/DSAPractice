class Solution {

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // System.out.println(i+" "+j+"calling box");
                if (!checkBox(board, i * 3, j * 3)) return false;
            }
        }
        for (int i = 0, j = 0; i < 9; i++, j++) {
            if (!checkRowCol(board, i, j)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkBox(char[][] board, int i, int j) {
        int[] temp = new int[10];
        
        for (int k = i; k < i + 3; k++) {
            for (int l = j; l < j + 3; l++) {
               
                char c = board[k][l];
                if (c == '.') continue;
                if (temp[c - '0'] > 0) {
                    return false;
                } else {
                    temp[c - '0']++;
                    // System.out.println(Arrays.toString(temp));
                }
            }
        }
        return true;
    }

    public boolean checkRowCol(char[][] board, int i, int j) {
        int[] tempr = new int[10];
        for (int k = 0; k < 9; k++) {
            char c = board[k][j];
            if (c == '.') continue;
            // System.out.println(digit);
            if (tempr[c - '0'] > 0) {
                System.out.println(i+" "+j);
                return false;
            } else {
                tempr[c - '0']++;
            }
        }
        int[] tempc = new int[10];
        for (int k = 0; k < 9; k++) {
            char c = board[i][k];
            if (c == '.') continue;
            
            if (tempc[c - '0'] > 0) {
                System.out.println(i+" "+j);
                return false;
            } else {
                tempc[c - '0']++;
            }
        }
        return true;
    }
}
