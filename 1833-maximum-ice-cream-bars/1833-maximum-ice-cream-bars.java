class Solution {
    public int maxIceCream(int[] costs, int coins) {

       int sum = 0;
       int cnt = 0;
       int j = 0;
        Arrays.sort(costs);
        while(sum<=coins && j<costs.length){
            sum += costs[j];
            if(sum<=coins){
                cnt++;
            }
          j++;
        }
       return cnt;
    }
}