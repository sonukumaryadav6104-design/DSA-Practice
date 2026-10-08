class Solution {
    public String removeOuterParentheses(String s) {

        StringBuilder ans = new StringBuilder();
        int cnt = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                if (cnt > 0) {
                    ans.append(ch);
                }
                cnt++;
            } else {
                cnt--;
                if (cnt > 0) {
                    ans.append(ch);
                }
            }
        }

        return ans.toString();
    }
}