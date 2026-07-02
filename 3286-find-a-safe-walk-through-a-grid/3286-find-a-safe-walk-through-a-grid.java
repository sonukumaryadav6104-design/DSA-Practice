class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();

        int[][] minCost = new int[n][m];

        for (int[] row : minCost) {
           Arrays.fill(row, Integer.MAX_VALUE);
        }

        minCost[0][0] = grid.get(0).get(0);

        Deque<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{0,0});
        
        int[] directions = {-1, 0, 1, 0, -1};

while (!que.isEmpty()) {
    int[] curr = que.poll();
    int curr_i = curr[0];
    int curr_j = curr[1];

    for (int i = 0; i < 4; i++) {
        int nextRow = curr_i + directions[i];
        int nextCol = curr_j + directions[i + 1];

        if (nextRow >= 0 && nextRow < n &&
            nextCol >= 0 && nextCol < m &&
            minCost[nextRow][nextCol] >
                minCost[curr_i][curr_j] + grid.get(nextRow).get(nextCol)) {

            minCost[nextRow][nextCol] =
                minCost[curr_i][curr_j] + grid.get(nextRow).get(nextCol);

            que.offer(new int[]{nextRow, nextCol});
        }
    }
}

return minCost[n - 1][m - 1] < health;
    }
}