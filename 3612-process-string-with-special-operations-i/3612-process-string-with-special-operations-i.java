class Solution {
    public String processStr(String s) {
        StringBuilder result = new StringBuilder();

        int n = s.length();
        StringBuilder st = new StringBuilder();

        for(int i = 0;i<n;i++){
            st.append(s.charAt(i));
        }
        String sb= st.toString();

        for(int i = 0;i<n;i++){
           String charAtI = s.substring(i, i + 1); 
            if (sb.contains(charAtI) && s.charAt(i) != '*' && s.charAt(i) != '#' && s.charAt(i) != '%') {
                result.append(s.charAt(i));
            }

           else if (s.charAt(i) == '*' && result.length() > 0) {
                result.setLength(result.length() - 1);

           }

           else if (s.charAt(i) == '#') {
                result.append(result.toString());
           } 
           else if(s.charAt(i)=='%'){
            result.reverse();
           }
           
        }
        return result.toString();
    }
}