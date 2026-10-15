
// Using Hashset

class Solution {
    public int sumCounts(List<Integer> nums){
  
      int ans = 0;
      for(int i = 0;i<nums.size();i++){
        
        HashSet<Integer> st = new HashSet<>();

        for(int j = i ;j<nums.size();j++){
            st.add(nums.get(j));
            
            int distinct = st.size();

            ans += distinct*distinct;
        }
      }
      return ans;
    }
}

// Using List
// class Solution {
//     public int sumCounts(List<Integer> nums) {

//         int ans = 0;

//         for(int i = 0;i<nums.size();i++){
            
//             int distinct = 0;

//             ArrayList<Integer> st = new ArrayList<>();

//             for(int j = i;j<nums.size();j++){

//                  if (!st.contains(nums.get(j))) {
//                     distinct++;
//                     st.add(nums.get(j));
//                 }
                
//                 ans += distinct*distinct;
                

//             }
//         }
//         return ans;
//     }
// }