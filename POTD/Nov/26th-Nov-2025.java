class Solution {
    int mod = 1000000007;
    Integer dp[][][];
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new Integer[m][n][k];

        return solve(0,0,0,grid,k);
    }

    private int solve(int row, int col, int remain, int grid[][], int k){
        int m = grid.length;
        int n = grid[0].length;
        if(row == m || col == n){
            return 0;
        }

        if(row == m-1 && col == n-1){
            return ((remain + grid[m-1][n-1]) % k == 0)? 1 : 0;
        }

        if(dp[row][col][remain] != null){
            return dp[row][col][remain];
        }

        int newRemain = (remain + grid[row][col]) % k;

        int down = solve(row+1, col, newRemain, grid, k);
        int right = solve(row, col+1, newRemain, grid, k);

        return dp[row][col][remain] = (int)(((long)down + right) % mod);
    }
}
