class Solution{
    private int getDigitSum(int num){
        int sum = 0;

        while(num>0){
            sum+= num%10;
            num /=10;
        }

        return sum;
    }

    private int compareByDigitSum(int num1 , int num2){
        int num1DigitSum = getDigitSum(num1);
        int num2DigitSum = getDigitSum(num2);

        if(num1DigitSum != num2DigitSum){
            return Integer.compare(num1DigitSum , num2DigitSum);
        }

        return Integer.compare(num1 ,num2);
    }

    public int minSwaps(int[] nums){

        int n = nums.length;

        Integer[] afterSorted = new Integer[n];

        for(int i = 0;i<n ;i++){
            afterSorted[i] = nums[i];
        }

        Arrays.sort(afterSorted, this::compareByDigitSum);

        Map<Integer,Integer> valtoIdx = new HashMap<>();

        for(int i = 0;i<n;i++){
            valtoIdx.put(nums[i] , i);
        }

        int swap = 0;

        for(int i = 0; i<n; i++){
            int expectedVal = afterSorted[i];
            int currVal = nums[i];

            if(expectedVal == currVal) continue;

            int idx = valtoIdx.get(expectedVal);

            nums[i] = expectedVal;
            nums[idx]  = currVal;

            valtoIdx.put(expectedVal , i);
            valtoIdx.put(currVal , idx);

            swap++;
        }
        return swap;
    }
}



// class Solution {
//     public int minSwaps(int[] nums) {
        
//         int n = nums.length;

//         int sum[] = new int[n];

//         for(int i = 0; i < n; i++){
//             int curr = nums[i];
//             int s = 0;
//             while(curr > 0){

//                 int digit = curr%10;
//                 s += digit;
//                 curr /= 10;

//             }

//             sum[i] = s;
//         }
        
//         Integer[] ind = new Integer[n];

//         for(int i = 0;i < n;i++){
//             ind[i] = i;
//         }

//         Arrays.sort(ind , (a,b) -> {

//             if(sum[a] != sum[b]){

//                 return Integer.compare(sum[a] , sum[b]);

//             }

//             return Integer.compare(nums[a] , nums[b]);
//         });

//         int []target = new int[n];

//         for(int pos = 0; pos<n ; pos++){
//             target[ind[pos]] = pos;
//         }


//         boolean[] visited = new boolean[n];

//         int cycles = 0;

//         for(int i = 0;i<n;i++){
//             if(!visited[i]){
//                 cycles++;
//                 int j = i;

//                 while(!visited[j]){
//                     visited[j] = true;
//                     j = target[j];
//                 }
//             }
//         }

//         return n - cycles;

//     }
// }