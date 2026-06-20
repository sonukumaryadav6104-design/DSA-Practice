class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        
       List<int[]> list = new ArrayList<>();
       
       for(int[] r : restrictions) list.add(r);

       list.add(new int[]{1,0});
       list.add(new int[]{n,n-1});
      
       list.sort((a, b) -> a[0] - b[0]);


       List<int[]> arr = new ArrayList<>();

       for(int[] r : list){
        if(!arr.isEmpty() && arr.get(arr.size()-1)[0] == r[0]){
            arr.get(arr.size()-1)[1] = Math.min(arr.get(arr.size()-1)[1],r[1]);
        }
        else{
            arr.add(r);
        }
       }
       int m = arr.size();

       for(int i =1;i<m;i++){
        int[] prev = arr.get(i-1);
        int[] cur = arr.get(i);
        int maxPossible = prev[1] + (cur[0] - prev[0]);
        cur[1] = Math.min(cur[1],maxPossible);
       }

       for (int i = m - 2; i >= 0; i--) {
            int[] cur = arr.get(i);
            int[] next = arr.get(i + 1);
            int maxPossible = next[1] + (next[0] - cur[0]);
            cur[1] = Math.min(cur[1], maxPossible);
        }

        int ans = 0;
        for (int i = 0; i < m; i++) ans = Math.max(ans, arr.get(i)[1]);

        for (int i = 1; i < m; i++) {
            int[] a = arr.get(i - 1);
            int[] b = arr.get(i);
            int dist = b[0] - a[0];
            int peak = (a[1] + b[1] + dist) / 2;
            ans = Math.max(ans, peak);
        }
        

          return ans;

    }
}