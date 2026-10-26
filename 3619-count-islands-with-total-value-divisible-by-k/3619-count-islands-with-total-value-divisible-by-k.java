
class Solution {

    private long dfs(int[][] grid, int i, int j,int n, int m, boolean[][] visited) {

        
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return 0;
        }

        if (grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }

        visited[i][j] = true;

        long sum = grid[i][j];

        sum += dfs(grid, i - 1, j, n, m, visited);
        sum += dfs(grid, i + 1, j, n, m, visited);
        sum += dfs(grid, i, j - 1, n, m, visited);
        sum += dfs(grid, i, j + 1, n, m, visited);

        return sum;
    }

    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] > 0 && !visited[i][j]) {

                    long sum = dfs(grid, i, j, n, m, visited);

                    if (sum % k == 0) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }
}
