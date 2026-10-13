class Solution {

    private boolean isPrime(int i, int n) {
        if (i <= 1) {
            return false;
        }

        for (int j = 2; j * j <= i; j++) {
            if (i % j == 0) {
                return false;
            }
        }

        return true;
    }

    public List<Integer> maxPrimes(int n, int s) {
        List<Integer> ans = new ArrayList<>();
        int sum = 0;

        for (int i = 2; i <= n; i++) {
            if (isPrime(i, n)) {

                if (sum + i > s) {
                    break;
                }

                ans.add(i);
                sum += i;
                
            }
        }

        return ans;
    }
}