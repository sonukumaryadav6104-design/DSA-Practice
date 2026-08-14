class Solution {

    public int maximumLengthSubstring(String s) {

        int n = s.length();

        int res = 0;

        for (int left = 0; left < n; left++) {

            int[] freq = new int[26];

            for (int right = left; right < n; right++) {

                int ch = s.charAt(right) - 'a';
                freq[ch]++;

                if (freq[ch] > 2) {
                    break;
                }

                res = Math.max(res, right - left + 1);
                
            }
        }
        return res;
    }
}