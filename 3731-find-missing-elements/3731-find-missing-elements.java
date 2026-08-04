class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
       Arrays.sort(nums);
       int j = 0 ;
       for(int i = nums[0] ; i<nums[n-1];i++){
             if(nums[j]==i){
                j++;
             }
             else{
                ans.add(i);
             }
       }
       return ans;
    }
}