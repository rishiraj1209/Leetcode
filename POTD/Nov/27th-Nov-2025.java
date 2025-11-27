class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long preSum[] = new long[n];
        preSum[0] = nums[0];
        for(int i=1; i<n; i++){
            preSum[i] = preSum[i-1]+nums[i];
        }
        long maxSum = Long.MIN_VALUE;
        for(int start=0; start<k; start++){
            long runningSum = 0;
            int i = start;
            while(i < n && i+k-1 < n){
                int j = i+k-1;
                long subSum = preSum[j] - (i > 0 ? preSum[i - 1]:0);

                runningSum = Math.max(subSum, runningSum + subSum);
                maxSum = Math.max(maxSum, runningSum);
                i += k;
            }
        }
        return maxSum;
    }
}
