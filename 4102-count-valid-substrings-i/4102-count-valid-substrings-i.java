class Solution {
    public long countValidSubstrings(String s) {

        int n = s.length();

        long total = (long)n * (n + 1) / 2;

        long invalid = 0;

        int last = -1;

        for (int i = 0; i <= n - 3; i++) {

            if (s.charAt(i) == 'a' &&
                s.charAt(i + 1) == 'b' &&
                s.charAt(i + 2) == 'c') {

                int start = i - last;
                int end = n - i - 2;

                invalid += (long)start * end;

                last = i;
            }
        }

        return total - invalid;
    }
}