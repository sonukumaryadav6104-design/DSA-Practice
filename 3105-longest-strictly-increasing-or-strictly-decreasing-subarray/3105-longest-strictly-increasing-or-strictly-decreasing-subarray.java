class Solution {
    public int longestMonotonicSubarray(int[] nums) {

        int n = nums.length;
        int ans = 1;

        for (int i = 0; i < n; i++) {

            int inc = 1;
            int dec = 1;

            for (int j = i + 1; j < n; j++) {

                if (nums[j - 1] < nums[j]) {
                    inc++;
                    dec = 1;
                }
                else if (nums[j - 1] > nums[j]) {
                    dec++;
                    inc = 1;
                }
                else {
                    break;
                }

                ans = Math.max(ans, Math.max(inc, dec));
            }
        }

        return ans;
    }
}