
class Solution {

    public String helper(StringBuilder sb, int k) {

        if (sb.length() <= k) {
            return sb.toString();
        }

        String s = sb.toString();
        int n = s.length();

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n; i += k) {

            int sum = 0;

            for (int j = i; j < n && j < i + k; j++) {
                sum += s.charAt(j) - '0';
            }

            ans.append(sum);
        }

        return helper(ans, k);
    }

    public String digitSum(String s, int k) {

        StringBuilder sb = new StringBuilder(s);

        return helper(sb, k);
    }
}
