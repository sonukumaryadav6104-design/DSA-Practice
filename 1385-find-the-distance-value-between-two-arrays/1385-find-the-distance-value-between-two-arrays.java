class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        
        int  n = arr1.length;
        int m = arr2.length;

        int ans = 0;

        for(int i = 0; i<n;i++){
            boolean let = false;
            for(int j = 0;j<m;j++){
                long diff = Math.abs(arr1[i] - arr2[j]);
                if(diff<=(long)d){
                   let = true; 
                   break;
                }
            }

            if(!let){
                ans++;
            }
           
           
        }
        return ans;
    }
}