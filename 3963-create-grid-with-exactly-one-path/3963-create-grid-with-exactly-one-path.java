
import java.util.Arrays;

class Solution {
    public String[] createGrid(int m, int n) {
        char[][] arr = new char[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(arr[i], '#');
        }

        for (int j = 0; j < n; j++) {
            arr[0][j] = '.';
        }

        for (int i = 1; i < m; i++) {
            arr[i][n - 1] = '.';
        }

        String[] grid = new String[m];

        for (int i = 0; i < m; i++) {
            grid[i] = new String(arr[i]);
        }

        return grid;
    }
}

