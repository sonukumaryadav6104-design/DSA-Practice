


class Solution {

    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            nums[i] *= nums[i];
        }
        
        Arrays.sort(nums);

        long ans = 0;
        for (int i = 0; i < n / 2; i++) {
            ans -= nums[i];
        }
        for (int i = n / 2; i < n; i++) {
            ans += nums[i];
        }
        return ans;
    }
}


// class Solution {
//     public long maxAlternatingSum(int[] nums) {

//         int n = nums.length;
         
//         //  Sort by array by the abs value
//          int[] Nums = Arrays.stream(nums)
//                 .boxed()
//                 .sorted(Comparator.comparingInt(Math::abs))
//                 .mapToInt(Integer::intValue)
//                 .toArray();

//         long ans = 0;
//         int i = 0;
//         int j = n - 1;

//         while (i <= j) {
//             if (i == j) {
//                 ans += 1L * Nums[j] * Nums[j];
//                 break;
//             }

//             ans += 1L * Nums[j] * Nums[j];
//             ans -= 1L * Nums[i] * Nums[i];

//             i++;
//             j--;
//         }

//         return ans;
//     }
// }
