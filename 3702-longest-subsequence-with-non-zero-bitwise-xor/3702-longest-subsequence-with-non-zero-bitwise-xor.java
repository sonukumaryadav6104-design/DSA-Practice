class Solution {

    public int longestSubsequence(int[] nums) {

        int n = nums.length;

        int totalxor = 0;
        boolean yes = true;

        for (int x : nums) {

            totalxor ^= x;

            if (x != 0) {
                yes = false;
            }
        }

        if (totalxor > 0) {
            return n;
        }

        return yes ? 0 : n - 1;
    }
}