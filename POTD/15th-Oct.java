// Calculating the answer using continous length calcution taking two variable and traking the length of previous subarray and current subarray
class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int prev = 0;
        int idx = 1;
        int maxi = 0;
        for(int i=1; i<n; i++){
            if(nums.get(i) > nums.get(i-1)){
                idx++;
            }else{
                prev = idx;
                idx = 1;
            }
            maxi = Math.max(maxi, (idx/2));
            maxi = Math.max(maxi, Math.min(prev, idx));
        }
        return maxi;
    }
}
