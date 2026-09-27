class Solution {
    public int countIntersectingIntervals(int[][] intervals) {
        
        int n = intervals.length;
        int cnt = 0;
         for(int i =0;i<n;i++){
            int prevst = intervals[i][0];
            int prevend = intervals[i][1];

            for(int j = i+1;j<n;j++){
                int currst = intervals[j][0];
                int currend = intervals[j][1];
                
               if(Math.max(prevst , currst) <= Math.min(currend , prevend)){
                  cnt++;
            }
            }


         }
         return cnt;

    }
}