class Solution {
    public int minMoves2(int[] nums) {
         int n  = nums.length;
         int arr[] = Arrays.copyOf(nums , n);
         Arrays.sort(arr);

        // int min = Integer.MAX_VALUE;

        int mid = arr[n/2];

        // for(int i = 0;i<n;i++){
        //     min = Math.min(min , nums[i]);
        // }
        
        int moves = 0;
        for(int i = 0;i<n;i++){
            if(mid>nums[i]){
              moves += mid-nums[i];
            }
            else{
                moves += nums[i]-mid;
            }
        }

        return moves;
    }
}