class Solution {
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][3];

        for(int i=0; i<n; i++){
            Arrays.fill(dp[i],-1);
        }

        return solve(0, 0, nums, dp);
    }

    private int solve (int i, int remainder, int nums[],int dp[][]){
        if(i>=nums.length){
            return (remainder==0)? 0: Integer.MIN_VALUE;
        }

        if(dp[i][remainder] != -1){
            return dp[i][remainder];
        }

        int pick = nums[i] + solve(i+1, (remainder + nums[i]) % 3, nums, dp);
        int notPick = solve(i+1, remainder,nums, dp );

        return dp[i][remainder] = Math.max(pick, notPick);
    }
}
