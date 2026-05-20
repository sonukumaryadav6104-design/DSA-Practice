class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {

    List<Integer>  li = new ArrayList<>();
    int[] ans = new int[A.length];
    for(int i = 0 ; i<A.length;i++){
        li.add(A[i]);
         int cnt = 0;
        for(int j = 0;j<=i;j++){
           if(li.contains(B[j])){
            cnt++;
           }
        }
        ans[i] = cnt;
    } 
    return ans;
    }
}