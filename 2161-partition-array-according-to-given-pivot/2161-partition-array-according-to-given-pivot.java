class Solution {
    public int[] pivotArray(int[] arr, int pivot) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0; i < n ; i++){
            if(arr[i] < pivot){
                ans.add(arr[i]);
            }
        }
        for(int i = 0; i < n ; i++){
            if(arr[i] == pivot){
                ans.add(arr[i]);
            }
        }

        for(int i = 0; i < n ; i++){
            if(arr[i] > pivot){
                ans.add(arr[i]);
            }
        }
        return  ans.stream().mapToInt(Integer::intValue).toArray();

    }
}