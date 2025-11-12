class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int count1 = 0;
        for(int num: nums){
            if(num == 1){
                count1++;
            }
        }

        if(count1 > 0){
            return n - count1;
        }

        int minOperationToOne = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            int gcdVal = nums[i];
            for(int j=i+1; j<n; j++){
                gcdVal = gcd(gcdVal,nums[j]);

                if(gcdVal == 1){
                    minOperationToOne = Math.min(minOperationToOne, j - i); 
                    break;
                }
            }
        }
        // this gives how many steps required to make first one because 
        // after that it's simple just do the gcd with one for every number so that many steps in total

        if(minOperationToOne == Integer.MAX_VALUE) return -1;
        else{
            return minOperationToOne + (n-1);
        }
    }

    private int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
