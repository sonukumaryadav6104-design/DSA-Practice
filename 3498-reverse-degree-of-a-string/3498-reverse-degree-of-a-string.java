class Solution {
    public int reverseDegree(String s) {
        int n =s.length();
        int sum = 0;
        for(int i = 0;i<n;i++){
            int pos = 'z' - Character.toLowerCase(s.charAt(i)) + 1;

            int curr = pos*(i+1);
            sum += curr;
        }
        return sum;
    }
}