class Solution {
    public int minOperations(int[] nums, int x) {

        int n = nums.length;

        int total = 0;
        for (int num : nums) {
            total += num;
        }

        int target = total - x;

        if (target == 0) {
            return n;
        }

        int left = 0;
        int sum = 0;
        int maxLen = -1;

        for (int right = 0; right < n; right++) {

            sum += nums[right];

            while (sum > target && left <= right) {
                sum -= nums[left];
                left++;
            }

            if (sum == target) {
                maxLen = Math.max(
                    maxLen,
                    right - left + 1
                );
            }
        }

        return maxLen == -1 ? -1 : n - maxLen;
    }
}

// Brute force 
// class Solution {
//     public int minOperations(int[] nums, int x) {

//         int n = nums.length;
//         int ans = Integer.MAX_VALUE;

//         for (int left = 0; left <= n; left++) {

//             int leftsum = 0;

//             for (int i = 0; i < left; i++) {
//                 leftsum += nums[i];
//             }

            
//             if (leftsum > x) {
//                 break;
//             }

//             int rightsum = 0;

//             for (int right = n - 1; right >= left; right--) {

//                 if (leftsum + rightsum == x) {
//                     ans = Math.min(
//                         ans,
//                         left + (n - 1 - right)
//                     );
//                     break;
//                 }

//                 rightsum += nums[right];

//                 if (leftsum + rightsum > x) {
//                     break;
//                 }
//             }

           
//             if (leftsum == x) {
//                 ans = Math.min(ans, left);
//             }
//         }

//         return ans == Integer.MAX_VALUE ? -1 : ans;
//     }
// }