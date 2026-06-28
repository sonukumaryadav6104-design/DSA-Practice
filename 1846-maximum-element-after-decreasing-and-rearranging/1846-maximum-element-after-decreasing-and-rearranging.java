class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n  = arr.length;
        if(n==1){
            return 1;
        }
        Arrays.sort(arr);
        arr[0] = 1;
        int max  = 0;
        for(int i = 1;i<n;i++){
            if(Math.abs(arr[i] - arr[i-1]) > 1){
                arr[i] = arr[i-1] + 1;
                max = Math.max(max , arr[i]);

            }else{
                max = Math.max(max , arr[i]);
            }
        }
        return max;

        
    }
}