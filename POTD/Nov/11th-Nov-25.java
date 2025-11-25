class Solution {
    private int dp[][][];
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int count[][] = new int[len][2];
        for(int i=0; i<len; i++){
            int countZero = 0; int countOne = 0;
            for(char c: strs[i].toCharArray()){
                if(c == '0'){
                    countZero++;
                }else{
                    countOne++;
                }
            }
            count[i][0] = countZero;
            count[i][1] = countOne;
        }

        dp = new int[m+1][n+1][len];
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(m, n, 0, count);
    }

    private int solve(int m, int n, int idx, int count[][]){
        if(idx >= count.length || (m == 0 && n == 0)){
            return 0;
        }

        if(dp[m][n][idx] != -1){
            return dp[m][n][idx];
        }

        int pick = 0;
        if(count[idx][0] <= m && count[idx][1] <= n){
            pick = 1 + solve(m - count[idx][0], n - count[idx][1], idx+1, count);
        }

        int notPick = solve(m, n, idx+1, count);

        return dp[m][n][idx] = Math.max(pick, notPick);
    }
}
