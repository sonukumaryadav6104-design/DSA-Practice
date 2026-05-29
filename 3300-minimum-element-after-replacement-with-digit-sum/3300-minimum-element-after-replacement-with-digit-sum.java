class Solution {
    public int minElement(int[] nums) {
        int n = nums.length;
        
        int arr[] = new int[n];
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ;i < n ; i++){
                int sum = 0;   
                int digits = nums[i];
                while(digits != 0){
                 sum += digits % 10;
                 digits /= 10;   
                 }
                arr[i] = sum;
                ans = Math.min(ans,arr[i]);

        }
        return ans;
    }
}