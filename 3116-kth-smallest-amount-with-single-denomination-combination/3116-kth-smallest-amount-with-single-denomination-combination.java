import java.util.*;

class Solution {

    // public long findKth(ArrayList<Integer> result, int k) {
    //     int n = result.size();

    //     int low = 0;
    //     int high = n - 1;

    //     while (low <= high) {

    //         int mid = low + (high - low) / 2;

    //         if (mid == k - 1) {
    //             return result.get(mid);
    //         } 
    //         else if (mid > k - 1) {
    //             high = mid - 1;
    //         } 
    //         else {
    //             low = mid + 1;
    //         }
    //     }

    //     return -1;
    // }

    // public long findKthSmallest(int[] coins, int k) {

    //     int n = coins.length;

    //     Set<Integer> set = new HashSet<>();

    //     for (int i = 0; i < n; i++) {

    //         int curr = coins[i];

    //         for (int j = 1; j <= k; j++) {

    //             set.add(curr * j);

    //         }
    //     }

    //     ArrayList<Integer> result = new ArrayList<>(set);

    //     Collections.sort(result);

    //     return findKth(result, k);



    // Using Inclusion  and Exclusion 
    

    public long findKthSmallest(int[] coins, int k) {

        long low = 1;
        long high = (long) coins[0] * k;

        for (int coin : coins) {
            high = Math.min(high, (long) coin * k);
        }

        while (low < high) {

            long mid = low + (high - low) / 2;

            if (count(mid, coins) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private long count(long x, int[] coins) {

        long total = 0;
        int n = coins.length;

        // Inclusion-exclusion
        for (int mask = 1; mask < (1 << n); mask++) {

            long lcm = 1;
            int bits = 0;
            boolean valid = true;

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) {

                    bits++;

                    lcm = lcm(lcm, coins[i]);

                    if (lcm > x) {
                        valid = false;
                        break;
                    }
                }
            }

            if (!valid) continue;

            long cnt = x / lcm;

            if (bits % 2 == 1) {
                total += cnt;
            } else {
                total -= cnt;
            }
        }

        return total;
    }

    private long gcd(long a, long b) {

        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    private long lcm(long a, long b) {

        return a / gcd(a, b) * b;
    }
}
    
