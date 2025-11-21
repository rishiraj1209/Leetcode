class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int first[] = new int[26];
        int last[] = new int[26];
        Arrays.fill(first,-1);
        Arrays.fill(last,-1);

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(first[ch-'a'] == -1){
                first[ch - 'a'] = i;
            }
            last[ch - 'a'] = i;
        }
        int ans = 0;
        for(int i=0; i<26; i++){
            if(first[i] != -1 && first[i] < last[i]){
                boolean seen[] = new boolean[26];
                for(int j=first[i]+1; j<last[i]; j++){
                    int mid = s.charAt(j) - 'a';
                    if(seen[mid] == false){
                        seen[mid] = true;
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
