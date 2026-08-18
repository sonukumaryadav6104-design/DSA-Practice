class Solution {
    public int largestInteger(int[] nums, int k) {
        
       int n = nums.length;
       int freq[] = new int[51];

        for(int x : nums){
          freq[x]++;
        }


        if(k==n){
          int max = nums[0];
          for(int i = 0;i<n;i++){
            max = Math.max(max , nums[i]);
          } 
          return max;
        }

        if (k == 1) {
            for (int i = 50; i >= 0; --i) {
                if (freq[i] == 1) {
                    return i;
                }
            }
            return -1;
        }

        int res = -1;

        if(freq[nums[0]] ==1){
            res = Math.max(res , nums[0]);
        }
        if(freq[nums[n-1]]==1){
            res = Math.max(res , nums[n-1]);
        }


        return res ;
    }
}