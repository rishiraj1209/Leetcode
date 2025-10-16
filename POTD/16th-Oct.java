// we will use a greedy approach to find the smallest missing non-negative integer after operations
class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int n = nums.length;
        int freq[] = new int[value];
        for(int num : nums){
            int r = ((num % value)+value) % value;
            freq[r]++;
        }
        int idx = 0;
        while(freq[idx % value]-- > 0){
            idx++;
        }
        return idx;
    }
}
