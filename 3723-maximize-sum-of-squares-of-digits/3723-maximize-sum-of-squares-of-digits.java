
// class Solution {
//     public String maxSumOfSquares(int num, int sum) {
//         int start = (int) Math.pow(10, num - 1);
//         int end = start * 10 - 1;

//         int ans = -1;
//         String f = "";

//         for (int i = start; i <= end; i++) {
//             int curr = 0;
//             int temp = i;

//             while (temp != 0) {
//                 int digit = temp % 10;
//                 curr += digit;
//                 temp /= 10;
//             }

//             if (curr == sum) {
//                 int score = 0;
//                 temp = i;

//                 while (temp != 0) {
//                     int digit = temp % 10;
//                     score += digit * digit;
//                     temp /= 10;
//                 }

//                 if (score >= ans) {
//                     ans = score;
//                     f = String.valueOf(i);
//                 }
//             }
//         }

//         return f;
//     }
// }

// 

class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum <= 0 || sum > 9 * num) {
            return "";
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < num; i++) {
            int digit = Math.min(9, sum);
            ans.append(digit);
            sum -= digit;
        }

        return ans.toString();
    }
}

