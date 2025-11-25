class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int count[] = new int[n];
        count[0] = s.charAt(0) == '1'? 1 : 0;
        for(int i=1; i<n; i++){
            count[i] = count[i-1] + (s.charAt(i) == '1'? 1 : 0);
        }

        int ans = 0;

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                int countOne = count[j] - (i-1 >= 0 ? count[i-1]:0);
                int countZero = (j-i+1) - countOne;

                int zeroSquare = countZero*countZero;
                if(zeroSquare > countOne){
                    j += (zeroSquare - countOne) - 1;
                }else if(zeroSquare == countOne){
                    ans++;
                }else{
                    ans++;
                    int k = (int)Math.sqrt(countOne) - countZero;
                    int next = j+k;
                    if(next >= n){
                        ans += n-j-1;
                        break;
                    }else{
                        ans += k;
                    }
                    j = next;
                }
            }
        }
        return ans;
    }
}
