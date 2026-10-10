class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
       
       int n = nums1.length;

       int diff[] = new int[n];
       int maxdiff = 0;

        for(int i = 0;i<n;i++){
            diff[i] = Math.abs(nums1[i]-nums2[i]);    
            maxdiff = Math.max(maxdiff , diff[i]);
        }
         
        int countdiff[] = new int[maxdiff+1];

        for(int d : diff){
            countdiff[d]++;
        }

        long k = (long) k1+k2;

        for(int curr = maxdiff ; curr>0 && k>0 ; curr--){

            int countOps = (int)Math.min(countdiff[curr] , k);

            countdiff[curr]    -= countOps;
            countdiff[curr - 1] += countOps;
            k                 -= countOps;


        }

        long result = 0;

        for (long d = 1; d <= maxdiff; d++) {
            result += countdiff[(int) d] * d * d;
        }

        return result;

    }
}



// Giving the tle


// Brute forces
// class Solution {
//     public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {

//         int n = nums1.length;

//         PriorityQueue<Integer> pq =
//             new PriorityQueue<>(Collections.reverseOrder());

//         for (int i = 0; i < n; i++) {
//             pq.offer(Math.abs(nums1[i] - nums2[i]));
//         }

//         long k = (long) k1 + k2;

//         for (long i = 0; i < k; i++) {
//             int max = pq.poll();

//             if (max == 0) {
//                 pq.offer(0);
//                 break;
//             }

//             pq.offer(max - 1);
//         }

//         long sum = 0;

//         while (!pq.isEmpty()) {
//             long x = pq.poll();
//             sum += x * x;
//         }

//         return sum;
//     }
// }
