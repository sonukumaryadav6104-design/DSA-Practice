// Brute forces
class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        for (int len = k; len <= n; len++) {
            String result = "";
            for (int start = 0; start + len <= n; start++) { 

                String temp = s.substring(start, start + len); 
                int ones = 0;
                for (char ch : temp.toCharArray()) {
                    ones += (ch == '1') ? 1 : 0;
                }
               
                if (ones == k) {
                    if (result.isEmpty() || temp.compareTo(result) < 0)
                        result = temp;
                }
            }

           
            if (!result.isEmpty())
                return result;
        }
        return "";
    }
}


// (Sliding Window)


// class Solution {
//     public String shortestBeautifulSubstring(String s, int k) {
//         int n = s.length();
//         int i = 0;
//         int ones = 0;     
//         String result = "";
//         for (int j = 0; j < n; j++) {
//             if (s.charAt(j) == '1')
//                 ones++;
          
//             while (ones > k || s.charAt(i) == '0') {
//                 if (s.charAt(i) == '1')
//                     ones--;
//                 i++;
//             }
//             if (ones == k) {
//                 String temp = s.substring(i, j + 1);
//                 if (result.isEmpty()
//                     || j - i + 1 < result.length()
//                     || (j - i + 1 == result.length() && temp.compareTo(result) < 0)) {
//                     result = temp;
//                 }
//             }
//         }
//         return result;
//     }
// }