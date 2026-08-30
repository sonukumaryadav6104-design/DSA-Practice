class Solution {
    public int minimumDeletions(int[] nums) {

        int n = nums.length;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == min) {
                minIndex = i;
            }

            if (nums[i] == max) {
                maxIndex = i;
            }
        }

        int bothLeft = Math.max(minIndex, maxIndex) + 1;
        int bothRight = n - Math.min(minIndex, maxIndex);

        int oneLeftOneRight =
            Math.min(minIndex, maxIndex) + 1
            + n - Math.max(minIndex, maxIndex);

        return Math.min(bothLeft, Math.min(bothRight, oneLeftOneRight));
    }
}