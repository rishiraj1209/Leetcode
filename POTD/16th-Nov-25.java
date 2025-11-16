class Solution {
    public int numSub(String s) {
        int n = s.length();
        int ans = 0;
        int mod = 1000000007;
        int count = 0;
        for(int i=0; i<n; i++){
            if(s.charAt(i) == '1'){
                count++;
            }else{
                count = 0;
            }
            ans = (ans + count) % mod;
        }
        return ans;
    }
}
