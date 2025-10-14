class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int prevInc = 0; int inc = 1;
        for(int i=1; i<nums.size(); i++){
            if(nums.get(i) > nums.get(i-1)){
                inc++;
            }else{
                prevInc = inc;
                inc = 1;
            }
            
            if(inc == 2*k || (inc>=k && prevInc>=k)){
                return true;
            }
        }
        return false;
    }
}
