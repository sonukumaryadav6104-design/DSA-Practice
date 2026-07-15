class Solution {

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int gcdOfOddEvenSums(int n) {
        int oddSum = 0;
        int evenSum = 0;

        int temp = n;

        int i = 1;
        while (temp-- > 0) {
            oddSum += i;
            i += 2;
        }

        temp = n;

        int j = 2;
        while (temp-- > 0) {
            evenSum += j;
            j += 2;
        }

        return gcd(oddSum, evenSum);
    }
}