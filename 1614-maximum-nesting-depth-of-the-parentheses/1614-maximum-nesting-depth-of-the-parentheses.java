class Solution {
    public int maxDepth(String s) {

        int n = s.length();
        int i = 0;
        int ans = 0;

        int cnt = 0;

        while(i<n){

            if(s.charAt(i) == '('){
                cnt++;
                ans = Math.max(ans , cnt);
                
            }
            else if(s.charAt(i) == ')'){
                   cnt--;
            
            }
            i++;

        }

        return ans;
        
    }
}