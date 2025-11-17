class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int n = nums.length;
        int lastIdx = -1;
        for(int i = 0; i<n; i++){
            if(nums[i] == 1){
                if(lastIdx >= 0 &&  (i - lastIdx - 1) < k){
                    return false;
                }
                lastIdx = i;
            }
        }
        return true;
    }
}
