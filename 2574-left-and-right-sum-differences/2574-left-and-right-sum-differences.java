class Solution {
    public int[] leftRightDifference(int[] nums) {
        
        int leftsum[] = new int[nums.length];
        int rightsum[] = new int[nums.length];
        int lsum = 0;

        for(int i = 0 ;i<nums.length;i++){
            leftsum[i] =  lsum;
            lsum += nums[i];
        }
        int rsum = 0;
        int n = nums.length;
        for(int i = n-1 ;i>=0;i--){
            rightsum[i] =  rsum;
            rsum += nums[i];
        }

        int ans[] = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
           ans[i] = Math.abs(leftsum[i]-rightsum[i]);
        }
        return ans;

    }
}