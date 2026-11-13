
import java.util.*;

class Solution {
    
    public long countNonDecreasingSubarrays(int[] nums, int k) {

        int n = nums.length;

        long ans = 0;
        long cost = 0;

        int right = n - 1;

        Deque<int[]> dq = new ArrayDeque<>();

        for (int left = n - 1; left >= 0; left--) {

            int num = nums[left];
            int count = 1;

            
            while (!dq.isEmpty() && dq.peekLast()[0] < num) {

                int[] last = dq.removeLast();

                int val = last[0];
                int cnt = last[1];

                count += cnt;

                cost += (long)(num - val) * cnt;
            }

            dq.addLast(new int[]{num, count});

          
            while (cost > k) {

                int[] first = dq.removeFirst();

                int val = first[0];
                int cnt = first[1];

                cost -= val - nums[right];

                right--;

                if (cnt > 1) {
                    dq.addFirst(new int[]{val, cnt - 1});
                }
            }

            ans += right - left + 1;
        }

        return ans;
    }
}


// // Brute Force
// class Solution {
//     public long countNonDecreasingSubarrays(int[] nums, int k) {

//         int n = nums.length;

//         long total = (long)n * (n + 1) / 2;
//         long not = 0;

//         for (int i = 0; i < n; i++) {

//             int maxel = nums[i];
//             long total_diff = 0;

//             for (int j = i; j < n; j++) {

//                 maxel = Math.max(maxel, nums[j]);

//                 total_diff += maxel - nums[j];

//                 if (total_diff > k) {
//                     not++;
//                 }
//             }
//         }

//         return total - not;
//     }
// }