class Solution {
    public int maxOperations(String s) {
        int ans = 0;
        int count1 = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '1'){
                count1++;
            }else if (i > 0 && s.charAt(i-1) == '1'){
                ans += count1;
            }
        }
        return ans;
    }
}
