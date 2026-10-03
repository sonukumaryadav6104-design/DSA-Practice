import java.util.*;
class Solution {
    public int longestValidParentheses(String s) {
       Stack<Integer> st = new Stack<>();

       st.add(-1);

       int max = 0;
       for(int curr = 0; curr<s.length() ; curr++){

        char c = s.charAt(curr);

        if(c == '('){
            st.push(curr);
        }
        else{

            st.pop();

            if(st.isEmpty()){

                st.push(curr);

            }

            else{

                int len = curr-st.peek();
                
                max =Math.max(max,len);
            }
        }
       }
       return max;
    }
}