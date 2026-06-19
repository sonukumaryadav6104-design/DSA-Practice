class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int ans = 0;
        int current = 0 ;

        for(int i =0 ;i<n;i++){
             current  = current + gain[i];
             ans  = Math.max(ans , current);
        }
        return ans;
    }
}