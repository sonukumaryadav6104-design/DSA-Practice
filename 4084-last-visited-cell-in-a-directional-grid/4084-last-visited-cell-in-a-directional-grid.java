class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int i = 0, j = 0;

        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;

        while (true) {
            char dir = grid[i][j];

            int ni = i;
            int nj = j;

            if (dir == 'R') {
                nj++;
            } else if (dir == 'L') {
                nj--;
            } else if (dir == 'D') {
                ni++;
            } else if (dir == 'U') {
                ni--;
            }

            if (ni < 0 || ni >= m || nj < 0 || nj >= n) {
                break;
            }

            if (visited[ni][nj]) {
                break;
            }

            i = ni;
            j = nj;
            visited[i][j] = true;
        }

        return new int[]{i, j};
    }
}