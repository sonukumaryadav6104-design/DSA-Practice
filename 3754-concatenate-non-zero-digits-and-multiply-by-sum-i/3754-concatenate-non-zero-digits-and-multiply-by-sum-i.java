class Solution {
    public long sumAndMultiply(int n) {
        
        String s = Integer.toString(n);

        StringBuilder st = new StringBuilder();
        long sum = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) != '0'){
                st.append(s.charAt(i));
                sum += Character.getNumericValue(s.charAt(i));
            }
        }
        if(st.length()==0){
            return 0 ;
        }
        long ans = Long.parseLong(st.toString());
        return ans * sum;
    }
}