class Solution {
    public int findFinalValue(int[] nums, int original) {
        boolean isTrue = true;
        while(isTrue){
            isTrue = search(nums, original);
            if(isTrue){
                original *= 2;
            }
        }
        return original;
    }

    private boolean search(int nums[], int original){
        for(int i=0; i<nums.length; i++){
            if(nums[i] == original){
                return true;
            }
        }
        return false;
    }
}
