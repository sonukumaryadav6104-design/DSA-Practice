class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        int n = landStartTime.length;
        int m = waterStartTime.length;

        int ans = Integer.MAX_VALUE;

        
        for (int i = 0; i < n; i++) {
            int landFinish = landStartTime[i] + landDuration[i];

            for (int j = 0; j < m; j++) {
                int waterFinish =
                    Math.max(landFinish, waterStartTime[j]) + waterDuration[j];

                ans = Math.min(ans, waterFinish);
            }
        }

        
        for (int i = 0; i < m; i++) {
            int waterFinish = waterStartTime[i] + waterDuration[i];

            for (int j = 0; j < n; j++) {
                int landFinish =
                    Math.max(waterFinish, landStartTime[j]) + landDuration[j];

                ans = Math.min(ans, landFinish);
            }
        }

        return ans;
    }
}