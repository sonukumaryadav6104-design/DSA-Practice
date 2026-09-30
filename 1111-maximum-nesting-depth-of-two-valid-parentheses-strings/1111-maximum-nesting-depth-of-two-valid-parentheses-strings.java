class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        
        int len = seq.length();

        int ans[] = new int[len];

        int currentdepth = 0;

        for(int i = 0;i<len;i++){
             
             if(seq.charAt(i) == '('){
                
                ans[i]= currentdepth & 1;
                currentdepth++;

             }
             else{
                currentdepth--;
                ans[i] = currentdepth & 1;
             }
        }
        return ans;
    }
}