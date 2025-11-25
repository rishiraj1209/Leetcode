class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int count = 0;
        for(int i=1; i<n; i++){
            if(colors.charAt(i) == colors.charAt(i-1)){
                count += Math.min(neededTime[i], neededTime[i-1]);
                neededTime[i] = Math.max(neededTime[i],neededTime[i-1]);
                // this line is for assuring that next time the element is compared to the one which is not removed
            }
        }
        return count;
    }
}
