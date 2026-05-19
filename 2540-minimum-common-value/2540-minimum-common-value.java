class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
         HashSet<Integer> s = new HashSet<>();
        for(int i = 0;i<nums1.length;i++){
            s.add(nums1[i]);

        }
        for(int num : nums2){
            if(s.contains(num)){
                return num;
            }
        }
        return -1;
    }
}