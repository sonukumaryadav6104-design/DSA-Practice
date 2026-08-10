// Intuition: bottom-up fill, dp[i] true if some square move leads to a losing state for the opponent
class Solution {
    public boolean winnerSquareGame(int n) {
        
        boolean[] dp = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (!dp[i - j * j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}


// class Solution {
//     // 0 = not calculated, 1 = win, 2 = lose
//     int[] memo;
//     public boolean winnerSquareGame(int n) {
//         memo = new int[n+1];
//         return canWin(n);
//     }

//     // Intuition: impartial game, win/lose only depends on stones left, not on which player moves
//     public boolean canWin(int n) {
//         if (n == 0) return false;
//         if (memo[n] != 0) return memo[n] == 1;
//         boolean win = false;
//         for (int i = 1; i * i <= n; i++) {
//             if (!canWin(n - i * i)) {
//                 win = true;
//                 break;
//             }
//         }
//         memo[n] = win ? 1 : 2;
//         return win;
//     }
// }

// Push based
// class Solution {
//     public boolean winnerSquareGame(int n) {
//         boolean[] dp = new boolean[n + 1];

//         for(int i = 0; i <= n; i++) {
//             if(!dp[i]) {
//                 for(int j = 1; i + j * j <= n; j++) {
//                     dp[i + j * j] = true;
//                 }
//                 if(dp[n]) {
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
// }