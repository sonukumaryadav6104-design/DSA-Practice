
import java.util.*;

class Solution {
    public long maxAlternatingSum(int[] nums) {

        int n = nums.length;

         int[] Nums = Arrays.stream(nums)
                .boxed()
                .sorted(Comparator.comparingInt(Math::abs))
                .mapToInt(Integer::intValue)
                .toArray();

        long ans = 0;
        int i = 0;
        int j = n - 1;

        while (i <= j) {
            if (i == j) {
                ans += 1L * Nums[j] * Nums[j];
                break;
            }

            ans += 1L * Nums[j] * Nums[j];
            ans -= 1L * Nums[i] * Nums[i];

            i++;
            j--;
        }

        return ans;
    }
}
