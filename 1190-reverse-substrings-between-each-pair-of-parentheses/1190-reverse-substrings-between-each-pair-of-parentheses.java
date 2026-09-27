class Solution {

    public String reverseParentheses(String s) {

        Stack<Integer> open = new Stack<>();

        StringBuilder result = new StringBuilder();

        for (char currentChar : s.toCharArray()) {
            if (currentChar == '(') {
                
                open.push(result.length());

            } else if (currentChar == ')') {
                int start = open.pop();
                
                reverse(result, start, result.length() - 1);
            } else {
                
                result.append(currentChar);
            }
        }

        return result.toString();
    }

    private void reverse(StringBuilder sb, int start, int end) {

        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start++, sb.charAt(end));
            sb.setCharAt(end--, temp);
        }
    }
}