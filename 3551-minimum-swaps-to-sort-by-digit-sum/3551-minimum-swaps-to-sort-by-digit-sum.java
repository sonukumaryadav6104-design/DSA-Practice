class Solution {
    public int minSwaps(int[] nums) {
        
        int n = nums.length;

        int sum[] = new int[n];

        for(int i = 0; i < n; i++){
            int curr = nums[i];
            int s = 0;
            while(curr > 0){

                int digit = curr%10;
                s += digit;
                curr /= 10;

            }

            sum[i] = s;
        }
        
        Integer[] ind = new Integer[n];

        for(int i = 0;i < n;i++){
            ind[i] = i;
        }

        Arrays.sort(ind , (a,b) -> {

            if(sum[a] != sum[b]){

                return Integer.compare(sum[a] , sum[b]);

            }

            return Integer.compare(nums[a] , nums[b]);
        });

        int []target = new int[n];

        for(int pos = 0; pos<n ; pos++){
            target[ind[pos]] = pos;
        }


        boolean[] visited = new boolean[n];

        int cycles = 0;

        for(int i = 0;i<n;i++){
            if(!visited[i]){
                cycles++;
                int j = i;

                while(!visited[j]){
                    visited[j] = true;
                    j = target[j];
                }
            }
        }

        return n - cycles;

    }
}