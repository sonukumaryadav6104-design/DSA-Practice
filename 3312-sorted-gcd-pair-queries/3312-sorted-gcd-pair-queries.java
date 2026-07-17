class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int n = nums.length;
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        int[] divisorFreq = new int[maxVal + 1];
        for (int i = 0; i < n; i++) { 
            int num = nums[i]; 
            for (int j = 1; (long) j * j <= num; j++) {
                if (num % j == 0) {
                    divisorFreq[j]++;
                    if (num / j != j) {
                        divisorFreq[num / j]++;
                    }
                }
            }
        }

        long[] pairsWithGcd = new long[maxVal + 1];
        for (int g = maxVal; g >= 1; g--) {
            long count = divisorFreq[g];
            
            pairsWithGcd[g] = count * (count - 1) / 2;

            
            for (int mult = 2 * g; mult <= maxVal; mult += g) {
                pairsWithGcd[g] -= pairsWithGcd[mult];
            }
        }

        long[] prefixCountGcd = new long[maxVal + 1];
        for (int g = 1; g <= maxVal; g++) {
            prefixCountGcd[g] = prefixCountGcd[g - 1] + pairsWithGcd[g];
        }

        int[] result = new int[queries.length];
        for (int q = 0; q < queries.length; q++) { 
            long idx = queries[q];
            int l = 1;
            int r = maxVal;
            int temp = 1;
            while (l <= r) {
                int mid_gcd = l + (r - l) / 2;

                if (prefixCountGcd[mid_gcd] > idx) {
                    temp = mid_gcd;
                    r = mid_gcd - 1;
                } else {
                    l = mid_gcd + 1;
                }
            }

            result[q] = temp;
        }
        return result;
    }
}