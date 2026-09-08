class Solution {
    public int countRotations(String s, int k) {
     
        int n = s.length();
        int total = 0 ;
        for(int i = 1;i<n;i++){

            if(s.charAt(i-1) == s.charAt(i)){
                total++;
            }

        }
        
        if(s.charAt(0)==s.charAt(n-1)){
            total++;
        }

        if(k==total){
            return n-total;
        }
        if(k == total - 1){
            return total;
        }
        return 0;



    }
}