class Solution {
    private int gcd(int a , int b){
        return b == 0 ?  a : gcd(b,a%b);
    }

    public long gcdSum(int[] nums) {
        int n = nums.length;
       
       int mxi = Integer.MIN_VALUE;
       int prefixId[] = new int[n];
        for(int i = 0;i<n;i++){
            mxi = Math.max(mxi , nums[i]);

            prefixId[i] = gcd(nums[i] , mxi);
        }

        Arrays.sort(prefixId);
       
 
    

        long sum = 0;
        for (int i = 0, j = n-1; i < j; i++, j--)
            sum += gcd(prefixId[i], prefixId[j]);
        return sum;

    }
}