class Solution {
    public int[] separateDigits(int[] nums) {

        List<Integer> ans = new ArrayList<>();

        for (int c : nums) {

            String s = Integer.toString(c);

            for (char j : s.toCharArray()) {
                ans.add(Character.getNumericValue(j));
            }
        }

     
        int[] result = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}