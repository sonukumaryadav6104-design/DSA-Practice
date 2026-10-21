class Solution {
    public int minOperations(String s) {
        int n = s.length();

        
        char mn = 'z';
        char mx = 'a';

        for (int i = 0; i < n; i++) {
            mn = (char) Math.min(mn, s.charAt(i));
            mx = (char) Math.max(mx, s.charAt(i));
        }

        
        boolean sorted = true;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                sorted = false;
                break;
            }
        }

        if (sorted) return 0;

       
        if (n == 2) return -1;

        if (s.charAt(0) == mn || s.charAt(n - 1) == mx) {
            return 1;
        }

        
        boolean mnInPrefix = false;
        boolean mxInSuffix = false;

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == mn) {
                mnInPrefix = true;
            }
        }

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == mx) {
                mxInSuffix = true;
            }
        }

        if (!mnInPrefix && !mxInSuffix) {
            return 3;
        }

        return 2;
    }
}