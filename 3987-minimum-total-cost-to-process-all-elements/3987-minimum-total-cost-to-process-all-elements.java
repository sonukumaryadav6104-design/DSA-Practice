class Solution {

    static final long MOD = 1_000_000_007L;

    public int minimumCost(int[] nums, int k) {

        long availableResource = k;
        long totalOperations = 0;
        long totalCost = 0;

        for (int requiredResource : nums) {

            if (availableResource < requiredResource) {

                long operationsNeeded = (requiredResource - availableResource + k - 1L) / k;

                long firstOperation = totalOperations + 1;
                long lastOperation = totalOperations + operationsNeeded;

                long sum = firstOperation + lastOperation;
                long terms = operationsNeeded;

                if (sum % 2 == 0) {
                    sum /= 2;
                } else {
                    terms /= 2;
                }

                long currentCost = ((sum % MOD) * (terms % MOD)) % MOD;

                totalCost = (totalCost + currentCost) % MOD;

                totalOperations += operationsNeeded;
                availableResource += operationsNeeded * (long) k;
            }

            availableResource -= requiredResource;
        }

        return (int) totalCost;
    }
}