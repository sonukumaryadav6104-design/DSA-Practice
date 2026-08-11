class Solution {

    public int missingInteger(int[] nums) {

        int n = nums.length;

        Set<Integer> Set = new HashSet<>(n);
        for (int num : nums) {
            Set.add(num);
        }
        int total = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                total += nums[i];
            } else {
                break;
            }
        }

        while (Set.contains(total)) {
            total += 1;
        }

        return total;
    }
}