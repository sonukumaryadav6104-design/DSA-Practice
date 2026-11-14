class Solution {
    public int minMergedInteger(int[] nums) {
        int ans = Integer.MAX_VALUE;
        int n  = nums.length;
        for(int i = 1 ;i<n;i+=2){

            // int even = nums[i-1];
            int odd = nums[i] ;
            int digit = 1;

            while(odd!=0){
                digit = digit*10; 
                odd = odd/10;
            }
            ans = Math.min(ans , nums[i-1]*digit + nums[i]);
        }

        return ans;
        
    }
}