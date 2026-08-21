class Solution {
    public int elevatorRequests(int n, int[] requests) {
        
        int k = requests.length;
        int cost = Math.abs(0 - requests[0]);
        for(int i = 0 ; i<k-1;i++){
           int curr   = Math.abs(requests[i] - requests[i+1]);
           cost += curr;
        }
        return cost;
    }
}