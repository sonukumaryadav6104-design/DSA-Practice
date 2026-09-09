class Solution {

    public long countCommas(long n) {
        long p = 1000, res = 0;
        while (p <= n) {
            res += n - p + 1;
            p *= 1000;
        }
        return res;
    }
}

// class Solution {
//     public long countCommas(long n) {
//         int cnt = 0;
        
//         for(int i =1000;i<=n;i++){
//             if(i>=1000){
//                 cnt +=5;
//             }
        
//         }
        
//         return cnt;
//     }
// }


// class Solution {
//     public long countCommas(long n) {

//         long mid = n; 
//         long commas = 0;

//         long start = 1000;
//         int commaCount = 1;

//         while(start <= mid){

//             long end = start * 1000 - 1;

//             long numbers = Math.min(mid, end) - start + 1;

//             if(numbers > 0)
//                 commas += numbers * commaCount;

//             start *= 1000;
//             commaCount++;

//         }

//         return commas;
//     }
// }