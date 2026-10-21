class Solution {

    //KMP Start
    void computeLPS(int[] pattern, int[] lps) {
        int M = pattern.length;
        int len = 0;
        lps[0] = 0;

        int i = 1;
        while (i < M) {
            if (pattern[i] == pattern[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    boolean search(int[] pat, int[] txt) {
        int N = txt.length;
        int M = pat.length;

        int[] lps = new int[M];
        computeLPS(pat, lps);

        int i = 0; // index for text
        int j = 0; // index for pattern

        while (i < N) {
            if (pat[j] == txt[i]) {
                i++;
                j++;
            }

            if (j == M) {
                return true; // pattern found 

            } else if (i < N && pat[j] != txt[i]) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }
    
    boolean isRotation(int[] vec1, int[] vec2) {
        int[] txt = new int[vec2.length * 2];
        System.arraycopy(vec2, 0, txt, 0, vec2.length);
        System.arraycopy(vec2, 0, txt, vec2.length, vec2.length); // vec2 + vec2
        return search(vec1, txt);
    }

    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        java.util.Arrays.sort(sorted);

        int result = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) continue;

            boolean valid = true;
            for (int start = 0; start < n; start += k) {
                int[] vec1 = java.util.Arrays.copyOfRange(nums, start, start + k);
                int[] vec2 = java.util.Arrays.copyOfRange(sorted, start, start + k);

                if (!isRotation(vec1, vec2)) {
                    valid = false;
                    break;
                }
            }
            if (valid)
                result += k;
        }
        return result;
    }
}





// import java.util.Arrays;

// class Solution {

//     public int sortableIntegers(int[] nums) {
//         int n = nums.length;

//         int[] sorted = nums.clone();
//         Arrays.sort(sorted);

//         int ans = 0;

        
//         for (int k = 1; k <= n; k++) {
//             if (n % k != 0) {
//                 continue;
//             }

//             boolean valid = true;

            
//             for (int start = 0; start < n; start += k) {
//                 if (!canRotate(nums, sorted, start, k)) {
//                     valid = false;
//                     break;
//                 }
//             }

//             if (valid) {
//                 ans += k;
//             }
//         }

//         return ans;
//     }

//     private boolean canRotate( int[] nums, int[] sorted, int start, int k) {

        
//         int[] lps = new int[k];

//         int len = 0;

//         for (int i = 1; i < k; i++) {

//             while (len > 0 && sorted[start + i] != sorted[start + len]) {

//                 len = lps[len - 1];

//             }

//             if (sorted[start + i] == sorted[start + len]) {
//                 len++;
//             }

//             lps[i] = len;
//         }

        
//         int j = 0;

//         for (int i = 0; i < 2 * k - 1; i++) {

//             int value = nums[start + (i % k)];

//             while (j > 0 && value != sorted[start + j]) {

//                 j = lps[j - 1];
                
//             }

//             if (value == sorted[start + j]) {
//                 j++;
//             }

//             if (j == k) {
//                 return true;
//             }
//         }

//         return false;
//     }
// }
