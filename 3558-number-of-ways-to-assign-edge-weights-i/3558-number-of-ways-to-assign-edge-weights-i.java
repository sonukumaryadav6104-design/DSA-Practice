class Solution {
    static final long  MOD = 1_000_000_007L;
    private long power(long base ,  long exponent){

        if(exponent == 0){
            return 1;
        }

        long half = power(base,exponent/2);

        long result = (half * half)%MOD;

        if(exponent % 2 == 1){
            result = (result * base) % MOD;

        }
        return result;
    }

   private int dfs(List<List<Integer>> adj, int x, int f) {
        int maxDep = 0;
        for (int neighbour : adj.get(x)) {
            if (neighbour == f) continue;
            maxDep = Math.max(maxDep, dfs(adj, neighbour, x) + 1);
        }
        return maxDep;
    }

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int maxDep = dfs(adj, 1, 0);
        return (int)power(2, maxDep - 1);
    }
}